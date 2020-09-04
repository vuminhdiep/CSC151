package hwk2;

/**
 * ListNode is a building block for a linked list of data items
 * 
 * @author C. Fernandes
 * @version 9/30/2017
 */
public class ListNode
{
    public String data;      
    public ListNode next;  
    
    /** Non-default constructor
     * 
     * @param value a reservation you want stored in this node
     */
    public ListNode(String value)
    {
        data = value;
        next = null;
    }
    
    /**
     * returns data as a printable string
     */
    public String toString()
    {
        return data;
    }
}
    