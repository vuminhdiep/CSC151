/**
 * Demo of the Binary Search Tree ADT.
 * This one only works with ints.
 * 
 * @author Chris Fernandes
 * @version 3/3/14
 */
public class BinarySearchTree
{
	private BSTNode root;
	
	/**
	 * Default constructor
	 */
	public BinarySearchTree() {
		root=null;
	}
         
	/**
	 * inserts newNode into tree rooted at startingNode.
	 * Returns root of that tree with newNode inserted.
	 * 
	 * @param startingNode
	 * @param newNode
	 * @return root of tree with node inserted
	 */
	private BSTNode insert(BSTNode startingNode, BSTNode newNode) {
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
	 * @param K int to insert
	 */
	public void insert(int K) {
		BSTNode newNode = new BSTNode(K);
		root=insert(root,newNode);
	}
	
	
	
	
	
	/**
	 * deletes victim from tree rooted at subroot
	 * 
	 * @param subroot
	 * @param victim
	 * @return pointer to same part of tree but with victim removed
	 * 
	 */
//	private BSTNode delete(BSTNode subroot, Integer victim) {
//		if (subroot == null)  { // victim not there
//			return subroot;
//		}
		// else if victim is on left of subroot
		// search for victim in left subtree
		// else if victim is on right of subroot
		// search for victim in right subtree
		// else found the victim!!!  {
		//   if victim is a leaf
		//      return null (tree is now empty if tree looked at is just victim)
		//   if victim has only one left subtree
		//      return subroot's left child
		//   (similar for right subtree only)
		//   else victim has 2 subtrees
		//        find a replacement for the victim
		//        replace victim node's data with replacement's data
		//        delete the replacement
		//        return subroot
		// }
//	}

//



	/**
	 * NOTE: CRAPPY METHOD!  I wish I had toString...
	 * 
	 * Recursive helper method of print.
	 * Uses inorder tree traversal algorithm.
	 * @param N subroot of tree to print
	 */
	private void printNode(BSTNode N) {
		if (N != null) {      // do nothing if the node is null
			System.out.print("(");
			printNode(N.llink);
			System.out.print("  " + N.key + "  ");
			printNode(N.rlink);
			System.out.print(")");
		}
	}


	/** 
	 * NOTE: CRAPPY METHOD!  I wish I had toString...
	 * 
	 * prints a parenthesized version
	 * of the tree showing the subtree structure
	 */
	public void print() {
		printNode(root);
		System.out.println();
	}
}
