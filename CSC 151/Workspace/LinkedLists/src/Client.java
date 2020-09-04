public class Client {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        System.out.println("Linked list contains: " + ll);
        System.out.println("ll length is: " + ll.getLength());

        ll.insertAtHead(36);

        System.out.println("Linked list contains: " + ll);
        System.out.println("ll length is: " + ll.getLength());


    }
}
