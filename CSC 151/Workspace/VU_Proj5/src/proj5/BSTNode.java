package proj5;

/**
 * A generic BSTNode in a BST with instance variable key as the value of the node and left, right link of that node
 * @param <T>
 */
public class BSTNode<T> {
    public T key;
    public BSTNode<T> llink;
    public BSTNode<T> rlink;

    /**
     * non-default constructor
     * @param data string that node will hold
     */
    public BSTNode(T data){
        key = data;
        llink = null;
        rlink = null;

    }

    /**
     * check if the node is the leaf (last item with no children) in a BST
     * @return true if both left and right link point to null; else false
     */
    public boolean isLeaf() {
        return this.llink == null && this.rlink == null;
    }

    /**
     * check if the node has only one child on the right
     * @return true if the left link points to null but the right link points to another node; else false
     */
    public boolean hasRightChildOnly() {
        return this.llink == null && this.rlink != null;
    }


    /**
     * check if the node has only one child on the left
     * @return true if the right link points to null but the left link points to another node; else false
     */

    public boolean hasLeftChildOnly() {
        return this.llink != null && this.rlink == null;
    }


    /**
     * returns key as printable string
     */
    public String toString(){
        return key.toString() ;
    }
}
