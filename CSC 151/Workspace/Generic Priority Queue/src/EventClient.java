/**
 * Fills an array with 10 random Events and sorts using a PQ.
 * 
 * @author Chris Fernandes
 * @version 5/14/12
 */
public class EventClient
{
    public static void main(String[] args)
    {
        int n = 10;   // we sort n = 10 events
        
        Event[] A = new Event[n];
                                                  
        // initialize array A to ten random events
        for (int i = 0; i < n; i++) {
        	int day = (int)(Math.random() * 30)+1;
        	int start = ((int)(Math.random() * 12)*100)+800;
            A[i] = new Event("event"+i, 2017, 11, day, start, start+30);
        }                             
        
        // print, sort, then print again
        printArray(A);
        sort(A);
        printArray(A);            
     }
    
    // prints the array
    public static void printArray(Event[] array){
        for (int i = 0; i < array.length; i++) 
        {
          System.out.print(array[i]);
          if (i!=array.length-1)
              System.out.print(",\n");
        }
        System.out.println("\n"); 
    }
    
    // sorts using the generic PQ
    // Just put 'em all in & take 'em all out
    public static void sort(Event[] A) {
    	PriorityQueue<Event> PQ = new PriorityQueue<Event>();

    	for (int i = 0; i < A.length; i++) { 
    		PQ.insert(A[i]);
    	}
   
    	for (int i = A.length-1; i >= 0; i--) {
    		A[i] = PQ.remove(); // highest priority item removed 1st!
    	}                       
    }
}
