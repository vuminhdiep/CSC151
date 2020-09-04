package proj5;
/** This is the Generic BST ADT.
 * @author Emma Vu
 * @version 5/30/2020
 * Class Invariant: The position of the element in the BinarySearchTree is determined by
 * comparing the value of each Node, which correspond to different compareTo function
 * (compareTo of Integer is different than compareTo of String)
 * Note that Comparable is a built-in Java interface, there's no need to write a interface class
 */
public class BinarySearchTree<T extends Comparable> {
    private BSTNode<T> root;
    public BinarySearchTree(){
        root = null;
    }

    /**
     * inserts newNode into tree rooted at startingNode.
     * Returns root of that tree with newNode inserted.
     *
     * @param startingNode
     * @param newNode
     * @return root of tree with node inserted
     */
    private BSTNode<T> insert(BSTNode<T> startingNode, BSTNode<T> newNode) {
        if (startingNode == null) {
            return newNode;
        }
        // pretend that key has compareTo method
        else if (startingNode.key.compareTo(newNode.key) > 0) {
            // newNode goes on left
            startingNode.llink = insert(startingNode.llink,newNode);
            return startingNode;
        }
        else {
            // newNode goes on right
            startingNode.rlink = insert(startingNode.rlink,newNode);
            return startingNode;
        }
    }

    /**
     * inserts an int into BST
     * @param data to insert
     */
    public void insert(T data) {
        BSTNode<T> newNode = new BSTNode<T>(data);
        root=insert(root,newNode);
    }

    /**
     * Search for the element of type T in a BSTNode,
     * if the element is in the tree, return the data in that BSTNode position
     * if the element is not in the tree, return null
     * @param rootTree the BSTNode we are searching
     * @param keyword the element to search for
     * @return the data of BSTNode that position if the element is in the Node, null otherwise
     */

    private T search(BSTNode<T> rootTree,T keyword){
        if(rootTree==null){
            return null;
        }
        else{
            if(rootTree.key.compareTo(keyword) > 0) {
                return search(rootTree.llink,keyword);
            }
            else if(rootTree.key.compareTo(keyword) < 0)
                return search(rootTree.rlink, keyword);
            else
                return rootTree.key;
        }

    }

    /**
     * Search for the keyword in the tree
     * return the keyword in the tree if keyword is in the tree
     * null otherwise
     * @param keyword the keyword to search for
     * @return the keyword in the tree, if keyword is in the tree, null otherwise
     */

    public T search(T keyword){
        return search(root,keyword);
    }

    /**
     * private helper method to find the min value by going to the leftest link in a BST
     * @param rootTree
     * @return
     */
    private T minValue(BSTNode<T> rootTree)
    {
        T minv = rootTree.key;
        while (rootTree.llink != null)
        {
            minv = rootTree.llink.key;
            rootTree = rootTree.llink;
        }
        return minv;
    }

    /**
     * Delete Node holding the victim if the victim is in the Node, null otherwise
     * @param subroot the BSTNode to search for the victim
     * @param victim the victim we are searching for
     * @return the BSTNode holding the target if victim is in subroot, null otherwise
     * POST CONDITION: the BSTNode holding the victim is deleted from the subroot BSTNode
     */
    private BSTNode<T> delete(BSTNode<T> subroot, T victim){
        if(subroot == null){
            return subroot;
        }
        else if(subroot.key.compareTo(victim) > 0){
            subroot.llink = delete(subroot.llink,victim);
        }
        else if(subroot.key.compareTo(victim) < 0){
            subroot.rlink = delete(subroot.rlink,victim);
        }
        else{
            if(subroot.isLeaf()){
                return null;
            }
            else if(subroot.hasLeftChildOnly()){
                return subroot.llink;
            }
            else if(subroot.hasRightChildOnly()){
                return subroot.rlink;
            }
            else{
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                subroot.key = minValue(subroot.rlink);

                // Delete the inorder successor
                subroot.rlink = delete(subroot.rlink, subroot.key);
            }
        }
        return subroot;
    }

    /**
     * Delete key from the tree
     * @param key The key to delete
     * POSTCONDITION: nothing happens if key is not in the tree, if key is in the tree, it will be deleted/replaced
     */

    public void delete(T key)
    {
        root = delete(root, key);
    }
    /**
     * Return the String that represent a Node
     * @param subroot the Node to get the String
     * @return The String representing the Node
     */
    private String toString(BSTNode<T> subroot){
        String printStr = "";
        if(subroot != null){
            printStr = "(" + toString(subroot.llink) + " " + subroot.toString() + " " + toString(subroot.rlink) + ")";
        }
        return printStr;
    }
    /**
     * return the String
     * @return a String representing the tree
     */
    public String toString(){
        return toString(root);
    }

    /**
     * Return the String that represent a Node in correct increasing alphabetical order
     * @param subroot the Node to get the String
     * @return The String representing the Node
     */
    private String toStringOrder(BSTNode subroot){
        String printStr = "";
        if (subroot!= null) {

            printStr = toStringOrder(subroot.llink) + subroot + "\n" + toStringOrder(subroot.rlink);
        }
        return  printStr;
    }

    /**
     * return the String of the elements in the tree in correct increasing alphabetical order
     * @return a String representing the element in increasing order.
     */
    public String toStringOrder()
    {
        if (root == null){
            return "";
        }
        else {
            String printStr = toStringOrder(root);
            String returnedString = printStr.substring(0, printStr.length() - 1);
            return  returnedString + "\n";
        }
    }

    private int height(BSTNode subroot) {
        if (subroot == null) {
            return -1;
        } else {
            int leftHeight = height(subroot.llink);
            int rightHeight = height(subroot.rlink);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }
    public int height(){
            return this.height(root);
        }





    }
