package Heap;

public class Client {

    public static void main(String[] args) {

        int[] unsorted = new int[]{2,66,9,33,7,4,8,99,103,2,5,1,12};

        System.out.println("Unsorted Array");
        for(int i=0; i<unsorted.length; i++){
            System.out.print(unsorted[i] + " ");
        }

        // Create a sorter object
        // pass unsorted as argument to pqSort method
        // notice how that method turns a max heap
        // into an ascending order sorted list

        Sorter sortDemo = new Sorter();
        int[] sorted = sortDemo.priorityQueueSort(unsorted);

        System.out.println("\nSorted Array");

        for(int i=0; i<sorted.length; i++){
            System.out.print(sorted[i] + " ");
        }

    }

}
