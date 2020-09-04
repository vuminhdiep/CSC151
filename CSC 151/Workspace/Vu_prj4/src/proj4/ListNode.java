package proj4;

/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object.
 * This is an implementation of generic type list node
 *
 * This is the only class where I'll let you use public instance variables.
 * @author Emma Vu
 * @version 5/29/2020
 */
public class ListNode<T>
{
    public T data;
    public ListNode next;

    /**
     * non-default constructor creating a single generic type node
     * @param new_data the initial generic type data to assign for the node
     */
    public ListNode(T new_data)
    {
        data = new_data;
        next = null;
    }

    /**
     * print out the representation of a single node in toString()
     * @return the representation of that node's data in string
     */
    
    public String toString(){
    	return data.toString();
    }

}
