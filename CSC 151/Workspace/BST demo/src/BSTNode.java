/**
 * A very un-reusable node.  It only holds ints.
 * 
 * @author Chris Fernandes
 * @version 3/3/14
 */
public class BSTNode
{
    public Integer key;
    public BSTNode llink;
    public BSTNode rlink;
    
    public BSTNode(int data){
    	key=data;  // autoboxing!
    	llink=null;
    	rlink=null;
    }
    
    public String toString() {
    	return "" + key;
    }
    
    public boolean isLeaf() {
    	return this.llink == null && this.rlink == null;
    }
    
    public boolean hasRightChildOnly() {
    	return this.llink == null && this.rlink != null;
    }
    
    public boolean hasLeftChildOnly() {
    	return this.llink != null && this.rlink == null;
    }
                              
}
