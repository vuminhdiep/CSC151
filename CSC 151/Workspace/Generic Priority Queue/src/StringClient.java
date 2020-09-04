/**
 * Fills an array with 10 random Strings and sorts using a PQ.
 * 
 * @author Chris Fernandes
 * @version 5/14/12
 */
public class StringClient
{
    public static void main(String[] args)
    {
        // initialize array A to ten random strings
        String[] A = {"Ken", "Pam", "Meg", "Jan",  "Ned",
                "Peg", "Deb", "Jim",  "Amy", "Tom"};
                                                                              
        // print, sort, then print again
        printArray(A);
        sort(A);
        printArray(A);            
     }
    
    // prints the array
    public static void printArray(String[] array){
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
    public static void sort(String[] A) {
    	PriorityQueue<String> PQ = new PriorityQueue<String>();

    	for (int i = 0; i < A.length; i++) { 
    		PQ.insert(A[i]);
    	}
   
    	for (int i = A.length-1; i >= 0; i--) {
    		A[i] = PQ.remove(); // highest priority item removed 1st!
    	}                       
    }
}
