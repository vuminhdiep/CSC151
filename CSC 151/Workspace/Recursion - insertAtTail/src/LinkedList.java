
/**
 * The linked list class gives you access to the beginning of a linked
 * list through a private instance variable called firstNode.  This class
 * should contain all of the methods for general manipulation of linked lists:
 * traversal, insertion, deletion, searching, etc.
 * 
 * @author Chris Fernandes
 * @version 2/14/18
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
    
    /** recursive helper method for summing the LL
     * 
     *  The sum of an LL is either:
     *  0 if the LL that startingNode points to is empty OR
     *  whatever startingNode holds + the sum of the LL that starts at startingNode.next
     * 
     * @param startingNode the node of the list to start summing at
     * @return the sum of the sublist that starts at startingNode
     */
    private int sum(ListNode startingNode) {
    	if (startingNode == null) {
    		return 0;
    	}
    	else {
    		return startingNode.data + sum(startingNode.next);
    	}
    	
    	
    }

    /** recursive sum of LL elements
     * 
     * @return total of ints in LL
     */
    public int sum() {
    	return sum(firstNode);
    }
    
    /*********************************************************/
    
    /** insert new data at end of list: iterative version
     * 
     * @param newData int to insert
     */
    public void insertAtTail(int newData)
    {
    	ListNode newNode = new ListNode(newData);
        if (getLength() == 0)
        {
            firstNode=newNode;
        }
        else {
            ListNode runner = firstNode;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        length++;
    }
    
    public void insertAtTailR(int newData){
    	ListNode n = new ListNode(newData);
    	firstNode = insertAtTailR(firstNode,n);
    	length++;
    }
    
    /**
     * Returns a pointer to the LL starting at sublist that has newnode inserted at the end.
     * It does this by either:
     * returning a pointer to newnode if sublist is pointing at an empty LL OR
     * returning a pointer to sublist that is itself pointing to a (smaller) list 
     * that has newnode inserted at the end.
     * @param sublist  pointer to list to insert into
     * @param newnode  node to insert at end
     * @return a pointer to the LL starting at sublist that has newnode inserted at the end
     */
    private ListNode insertAtTailR(ListNode sublist, ListNode newnode){
    	if (sublist == null) {
    		return newnode;
    	}
    	else {
    		sublist.next = insertAtTailR(sublist.next,newnode);
    		return sublist;
    	}
    }

    /** return linked list as printable string
     * 
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode n;
    	n=firstNode;
    	while (n!=null)
    	{
    		toReturn = toReturn + n;  //call node's toString automatically
    		n=n.next;
    		if (n!=null)
    		{
    			toReturn = toReturn + ", ";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * getter
     * 
     * @return number of nodes in LL
     */
    public int getLength() { return length; }
}