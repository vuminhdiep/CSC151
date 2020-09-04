
public class Client {


	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5};
		ArrayUtilities util = new ArrayUtilities();
		System.out.println("sum is " + util.findSum(array));
		System.out.println("sum is " + util.findSumRecursive(array));
		
	}

}
