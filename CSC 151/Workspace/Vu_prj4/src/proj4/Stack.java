package proj4;

/**
 * @author: Emma Vu - CSC151 project 4
 * @version: 5/25/2020
 * The Stack class gives you access to the top of a Stack
 * through the first element of the linkedList
 *
 * The stack is defined by LinkedList data, which is a generic type
 * The number of element of the stack is stored in an instance variable called manyItems.
 * For an empty stack, we set manyItems = 0 and default capacity = 10
 * The capacity of the stack is stored in an instance variable called capacity
 * Remove the top of the stack by removing the first element of the linkedList
 * Add to the stack by adding to the linkedList another element at Head.
 *
 * This is an implementation of a stack of generic type
 */
public class Stack<T>
{
    private LinkedList<T> data;
    private int manyItems;
    private int capacity;
    private final int INITIAL_CAPACITY = 10;

    /**
     * Create an empty stack with default constructor.
     */
    public Stack() {
        data = new LinkedList<T>();
        manyItems = 0;
        capacity = INITIAL_CAPACITY;

    }

    /**
     * Creates a new non-default stack.
     * Have to check for valid capacity. Else, set default capacity = 10
     *
     * @param initialCapacity the initial capacity of the stack. Have to be positive integer
     */
    public Stack(int initialCapacity){
        if(initialCapacity < 0){

            initialCapacity = INITIAL_CAPACITY;
        }

        capacity = initialCapacity;

        manyItems = 0;
        data = new LinkedList<T>();

    }

    /**
     * Check whether the stack is empty or not
     * @return True if the stack has 0 elements. Else, false
     */
    public boolean isEmpty() {
    	return size() == 0;
    }

    /**
     * add a new item at the top of the stack by inserting at the head of a LinkedList.
     * After adding, the number of items in the stack will increment by 1
     * @param toPush the value to add to the stack
     */
    public void push(T toPush) {
        data.insertAtHead(toPush);
        manyItems ++;

    }

    /**
     * pop the top item of the stack by removing the head of a LinkedList.
     * After removing, the number of items will decrement by 1
     * @return the popped item of the stack. If the stack is empty, return null
     */

    public T pop() {
    	if(!isEmpty()){
    	    T poppedItem = data.removeHead();
    	    manyItems--;
    	    return poppedItem;

        }
    	else{
    	    return null;
        }
    }

    /**
     * See the top of the stack by getting the head of a LinkedList.
     * POST CONDITION: after peeking, the stack remains the same
     * @return the top item of the stack
     */
    public T peek() {
    	return data.getHead();
    }

    /**
     * Get the size of the stack
     * @return the number of elements in the stack
     */

    public int size() {
    	return manyItems;
    }
    /**
     * return the String represent the Stack. If the stack is empty, the string representation is "{>}"
     * Else, the string representation will be "{>A,B,C}", etc. where each item of the stack is separated by a comma
     * and ">A" indicates the top of the stack
     * @return String represent Stack and the top of the stack
     */

    public String toString() {

        String printToString = "{>}";
        if(!isEmpty()){
            printToString = toStringOfNonEmpty();
        }
        return printToString;

}

    /**
     * private method to return the string of a non-empty stack. Each item of the stack will be separated by a comma
     * ">" indicates the item at the top of the stack
     * @return the string representation of a non-empty stack
     */

    private String toStringOfNonEmpty(){

        String printStr = "{>";
        for (int i = 0; i < size(); i++){

            printStr += data.getItemAt(i);
            if(i < size()-1){
                printStr += ",";
            }
        }
        printStr += "}";
        return printStr;
    }

    /**
     * get the capacity of the stack
     * @return the capacity (the maximum items) the stack can hold
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Increase the stack's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the stack
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (getCapacity() < minCapacity) {
            capacity = minCapacity;
        }
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





}
   

