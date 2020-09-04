package Heap;

/**
 * The Heap ADT.  This is a max heap.
 *
 */
public class Heap
{
	private int[] itemArray;    //binary tree of ints in array form (element 0 not used) 
	private int nodes;          //number of nodes in the tree

	/**
	 * Builds a heap from an array of ints.
	 *
	 * @param items 
	 *            an array of ints(starting at index 0), which will be 
	 *            interpreted as a binary tree.
	 */
	public Heap(int[] items)
	{
		itemArray = new int[items.length + 1];
		nodes = items.length;

		for (int i = 0; i < nodes; i++) {
			itemArray[i + 1] = items[i];
		}

		buildAHeap();
	}

	/**
	 * @return number of nodes in the heap.
	 */
	public int size()
	{
		return nodes;
	}

	/**
	 * Constructs a heap from the given binary tree (given as an array).  
	 * Heapifies each internal node in reverse level-by-level order.
	 */
	private void buildAHeap()
	{
		for (int i = nodes/2; i >= 1; i--) {
			heapify(i);
		}
	}

	/** string representation of a heap that looks (a little) like a tree
	 * @return string with one int on 1st line, two ints on 2nd line, four ints on 3rd line, etc.
	 */
	public String toString()
	{
		String result = "\n";
		int lastNodeOnLevel = 1;

		for (int i = 1; i < nodes; i++)
		{
			result += itemArray[i];
			if (i == lastNodeOnLevel) {
				result += "\n";
				lastNodeOnLevel = lastNodeOnLevel * 2 + 1;
			} else {
				result += " ";
			}
		}
		result += itemArray[nodes];

		return result;
	}

	/**
	 * Turns a subtree into a heap, assuming that only the root of that subtree 
	 * violates the heap property.
	 *
	 * @param startingNode 
	 * 			the index of the node to start with.  This node 
	 * 			is the root of a subtree which must be turned into a heap.
	 */
	private void heapify(int startingNode)
	{
        int biggerChild;                //index of bigger child
        while (!isLeaf(startingNode))
        {
            biggerChild = getBiggerChild(startingNode);
            if (outOfOrder(startingNode, biggerChild))
            {
                swap(startingNode,biggerChild);
            }
            startingNode = biggerChild;
        }
	}
	
	/** Returns true if node at index i is a leaf, else returns false.
	 * 
	 * @param i index of node in array
	 * @return true if leaf, else false
	 */
	private boolean isLeaf(int i) {
		return 2*i > nodes;
	}
	
	/** Returns true if parent and child out of maxheap order, else returns false
	 * 
	 * @param parent index of parent
	 * @param child index of child
	 * @return true if node at parent is smaller than node at child
	 */
	private boolean outOfOrder(int parent, int child) {
		return itemArray[parent] < itemArray[child];
	}
	

	/** Returns the index of the bigger child of the given parent node.
	 *  This method will take care of the case where only a left kid exists
	 * 
	 *  @param parent index of parent node
	 *  @return index of the bigger child of itemArray[parent]
	 */
    private int getBiggerChild(int parent)
    {
        if (nodes < parent*2 + 1)     //if right kid doesn't exist
                return parent * 2;
        else
        {
            if (itemArray[parent*2] > itemArray[parent*2+1])
                return parent * 2;
            else
                return parent * 2+1;
        }
    }
    
    /** 
     * swaps the items in itemArray[index1] and itemArray[index2]
     */
    private void swap(int index1, int index2)
    {
        int temp = itemArray[index1];
        itemArray[index1] = itemArray[index2];
        itemArray[index2] = temp;
    }
	
	/**
	 * Removes the root from the heap, returning it.  The resulting array is 
	 * then turned back into a heap. 
	 *
	 * @return the root value.
	 */
	public int deleteRoot()
	{
        int root = itemArray[1]; // return this at end
        itemArray[1]=itemArray[nodes];  // put node at end of array at root
        nodes--;
        heapify(1);  // re-heapify at root since root violates heap property
        return root;

	    //return 0;  delete this line
	}

}
