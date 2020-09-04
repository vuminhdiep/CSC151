
public class Client {


	public static void main(String[] args) {
		LinkedList L = new LinkedList();
        int number;
        
        //let's make 5 nodes and add them to the list
        for (int i=1; i<=5; i++)
        {
            number = (int)(10*Math.random());
            L.insertAtTailR(number);
            System.out.println("after insertion #" + i + ":");
            System.out.println(L);
        }
        System.out.println("Sum of above is " + L.sum());

	}

}
