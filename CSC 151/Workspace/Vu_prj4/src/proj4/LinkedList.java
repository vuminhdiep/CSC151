package proj4;

/**
 *  Emma Vu - Project 4
 * @version 5/23/2020
 * LinkedList is a collection of data nodes. All methods here relate to how one can manipulate those nodes
 * The LinkedList class gives the access to the beginning of a LinkedList through instance variable called firstNode
 * The length of the LinkedList (number of the items) is stored in an instance variable called length
 * The last Node of the list has variable next = null
 * The LinkedList is defined by the firstNode.
 * The second node is referred by firstNode.next, the third node is referred by firstNode.next.next, etc.
 * When we reach the last node of the LinkedList, the last node.next will be null.
 * For an empty LinkedList to start with, the default is length = 0 and firstNode = null
 * This is an implementation of generic type Linked List
 */
public class LinkedList<T>
{
    //Instance variables
    private int length;
    private ListNode<T> firstNode;

    //Default constructor
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /**
     * get the length of the LinkedList
     * @return length
     */
    public int getLength()
    {
        return length;
    }

    /** insert new String at linked list's head
     *
     * @param data the String to be inserted
     *
     */

    public void insertAtHead(T data)
    {
    	ListNode<T> newNode = new ListNode(data);
        if (isEmpty())
        {
            firstNode=newNode;
        }
        else
        {
            newNode.next=firstNode;
            firstNode=newNode;
        }
        length++;
    }


    /**
     * return the String that denotes the elements in the list with correct order
     * @return The list of element in correct order
     */
	public String toString(){ 
		String toReturn = "(";
		ListNode<T> runner = firstNode;
		while(runner != null){
			toReturn = toReturn + runner;
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}

    /**
     * Check if the List if empty or not
     * @return true if length is > 0, false otherwise
     */
	public boolean isEmpty(){
        return getLength() == 0;
    }

    /** insert data at end of list
     *
     * @param newData new String to be inserted
     */
    public void insertAtTail(T newData)
    {
        ListNode<T> insertNode = new ListNode(newData);
        if(isEmpty()){
            firstNode = insertNode;
        }
        else{

            ListNode<T> runner = firstNode;

            while(runner.next!=null){
                runner = runner.next;
            }
            runner.next = insertNode;

        }
        length++;
    }

    /**
     * search for first occurrence of value and return index where found
     *
     * @param value string to search for
     * @return index where string occurs (first node is index 0).  Return -1 if value not found.
     */
    public int indexOf(T value)
    {   int index = 0;

        ListNode<T> runner = firstNode;
        while(runner!= null){
            if (runner.data.equals(value)){
                return index;
            }
            else{
                runner = runner.next;
                index ++;
            }
        }
        return -1;

    }

    /**
     * Remove element at specific index. If the linkedlist is empty, do nothing
     * If the index is invalid (< 0 or > linkedlist.length), then do nothing
     * If the index is at the beginning of the linkedlist, remove the head of the linkedlist
     * If the index is at the end of the linkedlist, remove the tail of the linkedlist
     * After removing, the length will decrement by 1
     * @param index the index of the element want to remove
     */

    public void removeAtIndex(int index){
        if(!isEmpty()){
            removeAtIndexNonEmpty(index);
        }

    }

    /**
     * remove the element at the end of the linkedlist
     * if the linkedlist is empty, do nothing.
     * If the linkedlist has one element, then after removing the linkedlist becomes empty
     * after removing, the length will decrement by 1
     */

    public void removeTail(){
        if(isEmpty()){
            return;
        }
        if(firstNode.next == null){
            firstNode = null;
            length = 0;
            return;
        }
        ListNode<T> runner = firstNode;
        while(runner.next.next!=null){
            runner = runner.next;
        }
        runner.next = null;
        length --;


    }

    /** remove and return data at the head of the list
     *
     *  @return the String the deleted node contains.  Returns null if list empty.
     */
    public T removeHead()
    {
        if(isEmpty()){
            return null;
        }
        else{
            T remove = firstNode.data;
            firstNode = firstNode.next;
            length--;
            return remove;
        }

    }

    /**
     * Get the Data of the Node at a specified position
     * @param index the position to get the data
     * @return null for invalid index, and the data otherwise
     */


    public T getItemAt(int index){
        if(!isEmpty() && index >= 0 && index < getLength()){

            return getNodeAt(index).data;
        }
        else{
            return null;
        }
    }

    /**
     * Get the ith Node in the LinkedList
     * @param index the position of the node to get
     * @return the Node at position index
     */
    private ListNode<T> getNodeAt(int index){
        ListNode<T> nodeToGet = firstNode;
        int count = 0;
        while(nodeToGet != null && count < index){
            nodeToGet = nodeToGet.next;
            count++;
        }
        return nodeToGet;



    }

    /**
     * A private helper method to remove the element at specific index of a non-empty linkedlist
     * Removing by running the pointer to the wanted index and then storing pointer to the next of node to be deleted
     * After that, unlink the deleted node from linkedlist. After removing, the length will decrement by 1
     *
     * If the index is invalid (< 0 or > linkedlist.length), then do nothing
     * If the index is at the beginning of the linkedlist, remove the head of the linkedlist
     * If the index is at the end of the linkedlist, remove the tail of the linkedlist
     *
     * @param index the index of the element want to remove
     */


    private void removeAtIndexNonEmpty(int index){
        if (index == 0) {
            removeHead();
        }
        else if (index == getLength()) {
            removeTail();
        }
        else if (index > getLength() || index < 0){
            return;
        }
        else {
            ListNode<T> runner = firstNode;
            int counter = 0;
            while(runner!=null && counter < index-1){
                runner = runner.next;
                counter++;

            }

            ListNode<T> temp = runner.next.next;


            runner.next = temp;
            length--;
        }
    }

    /**
     * Insert a new Node at a specified position of the list, with the specified Data
     * After inserting, the length will increment by 1
     * Inserting by having current node in the wanted index moving right to one position
     * and having the node with the wanted value be inserted in the wanted index
     *
     * If the index is invalid (< 0 or > linkedlist.length), then do nothing
     * If the index is at the beginning of the linkedlist, insert at the head of the linkedlist
     * If the index is at the end of the linkedlist, insert at the tail of the linkedlist
     *
     * @param value The data of the new Node
     * @param index The position to insert that new Node
     */
     public void insertAtIndex(T value, int index) {
        ListNode<T> nodeToInsert = new ListNode(value);
        if(isEmpty()){
            firstNode = nodeToInsert;
        }

         if (index == 0) {
             insertAtHead(value);
         }
         else if(index == getLength()) {
             insertAtTail(value);
         }
         else if(index < 0 || index > getLength()){
             return;
         }
         else{
             ListNode<T> temp = getNodeAt(index - 1).next;
             getNodeAt(index - 1).next = new ListNode(value);
             getNodeAt(index - 1).next.next = temp;
             length ++;
         }
     }

    /**
     * get the data of the firstNode of a LinkedList. If the LinkedList is empty, return null
     * @return the data of firstNode in generic type
     */
     public T getHead(){
         if(!isEmpty()){
             return firstNode.data;
         }
         else{
             return null;
         }
     }




}


