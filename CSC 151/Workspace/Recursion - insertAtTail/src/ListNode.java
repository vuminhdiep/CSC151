
/**
 * Standard ListNode holding an int
 *
 * This is the only class where I'll let you use public instance variables.
 * 
 * @author Chris Fernandes 
 * @version 10/27/08
 */
public class ListNode
{
    //only your node instance vars can be public
    public int data;
    public ListNode next;

    public ListNode(int new_int)
    {
        this.data = new_int;
        this.next=null;
    }

    //automatically gets called when you try to print a ListNode
    //to System.out
    public String toString()
    {
        return "" + data;
    }

}
