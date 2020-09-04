package Heap;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
//import com.gradescope.jh61b.grader.GradedTest;
import org.junit.rules.Timeout;


public class HeapTest {

	@Rule
    public Timeout timeout = Timeout.millis(100);
    
    @Test
//	@GradedTest(name="buildAHeap out of {5,7,12}", max_score=1, number="1")
    public void test_heap1() {
    	int[] anArray = {5,7,12};	
        Heap sample = new Heap(anArray);
		String msg = "Test of single swap with 2 levels: should return \n12\n7 5";
    	assertEquals(msg, "\n12\n7 5", sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {11,12,5,1,23,33,9,21,14,10,4}", max_score=1, number="2")
    public void test_heap2() {
    	int[] anArray = {11, 12, 5, 1, 23, 33, 9, 21, 14, 10, 4};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of single swap with >2 levels: should return \n33\n23 11\n21 12 5 9\n1 14 10 4";
    	assertEquals(msg,"\n33\n23 11\n21 12 5 9\n1 14 10 4",sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {4,12,18,41,57,9,2,50,48,13,88}", max_score=1, number="3")
    public void test_heap3() {
    	int[] anArray = {4,12,18,41,57,9,2,50,48,13,88};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of multiple swaps: should return \n88\n57 18\n50 13 9 2\n41 48 4 12";
    	assertEquals(msg,"\n88\n57 18\n50 13 9 2\n41 48 4 12",sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {1,7,4,6,5,2,9}", max_score=1, number="4")
    public void test_heap4() {
    	int[] anArray = {1,7,4,6,5,2,9};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of balanced tree: should return \n9\n7 4\n6 5 2 1";
    	assertEquals(msg,"\n9\n7 4\n6 5 2 1",sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {1,5}", max_score=1, number="5")
    public void test_heap5() {
    	int[] anArray = {1,5};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of 2-node tree: should return \n5\n1";
    	assertEquals(msg,"\n5\n1",sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {42}", max_score=1, number="6")
    public void test_heap6() {
    	int[] anArray = {42};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of 1-node tree: should return 42";
    	assertEquals(msg,"\n42",sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {1,2,3,4,5}", max_score=1, number="7")
    public void test_heap7() {
    	int[] anArray = {1,2,3,4,5};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of sorted list so maximum swaps: should return \n5\n4 3\n1 2";
    	assertEquals(msg,"\n5\n4 3\n1 2",sample.toString());
    }
    
    @Test
//	@GradedTest(name="buildAHeap out of {8,15,12,3,2,7,25,36}", max_score=1, number="8")
    public void test_heap8() {
    	int[] anArray = {8,15,12,3,2,7,25,36};	
        Heap sample = new Heap(anArray);
    	String msg = "Test of tree where one node as no right child: should return \n36\n15 25\n8 2 7 12\n3";
    	assertEquals(msg,"\n36\n15 25\n8 2 7 12\n3",sample.toString());
    }
    
    @Test
//	@GradedTest(name="sort {11,12,5,1,23,33,9,21,14,10}", max_score=1, number="9")
    public void test_sort_noDuplicates() {
    	int[] unsorted = {11,12,5,1,23,33,9,21,14,10};	
    	int[] sorted = Sorter.priorityQueueSort(unsorted);
        int[] answer = {1,5,9,10,11,12,14,21,23,33};
    	String msg = "Sort random numbers with no duplicates";
    	assertArrayEquals(msg,answer,sorted);
    }
    
    @Test
//	@GradedTest(name="sort {11,12,12,1,23,33,9,1,14,10}", max_score=1, number="10")
    public void test_sort_withDuplicates() {
    	int[] unsorted = {11, 12, 12, 1, 23, 33, 9, 1, 14, 10};	
    	int[] sorted = Sorter.priorityQueueSort(unsorted);
        int[] answer = {1,1,9,10,11,12,12,14,23,33};
    	String msg = "Sort random numbers with duplicates";
    	assertArrayEquals(msg,answer,sorted);
    }
    
    @Test
//	@GradedTest(name="sort {2,3,6,11,15,16,19,22,24,26,30,35,39,44}", max_score=1, number="11")
    public void test_sort_alreadySorted() {
    	int[] unsorted = {2,3,6,11,15,16,19,22,24,26,30,35,39,44};	
    	int[] sorted = Sorter.priorityQueueSort(unsorted);
        int[] answer = {2,3,6,11,15,16,19,22,24,26,30,35,39,44};
    	String msg = "Sort array of already-sorted numbers";
    	assertArrayEquals(msg,answer,sorted);
    }
    
    @Test
//	@GradedTest(name="sort {11,11,10,9,8,7,6,4,3,2,1,0}", max_score=1, number="12")
    public void test_sort_reverseSorted() {
    	int[] unsorted = {11, 11, 10, 9, 8, 7, 6, 4, 3, 2, 1, 0};	
    	int[] sorted = Sorter.priorityQueueSort(unsorted);
        int[] answer = {0,1,2,3,4,6,7,8,9,10,11,11};
        String msg = "Sort array of reverse-sorted numbers";
        assertArrayEquals(msg,answer,sorted);
    }
    
}
