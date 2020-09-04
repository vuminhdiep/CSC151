package proj3;  // Gradescope needs this.
/**
 * Emma Vu - Project 3
 * @version 5/11/2020
 *
 * CLASS INVARIANTS: From p150 and Java objects
 *
 *  Our suggested design for the sequence ADT has four private instance variables.
 * The first variable, contents, is a LinkedList that stores the elements of the sequence. A second instance variable,
 * called manyItems, keeps track of how much of the contents is currently
 * being used. The third instance variable, currentIndex, gives the
 * index of the current element in the LinkedList (if there is one). Sometimes a sequence
 * has no current element, in which case currentIndex will be set to the same
 * number as manyItems (since this is larger than any valid index).
 * The final instance variable is capacity, which stores the capacity of the sequence.
 * Capacity should not be changed (i.e, increments by 1) after adding elements that still not outnumber the allowed capacity.
 *
 * The complete invariant of our ADT is stated as these rules:
 * 1. The number of elements in the sequence is stored in the instance variable
 * manyItems.
 * 2. For an empty sequence (with no elements), the length of the LinkedList = 0,
 * for a nonempty sequence, the ith element of the sequence is stored correspondingly to the ith element in the LinkedList
 * 3. If there is a current element, then it lies in contents.getItemAt(currentIndex); if there
 * is no current element, then currentIndex < 0 or currentIndex >= manyItems
 * By default, we set currentIndex = manyItems for an empty sequence that doesn't have a current element

 */
public class Sequence
{
    //Instance variables
	private LinkedList contents;
	private int capacity;
	private int currentIndex;
	private int manyItems;

	private final int INITIAL_CAPACITY = 10;


    /**
     * Creates a new default sequence with initial capacity 10.
     * capacity is reflected in the length of the internal LinkedList
     */
    public Sequence() {

        capacity = INITIAL_CAPACITY;

        currentIndex = manyItems;
        contents = new LinkedList();


    }


    /**
     * Creates a new non-default sequence.
     * capacity is reflected in the length of the internal LinkedList
     *
     * @param initialCapacity the initial capacity of the sequence. Have to be positive integer
     */
    public Sequence(int initialCapacity){
        if(initialCapacity < 0){

            initialCapacity = INITIAL_CAPACITY;
        }

        capacity = initialCapacity;

        currentIndex = manyItems;
        contents = new LinkedList();

    }


    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     * If the sequence has current element, there's no need to change pointer position after adding.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value)
    {
        if(size()+ 1 > getCapacity()) {
            ensureCapacity(size()*2 + 1);
        }

        if(isCurrent()){
            addAtIndex(value, currentIndex);

        }
        else{
            addAtIndex(value, 0);
            currentIndex = 0;
        }


    }


    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element
     * If the sequence has a current element, then after adding, the currentIndex will increment by 1
     * If the current element is at the end of the sequence then after adding, the size of sequence will increment by 1,
     * so the currentIndex = the old size before adding value which is at the end of the sequence
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value)
    {
        if(size() + 1 > getCapacity()) {
            ensureCapacity(size()*2 + 1);
        }

        if(isCurrent()) {
            addAtIndex(value, currentIndex + 1);

            currentIndex = currentIndex + 1;
        }
        else {
            addAtIndex(value, manyItems);

            currentIndex = manyItems - 1;
        }

    }


    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent()
    {

        return manyItems != currentIndex;
    }


    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()

    {
        return capacity;
    }


    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
        if(!isCurrent()){
            return null;
        }
        else{
            return this.contents.getItemAt(currentIndex);
        }
    }


    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (getCapacity() < minCapacity) {
            capacity = minCapacity;
        }
    }


    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make (just enough) room for
     * all of the elements to be added.
     *
     * Postcondition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another)
    {
        int bothSize = this.size() + another.size();

        if(!isCurrent()){
            currentIndex = bothSize;
        }

        if(this.size()+ another.size() > getCapacity()) {
            ensureCapacity(bothSize);
        }


        for(int i = 0; i < another.size(); i++){

            this.contents.insertAtTail(another.contents.getItemAt(i));

        }
        this.manyItems += another.manyItems;
    }


    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     */
    public void advance()
    {
        if(isCurrent()){

            currentIndex = currentIndex + 1;
        }
    }


    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     *
     * Postcondition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */

    public Sequence clone()
    {
        Sequence cloneSq = new Sequence();
        cloneSq.addAll(this);
        cloneSq.currentIndex = this.currentIndex;
        cloneSq.manyItems = this.manyItems;
        cloneSq.capacity = this.capacity;

        return cloneSq;




    }


    /**
     * Remove the current element from this sequence.  The following
     * element, if there was one, becomes the current element.  If
     * there was no following element (current was at the end of the
     * sequence), the sequence now has no current element.
     *
     * If there is no current element, does nothing.
     */
    public void removeCurrent()
    {
        if(isCurrent()){
            this.contents.removeAtIndex(currentIndex);
            manyItems--;

        }
    }


    /**
     * @return the number of elements stored in the sequence.
     */
    public int size()
    {
        return manyItems;
    }


    /**
     * Sets the current element to the start of the sequence.  If the
     * sequence is empty, the sequence has no current element.
     */
    public void start()
    {
        currentIndex = 0;
    }


    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {
        if (getCapacity() > size()){
            capacity = manyItems;
        }
    }

    /**
     * Produce a string representation of this sequence.  The current
     * location is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the current element, and the
     * capacity is 5, would print as:
     *
     *    {A, >B} (capacity = 5)
     *
     * The string you create should be formatted like the above example,
     * with a comma following each element, no comma following the
     * last element, and all on a single line.  An empty sequence
     * should give back "{}" followed by its capacity.
     *
     * @return a string representation of this sequence.
     */
    public String toString()
    {

        String printToString = "{} (capacity = " + getCapacity() + ")";

        if(!isEmpty()){
            printToString = toStringOfNonEmpty();
        }

        return printToString;
    }



    /**
     * Private helper method to print toString of a non empty sequence
     * Produce a string representation of this sequence.
     * The current location is indicated by a >.
     * For example, a sequence with "A" followed by "B", where "B" is the current element, and the capacity is 5,
     * would print as: {A, >B} (capacity = 5)
     * The string you create should be formatted like the above example, with a comma following each element,
     * no comma following the last element, and all on a single line.
     *
     * @return
     */

    private String toStringOfNonEmpty(){
        String nonEmptyString = "{";
        for(int i = 0; i < size(); i++){
            if(i == 0) {
                if (i == currentIndex) {
                    nonEmptyString = nonEmptyString + ">" + getCurrent();
                }
                else {
                    nonEmptyString = nonEmptyString + contents.getItemAt(i);
                }
            }
            else{
                if(i == currentIndex){
                    nonEmptyString = nonEmptyString + ", >" + getCurrent();

                }
                else{
                    nonEmptyString = nonEmptyString + ", " + contents.getItemAt(i);
                }
            }

        }
        nonEmptyString = nonEmptyString + "} (capacity = " + getCapacity() + ")";
        return nonEmptyString;
    }


    /**
     * Checks whether another sequence is equal to this one.  To be
     * considered equal, the other sequence must have the same size
     * as this sequence, have the same elements, in the same
     * order, and with the same element marked
     * current.  The capacity can differ.
     *
     * Postcondition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     *
     * @param other the other Sequence with which to compare
     * @return true iff the other sequence is equal to this one.
     */
    public boolean equals(Sequence other)
    {

        return this.size() == other.size() && this.currentIndex == other.currentIndex
                && this.contents.toString().equals(other.contents.toString());
    }


    /**
     *
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty()
    {

        return size() == 0;
    }


    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear()
    {
        manyItems = 0;
        currentIndex = manyItems;
        contents = new LinkedList();
    }

    /** Add value to a specified position of the LinkedList Data.
     * After adding the size will increment by 1
     * PRECONDITION: position has to be positive, position cannot be greater than length
     * POST-CONDITION: data get one extra element, at the specified position.
     * @param value The value we want to add to data
     * @param index The position we want to add.
     */
    private void addAtIndex(String value, int index){
        if(index >= 0) {

            contents.insertAtIndex(value, index);

            manyItems += 1;
        }
    }

}

