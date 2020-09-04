
/**
 * The linked list class gives you access to the beginning of a linked
 * list through a private instance variable called firstNode.  This class
 * should contain all of the methods for general manipulation of linked lists:
 * traversal, insertion, deletion, searching, etc.
 * 
 * @author Nick Webb
 * @version 4/22/2020
 */
public class LinkedList
{
    private int length;
    private ListNode firstNode;

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }
    
    /**
     * getter
     * @return number of nodes in list
     */
    public int getLength() { return length;}


    /**
     * insert data as first node in list
     * @param data to be inserted
     */
    public void insertAtHead(int data)
    {
    	ListNode newnode = new ListNode(data);
        if (getLength() == 0)
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

    /**
     *
     * @return String representation of a linked list
     */
    public String toString(){


        String toReturn = "(";
        ListNode runner;
        runner = firstNode;
        while(runner!=null){
            toReturn += runner.toString();
            runner = runner.next;
            if(runner!=null){
                toReturn += ", ";
            }
        }
        return toReturn;

    }

}