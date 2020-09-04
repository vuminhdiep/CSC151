
/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to an int.  It has one link field.
 *
 * This is the only class where I'll let you use public instance variables.
 * 
 * @author Nick Webb
 * @version 4/24/2020
 */
public class ListNode
{
    // We're deliberately making these instance vars public
    // See the logic in Linked List, and imagine how it
    // would be different if we had to include getters
    // and setters for these

    public int data;
    public ListNode next;

    public ListNode(int new_data)
    {
        this.data = new_data;
        this.next=null;
    }

    /**
     *  @return data in String format
     */
    public String toString()
    {
        return "" + data;
    }

}
