package hwk2;

/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * @author Emma Vu
 * @version 5/4/2020
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus
 */
public class LinkedList
{
    private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }


    /** insert new String at linked list's head
     * 
     * @param newData the String to be inserted
     */
    public void insertAtHead(String newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (isEmpty())
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
    
    /** remove and return data at the head of the list 
     * 
     *  @return the String the deleted node contains.  Returns null if list empty.
     */
    public String removeHead()
    {
    	if(isEmpty()){
    	    return null;
        }
    	else{
          String remove = firstNode.toString();
          firstNode = firstNode.next;
          length--;
          return remove;
        }

    }
    
    /** insert data at end of list
     * 
     * @param newData new String to be inserted
     */
    public void insertAtTail(String newData)
    {
    	ListNode insertNode = new ListNode(newData);
    	if(isEmpty()){
    	    firstNode = insertNode;
        }
    	else{

            ListNode runner = firstNode;

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
    public int indexOf(String value)
    {   int index = 0;

        ListNode runner = firstNode;
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
     *  @return return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode runner=firstNode;
    	while (runner!=null)
    	{
    		toReturn = toReturn + runner;  //call node's toString automatically
    		runner=runner.next;
    		if (runner!=null)
    		{
    			toReturn = toReturn + ",";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * 
     * @return length of LL
     */
    public int getLength() {return length;}
    
    /**
     * 
     * @return true if LL empty or false if not
     */
    public boolean isEmpty() {return getLength()==0;}
}