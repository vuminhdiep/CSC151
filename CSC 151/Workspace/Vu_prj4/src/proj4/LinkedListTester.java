package proj4;
/**
 * @author: Emma Vu
 * @version: 5/29/2020
 * JUnit test class.  Use these tests as models for your own.
 */
import org.junit.*;


import org.junit.rules.Timeout;

import static org.junit.Assert.*;

import proj4.LinkedList;

public class LinkedListTester {
    @Rule
    // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    private LinkedList<String> ll;
    @Before
    public void setUp() throws Exception {
       ll = new LinkedList<String>();
    }

    @After
    public void tearDown() throws Exception {
        ll = null;
    }

    @Test
    //Remove empty LinkedList.
    //Return null, should have 0 nodes, the content doesn't change
    public void testRemoveHeadEmpty(){

        assertNull(ll.removeHead());
        assertEquals(0,ll.getLength());
        assertEquals("()",ll.toString());
    }
    @Test
    //Remove LinkedList with one element. Return the only element after removing
    //Should have 0 nodes, the content will change
    public void testRemoveHeadOne(){

        ll.insertAtHead("A");

        String expected = (String) ll.removeHead();
        assertEquals(0,ll.getLength());
        assertEquals("A",expected);
        assertEquals("()",ll.toString());

    }
    @Test
    //Remove LinkedList with more than one element
    //The length should decrement by 1. Return the removed element.
    // Content will change
    public void testRemoveHeadNonEmpty(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        String expected = (String) ll.removeHead();
        assertEquals(3,ll.getLength());
        assertEquals("A",expected);
        assertEquals("(B, C, D)",ll.toString());




    }

    @Test
    //Remove the first element in a multiple element LinkedList even though it is identical to the others.
    //Should remove the exact element in the exact position. Length will decrement by 1.
    //Should not alter the values besides removing from the LinkedList
    public void removeHeadSameMultiple(){

        ll.insertAtHead("A");
        ll.insertAtTail("A");
        ll.insertAtTail("A");
        ll.insertAtTail("A");
        ll.insertAtTail("A");
        assertEquals("A",ll.removeHead());
        assertEquals(4,ll.getLength());
        assertEquals("(A, A, A, A)",ll.toString());

    }

    @Test
    //Remove head of a LinkedList that has two identical elements and after removing there will only be one left
    //The length should decrement by 1. Content will change
    public void testRemoveHeadSameTwice(){

        ll.insertAtHead("A");
        ll.insertAtTail("A");
        assertEquals("A",ll.removeHead());
        assertEquals(1,ll.getLength());
        assertEquals("(A)",ll.toString());
    }
    @Test
    //Insert an empty LinkedList. Then it became the first element of LinkedList
    //The length should increment by 1, content will change
    public void testInsertTailEmpty(){

        ll.insertAtTail("A");
        assertEquals(1,ll.getLength());
        assertEquals("(A)",ll.toString());

    }
    @Test
    //Insert LinkedList with more than one elements
    //The length should increment by 1
    // content will change as the inserted element will be added at the end
    public void testInsertTailNonEmpty(){

        ll.insertAtHead("C");
        ll.insertAtHead("B");
        ll.insertAtHead("A");
        ll.insertAtTail("Z");
        assertEquals(4,ll.getLength());
        assertEquals("(A, B, C, Z)",ll.toString());


    }
    @Test
    //Insert to one element LinkedList
    //The length should increment by 1
    //content will change as the inserted element will be added at the end
    public void testInsertTailOne(){

        ll.insertAtHead("A");
        ll.insertAtTail("Z");
        assertEquals(2,ll.getLength());
        assertEquals("(A, Z)",ll.toString());

    }

    @Test
    //Insert an identical element to a one-element LinkedList.
    // The LinkedList will have identical elements instead of unable to insert.
    //Length will increment by 1

    public void testInsertTailSameOne(){

        ll.insertAtHead("A");
        ll.insertAtTail("A");
        assertEquals(2,ll.getLength());
        assertEquals("(A, A)",ll.toString());


    }

    @Test
    //Insert tail of a multiple identical element LinkedList. Length and content should change
    public void testInsertTailSameMultiple(){

        ll.insertAtHead("F");
        ll.insertAtHead("F");
        ll.insertAtHead("F");
        ll.insertAtHead("F");
        ll.insertAtHead("F");
        ll.insertAtTail("F");
        assertEquals(6,ll.getLength());
        assertEquals("(F, F, F, F, F, F)",ll.toString());
    }
    @Test
    //IndexOf empty LinkedList. Return -1. Should not change LinkedList content nor the length
    public void testIndexOfEmpty(){

        assertEquals(-1,ll.indexOf("A"));
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());

    }
    @Test
    //IndexOf invalid data of one element LinkedList. Return -1
    //Should not change LinkedList content nor the length
    public void testIndexOfInvalidOne(){

        ll.insertAtHead("A");
        assertEquals(-1,ll.indexOf("B"));
        assertEquals(1,ll.getLength());
        assertEquals("(A)",ll.toString());



    }

    @Test
    //IndexOf invalid data of more than one element LinkedList. Return -1
    //Should not change LinkedList content nor the length
    public void testIndexOfInvalidMultiple(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        assertEquals(-1,ll.indexOf("E"));
        assertEquals(4,ll.getLength());
        assertEquals("(A, B, C, D)",ll.toString());



    }
    @Test
    //IndexOf one element LinkedList. Return the index of that data (0)
    //Should not change LinkedList content nor the length
    public void testIndexOfOne(){

        ll.insertAtHead("A");
        assertEquals(0,ll.indexOf("A"));
        assertEquals(1,ll.getLength());
        assertEquals("(A)",ll.toString());



    }
    @Test
    //IndexOf more than one element LinkedList
    //Should return the corresponding indexes when given valid data
    //Should not change LinkedList content nor the length
    public void testIndexOfMultiple(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        assertEquals(0,ll.indexOf("A"));
        assertEquals(1,ll.indexOf("B"));
        assertEquals(2,ll.indexOf("C"));
        assertEquals(3,ll.indexOf("D"));
        assertEquals(4,ll.getLength());
        assertEquals("(A, B, C, D)",ll.toString());
    }
    @Test
    //IndexOf identical data that appear in the LinkedList more than once.
    //Return the first occurrence of that data
    //Should not change LinkedList content nor the length
    public void testIndexOfSameMultiple(){

        ll.insertAtHead("C");
        ll.insertAtTail("C");
        ll.insertAtTail("C");
        ll.insertAtTail("C");
        ll.insertAtTail("C");
        assertEquals(0,ll.indexOf("C"));
        assertEquals(5,ll.getLength());
        assertEquals("(C, C, C, C, C)",ll.toString());



    }

    @Test
    //Get index of a LinkedList that has two identical elements. Should get the correct index (0).
    //Should not change content nor length
    public void testIndexOfSameTwice(){

        ll.insertAtHead("A");
        ll.insertAtTail("A");
        assertEquals(0,ll.indexOf("A"));
        assertEquals(2,ll.getLength());
        assertEquals("(A, A)",ll.toString());
    }

    @Test
    //Test insertAtHead to an empty LinkedList. The inserted element will be the first element in the LinkedList
    //Content will change, the length will increment by 1
    public void testInsertHeadEmpty(){

        ll.insertAtHead("A");
        assertEquals("(A)",ll.toString());
        assertEquals(1,ll.getLength());

    }
    @Test
    //Test insertAtHead to a LinkedList with one element. The length will increment by 1. Content will change
    public void testInsertHeadOne(){

        ll.insertAtTail("A");
        ll.insertAtHead("D");
        assertEquals(2,ll.getLength());
        assertEquals("(D, A)",ll.toString());

    }

    @Test
    //Test insertAtHead to a LinkedList with more than one elements. The content and length will change
    public void testInsertHeadMultiple(){

        ll.insertAtTail("S");
        ll.insertAtTail("D");
        ll.insertAtTail("A");
        ll.insertAtHead("B");
        assertEquals(4,ll.getLength());
        assertEquals("(B, S, D, A)",ll.toString());

    }

    @Test
    //Test insertAtHead to a one element LinkedList by inserting the identical element
    //The content and length will change.
    //Should insert at the beginning instead of unable to insert
    public void testInsertHeadSameOne(){

        ll.insertAtTail("D");
        ll.insertAtHead("D");
        assertEquals(2,ll.getLength());
        assertEquals("(D, D)",ll.toString());

    }

    @Test
    //Test insertAtHead of a LinkedList with multiple identical elements. Content and length should change
    public void testInsertHeadSameMultiple(){

        ll.insertAtTail("D");
        ll.insertAtTail("D");
        ll.insertAtTail("D");
        ll.insertAtTail("D");
        ll.insertAtTail("D");
        ll.insertAtHead("D");
        assertEquals(6,ll.getLength());
        assertEquals("(D, D, D, D, D, D)",ll.toString());


    }

    @Test
    //Test isEmpty of an empty LinkedList. Return true
    public void testIsEmptyTrue(){

        assertTrue(ll.isEmpty());

    }

    @Test
    //Test isEmpty of a non-empty LinkedList. Should return false
    public void testIsEmptyFalse(){

        ll.insertAtHead("F");
        ll.insertAtTail("D");
        assertFalse(ll.isEmpty());

    }

    @Test
    //Test getLength of an empty LinkedList. Return 0
    public void testGetLengthEmpty(){

        assertEquals(0,ll.getLength());
    }

    @Test
    //Test getLength of a non-empty LinkedList. Return the length
    public void testGetLengthNonEmpty(){

        ll.insertAtHead("A");
        ll.insertAtTail("R");
        assertEquals(2,ll.getLength());
    }

    @Test
    //Test toString of empty LinkedList.
    public void testToStringEmpty(){

        assertEquals("()",ll.toString());

    }

    @Test
    //Test toString of multiple elements LinkedList
    public void testToStringMultiple(){

        ll.insertAtTail("A");
        ll.insertAtTail("D");
        ll.insertAtHead("F");
        assertEquals("(F, A, D)",ll.toString());
    }

    @Test
    //Test toString of one element LinkedList
    public void testToStringOne(){


        ll.insertAtHead("F");
        assertEquals("(F)",ll.toString());
    }


    @Test
    //test getItemAt valid position. Return the data corresponding to the wanted index
    public void testGetItemAtNonEmptyValid(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.insertAtTail("E");
        ll.insertAtTail("F");
        assertEquals("F",ll.getItemAt(5));
        assertEquals("B",ll.getItemAt(1));
        assertEquals("A",ll.getItemAt(0));
        assertEquals("C",ll.getItemAt(2));
        assertEquals("D",ll.getItemAt(3));
        assertEquals("E",ll.getItemAt(4));

    }

    @Test
    //test getItemAt negative position. Return null
    public void testGetItemAtNegative(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.insertAtTail("E");
        ll.insertAtTail("F");
        assertNull(ll.getItemAt(-1));

    }


    @Test
    //test getItemAt position > the length of LinkedList. Return null
    public void testGetItemAtGreaterThanLength(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.insertAtTail("E");
        ll.insertAtTail("F");
        assertNull(ll.getItemAt(10));
    }

    @Test
    //test SearchItemAt an empty LinkedList. Return null no matter the wanted position
    public void testGetItemAtEmpty(){

        assertNull(ll.getItemAt(0));

    }
    @Test
    //Test removeTail of a non empty linkedlist. After removing the length will decrement by 1
    public void testRemoveTailNonEmpty(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.removeTail();
        assertEquals("(A, B, C)",ll.toString());
        assertEquals(3,ll.getLength());

    }

    @Test
    //Test removeTail of an empty linkedlist. Should remain the same after removing
    public void testRemoveTailEmpty(){

        ll.removeTail();
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());
    }

    @Test
    //Test removeTail One Element. After removing the linkedlist becomes empty
    public void testRemoveTailOne(){

        ll.insertAtHead("A");
        ll.removeTail();
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());
    }

    @Test
    //Test remove at index of a non-empty linkedlist with valid index. After removing, the length will decrement by 1
    public void testRemoveAtIndexValidNonEmpty(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.removeAtIndex(1);
        assertEquals(3,ll.getLength());
        assertEquals("C",ll.getItemAt(1));
        assertEquals("(A, C, D)",ll.toString());
        ll.removeAtIndex(2);
        assertEquals("(A, C)",ll.toString());
        ll.removeAtIndex(0);
        assertEquals("(C)",ll.toString());
        ll.removeAtIndex(0);
        assertTrue(ll.isEmpty());
    }

    @Test
    //Test remove at index of an empty linkedlist no matter the index is. Should remain the same

    public void testRemoveAtIndexEmpty(){

        ll.removeAtIndex(10);
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());
    }

    @Test

    //Remove at index of one-element linkedlist. After removing, the linkedlist becomes empty
    public void testRemoveAtIndexOne(){

        ll.insertAtHead("A");
        ll.removeAtIndex(0);
        assertTrue(ll.isEmpty());
    }

    @Test
    //Remove at index with invalid index (negative integer). Should remain the same

    public void testRemoveAtIndexNegative(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.removeAtIndex(-1);
        assertEquals("(A, B, C, D)",ll.toString());
    }

    @Test
    //Remove at index with index > the linkedlist.length. Should remain the same

    public void testRemoveAtIndexGreaterThan(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.removeAtIndex(10);
        assertEquals("(A, B, C, D)",ll.toString());
    }

    @Test
    //Remove at index with index == 0. Remove the head of the linkedlist
    public void testRemoveAtIndexHead(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.removeAtIndex(0);
        assertEquals("(B)",ll.toString());
    }

    @Test
    //Remove at index with index at the end of the linkedlist. Remove the tail of the linkedlist
    public void testRemoveAtIndexTail(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.removeAtIndex(1);
        assertEquals("(A)",ll.toString());
    }

    @Test
    //Remove at index with index in the middle of the linkedlist. Remove the middle element of the linkedlist
    public void testRemoveAtIndexMiddle(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.insertAtTail("E");
        ll.removeAtIndex(2);
        assertEquals("(A, B, D, E)",ll.toString());
    }






    @Test
    //Insert at index of a non empty linkedlist with valid index. The element will be inserted at the wanted index
    public void insertAtIndexValidNonEmpty(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.insertAtIndex("E",1);
        assertEquals("(A, E, B, C, D)",ll.toString());
    }

    @Test
    //Insert at index of an empty linkedlist at no matter the index is. The linkedlist will have one element
    public void insertAtIndexEmpty(){

        ll.insertAtIndex("A",-1);
        assertEquals("(A)",ll.toString());
    }

    @Test
    //Insert at index with negative index of a nonempty linkedlist. Should remain the same

    public void insertAtIndexNegative(){

        ll.insertAtHead("Hello");
        ll.insertAtTail("Goodbye");
        ll.insertAtIndex("Hi",-1);
        assertEquals("(Hello, Goodbye)",ll.toString());
    }

    @Test
    //insert at index greater than linkedlist.length. Should remain the same

    public void insertAtIndexGreater(){

        ll.insertAtHead("Hello");
        ll.insertAtTail("Goodbye");
        ll.insertAtIndex("Hi",10);
        assertEquals("(Hello, Goodbye)",ll.toString());
    }



    @Test
    //Insert at index with index == 0. Insert at the head of the linkedlist
    public void testInsertAtIndexHead(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtIndex("C",0);
        assertEquals("(C, A, B)",ll.toString());
    }

    @Test
    //Insert at index with index at the end of the linkedlist. Insert at the tail of the linkedlist
    public void testInsertAtIndexTail(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtIndex("C",2);
        assertEquals("(A, B, C)",ll.toString());
    }

    @Test
    //Remove at index with index in the middle of the linkedlist. Remove the middle element of the linkedlist
    public void testInsertAtIndexMiddle(){

        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        ll.insertAtTail("E");
        ll.insertAtIndex("F",2);
        assertEquals("(A, B, F, C, D, E)",ll.toString());
    }

    @Test
    //remove tail of a non-empty linkedlist with same elements multiple times. Length and contents will change
    public void testRemoveTailSameMultiple(){

        ll.insertAtHead("B");
        ll.insertAtTail("B");
        ll.insertAtTail("B");
        ll.insertAtTail("B");
        ll.insertAtTail("B");
        ll.insertAtTail("B");
        ll.insertAtTail("B");
        ll.removeTail();
        ll.removeTail();
        ll.removeTail();
        assertEquals("(B, B, B, B)",ll.toString());
        assertEquals(4,ll.getLength());
    }

    @Test
    //remove tail of 2 same element linkedlist. Length and contents will change
    public void testRemoveTailSameTwice(){

        ll.insertAtHead("A");
        ll.insertAtTail("A");
        ll.removeTail();

        assertEquals("(A)",ll.toString());
        assertEquals(1,ll.getLength());
    }

    @Test
    //remove tail multiple times of a non-empty linkedlist. Contents and length will change
    public void testRemoveTailMultiple(){

        ll.insertAtHead("B");
        ll.insertAtTail("D");
        ll.insertAtTail("E");
        ll.insertAtTail("F");
        ll.insertAtTail("G");
        ll.insertAtTail("H");
        ll.insertAtTail("I");
        ll.removeTail();
        ll.removeTail();
        ll.removeTail();
        assertEquals("(B, D, E, F)",ll.toString());
        assertEquals(4,ll.getLength());

    }










}
