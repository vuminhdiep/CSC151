package proj2;  // Gradescope needs this.
/**
 *
 * @author Emma Vu
 * @version 4/19/2020
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus
 *
 *CLASS INVARIANTS (From the bottom page 150 in textbook):
 *
 * Our suggested design for the sequence ADT has three private instance variables.
 * The first variable, data, is an array that stores the elements of the sequence. Just
 * like the bag, data is a partially filled array, and a second instance variable,
 * called manyItems, keeps track of how much of the data array is currently
 * being used. Therefore, the used part of the array extends from data[0] to
 * data[manyItems-1]. The third instance variable, currentIndex, gives the
 * index of the current element in the array (if there is one). Sometimes a sequence
 * has no current element, in which case currentIndex will be set to the same
 * number as manyItems (since this is larger than any valid index). The complete
 * invariant of our ADT is stated as three rules:
 *
 * 1. The number of elements in the sequence is stored in the instance variable
 * manyItems.
 *
 * 2. For an empty sequence (with no elements), we do not care what is stored
 * in any of data; for a nonempty sequence, the elements of the sequence
 * are stored from the front to the end in data[0] to data[manyItems-1],
 * and we don’t care what is stored in the rest of data.
 *
 * 3. If there is a current element, then it lies in data[currentIndex]; if there
 * is no current element, then currentIndex equals manyItems.
 *
 * if currentIndex < 0 or currentIndex >= manyItems, then the sequence doesn't have current element.
 * By default, we indicate that currentIndex = manyItems means there is no current element
 *
 */
public class Sequence
{
    /**
     * Creates a new sequence with initial capacity 10.
     */
    private final int INITIAL_CAPACITY = 10;

    private String[] data;
    private int manyItems;
    private int currentIndex;

    //default constructor
    public Sequence() {
        // capacity is reflected in the length of the
        // internal array
        data = new String[INITIAL_CAPACITY];
        manyItems = 0;
        currentIndex = 0;


    }


    /**
     * Creates a new sequence.
     *
     * @param initialCapacity the initial capacity of the sequence.
     */

    //non-default constructor
    public Sequence(int initialCapacity){
        // capacity is reflected in the length of the
        // internal

        //Make sure initialCapacity is valid (non-negative integer)
        if (initialCapacity < 0){
            initialCapacity = INITIAL_CAPACITY;
        }
        data = new String[initialCapacity];
        manyItems = 0;
        currentIndex = 0;
    }


    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value)
    {

        expandNotEnoughCapTwicePlusOne();
        if(isCurrent()){

            addToIndex(value,currentIndex);
        }
        else{
            addToIndex(value,0);
            currentIndex = 0;
        }


    }


    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value)

    {

        expandNotEnoughCapTwicePlusOne();
        if(isCurrent()){
            currentIndex += 1;
            addToIndex(value, currentIndex);

        }
        else{


            addToIndex(value,size());

            //after the addToIndex method, the size of sequence + 1
            // so the currentIndex = the old size before adding value which is at the end of the sequence

            currentIndex = size() - 1;
        }


    }


    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent()
    {
        if(currentIndex >= size()){
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
        return data.length;

    }


    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
        if (!isCurrent()){
            return null;
        }
        else{
            return data[currentIndex];

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
        if(getCapacity() < minCapacity){
            String[] increaseCapacity = new String[minCapacity];
            copyArray(data,increaseCapacity,0,getCapacity(),0);

            data = increaseCapacity;
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
    {   int bothSize = this.size() + another.size();
        if(!isCurrent()){
            currentIndex = bothSize;
        }
        if(bothSize > this.getCapacity()){
            ensureCapacity(bothSize);
        }
        copyArray(another.data,data,0,another.size(),size());


        this.manyItems = bothSize;

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

            currentIndex += 1;
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

        cloneSq.currentIndex = this.currentIndex;


        cloneSq.manyItems = size();
        String[] cloneArray = new String[getCapacity()];
        copyArray(data,cloneArray,0,getCapacity(),0);

        cloneSq.data = cloneArray;
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
    {   if(isCurrent()) {
        String[] remove = new String[getCapacity()];
        copyArray(data, remove, 0, currentIndex, 0);
        copyArray(data, remove, currentIndex + 1, size(), currentIndex);


        data = remove;
        manyItems -= 1;


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
        if(getCapacity() > size()){
            String[] trim = new String[size()];
            copyArray(data,trim,0,size(),0);

            data = trim;
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
    {   String printToString = "{} (capacity = " + getCapacity() + ")";

        if(!isEmpty()){
            printToString = toStringOfNonEmpty();
        }

        return printToString;
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
        return this.size() == other.size() &&
                this.currentIndex == other.currentIndex &&
                compareTo(other);

    }


    /**
     *
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty()
    {
        if (this.size() == 0){
            return true;
        }
        else{

            return false;

        }
    }


    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear()
    {


        manyItems = 0;

        currentIndex = size();


    }

    /**
     * Take in two arrays, copy a certain part of old array to the new one given the certain range from the old array
     * to copy and the starting index in the new array to put the copied elements consecutively to the new array
     *
     * PRECONDITION: The size of the copied elements from the old array should not exceed the capacity left in the new
     * array starting from the index in the new array that wants to copy to
     * POSTCONDITION: The old array should not be changed, now the new array has a certain part of the old array
     *
     * @param oldArrayCopyFrom the array that is copied from
     * @param newArrayCopyTo the new array that is copied to
     * @param startIndexOld the starting index in the old array to copy from
     * @param endIndexOld the ending index in the old array to copy from
     * @param startIndexNew the starting index in the new array that want to put the copied element in
     */


    private static void copyArray(String[] oldArrayCopyFrom, String[] newArrayCopyTo,
                                  int startIndexOld, int endIndexOld, int startIndexNew ){
        for (int i = 0; i < endIndexOld - startIndexOld; i++){
            newArrayCopyTo[startIndexNew + i] = oldArrayCopyFrom[startIndexOld + i];
        }

    }

    /**
     * compare if two sequences have the same elements and order
     * by going through each element in each sequence correspondingly
     * @param other other sequence to compare to
     * @return true if they both have the same elements and order; else false
     */


    private boolean compareTo(Sequence other){
        boolean compare = true;
        for(int i = 0; i < size(); i++){
            if(!this.data[i].equals(other.data[i])){
                compare = false;
            }
        }
        return compare;
    }

    /**
     * add a certain value to a specific index in the data array.
     * First create a new array and then copy the first part from the data array
     * (before the certain index) to the new array
     *
     * Then assign the value to the certain index in the new array
     * After that copy the rest (after the certain index till the end of the data array) to the new array
     * Then assign data array have the same contents as the new array (one more element added at a certain index)
     * @param value the value to add to
     * @param index the index that has the given value added
     */

    private void addToIndex(String value, int index){
        if(index >= 0) {
            String[] toAdd = new String[getCapacity()];

            copyArray(data, toAdd, 0, index, 0);
            toAdd[index] = value;
            copyArray(data, toAdd, index, size(), index+1);

            data = toAdd;
            manyItems += 1;

        }

    }

    /**
     * a private helper function used for addBefore and addAfter when the original capacity is not enough
     * so after adding one element the capacity expands twice its original capacity plus one
     */



    private void expandNotEnoughCapTwicePlusOne(){
        if(size() + 1 > getCapacity()){
            int newCapacity = 2*size() + 1;
            ensureCapacity(newCapacity);
        }
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
                    nonEmptyString = nonEmptyString + data[i];
                }
            }
            else{
                if(i == currentIndex){
                    nonEmptyString = nonEmptyString + ", >" + getCurrent();

                }
                else{
                    nonEmptyString = nonEmptyString + ", " + data[i];
                }
            }

        }
        nonEmptyString = nonEmptyString + "} (capacity = " + getCapacity() + ")";
        return nonEmptyString;
    }








}