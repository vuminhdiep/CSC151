/**
 * Fills an array with 10 random ints and sorts using a PQ.
 * 
 * @author Chris Fernandes
 * @version 5/14/12
 */
public class IntClient
{
    public static void main(String[] args)
    {
        int n = 10;   // we sort n = 10 integers
        
        int[] A = new int[n];

        // initialize the array A to ten integers
        for (int i = 0; i < n; i++) {
            A[i] = (int)(Math.random() * 100);
        }                                      
     
        // print, sort, then print again
        printArray(A);
        sort(A);
        printArray(A);           
     }
    
    // prints the array
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) 
        {
          System.out.print(array[i]);
          if (i!=array.length-1)
              System.out.print(", ");
        }
        System.out.println("\n"); 
    }
    
    // sorts using the generic PQ
    // Just put 'em all in & take 'em all out
    public static void sort(int[] A) {
    	PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();

    	for (int i = 0; i < A.length; i++) { 
    		PQ.insert(A[i]);
    	}
   
    	for (int i = A.length-1; i >= 0; i--) {
    		A[i] = PQ.remove(); // highest priority item removed 1st!
    	}                       
    }
}
