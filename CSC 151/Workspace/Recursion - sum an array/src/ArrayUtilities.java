/** demo for showing structural recursion
 * 
 * @author Chris Fernandes
 * @version 5/16/16
 */
public class ArrayUtilities {

	/** finds total of array of ints: iterative version
	 * 
	 * @param A array of ints
	 * @return sum of A[0] to A[A.length-1]
	 */
	public int findSum(int[] A)
	{
		int sum=0;
		for (int i=0; i<A.length; i++) {
			sum = sum + A[i];
		}
		return sum;
	}
	
	/** 
	 * Returns sum of the first <length> array cells of A
	 *  
	 * 
	 * @param A array of ints
	 * @param length number of array slots we are currently considering
	 * @return total of numbers from A[0] to A[length-1]
	 */
	private int findSumRecursive(int[] A, int length)
	{
		
		if (length == 0) {
			return 0;
		}
		else {
			return A[length-1] + findSumRecursive(A, length-1);
		}

	}

	
	/** finds the sum of all numbers in array A
	 * 
	 * @param A array of ints
	 * @return total of ints
	 */
	public int findSumRecursive(int[] A)
	{
		return findSumRecursive(A,A.length);
	}
}
