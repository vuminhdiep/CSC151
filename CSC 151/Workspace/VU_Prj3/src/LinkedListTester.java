/**
 * JUnit test class.  Use these tests as models for your own.
 */
import org.junit.*;


import org.junit.rules.Timeout;

import static org.junit.Assert.*;

import proj3.LinkedList;

public class LinkedListTester {
    @Rule
    // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    @Test
    //Remove empty LinkedList.
    //Return null, should have 0 nodes, the content doesn't change
    public void testRemoveHeadEmpty(){
        LinkedList ll = new LinkedList();
        assertNull(ll.removeHead());
        assertEquals(0,ll.getLength());
        assertEquals("()",ll.toString());
    }
    @Test
    //Remove LinkedList with one element. Return the only element after removing
    //Should have 0 nodes, the content will change
    public void testRemoveHeadOne(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");

        String expected = ll.removeHead();
        assertEquals(0,ll.getLength());
        assertEquals("A",expected);
        assertEquals("()",ll.toString());

    }
    @Test
    //Remove LinkedList with more than one element
    //The length should decrement by 1. Return the removed element.
    // Content will change
    public void testRemoveHeadNonEmpty(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtTail("C");
        ll.insertAtTail("D");
        String expected = ll.removeHead();
        assertEquals(3,ll.getLength());
        assertEquals("A",expected);
        assertEquals("(B, C, D)",ll.toString());




    }

    @Test
    //Remove the first element in a multiple element LinkedList even though it is identical to the others.
    //Should remove the exact element in the exact position. Length will decrement by 1.
    //Should not alter the values besides removing from the LinkedList
    public void removeHeadSameMultiple(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtTail("A");
        assertEquals(1,ll.getLength());
        assertEquals("(A)",ll.toString());

    }
    @Test
    //Insert LinkedList with more than one elements
    //The length should increment by 1
    // content will change as the inserted element will be added at the end
    public void testInsertTailNonEmpty(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("A");
        assertEquals(2,ll.getLength());
        assertEquals("(A, A)",ll.toString());


    }

    @Test
    //Insert tail of a multiple identical element LinkedList. Length and content should change
    public void testInsertTailSameMultiple(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        assertEquals(-1,ll.indexOf("A"));
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());

    }
    @Test
    //IndexOf invalid data of one element LinkedList. Return -1
    //Should not change LinkedList content nor the length
    public void testIndexOfInvalidOne(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        assertEquals(-1,ll.indexOf("B"));
        assertEquals(1,ll.getLength());
        assertEquals("(A)",ll.toString());



    }

    @Test
    //IndexOf invalid data of more than one element LinkedList. Return -1
    //Should not change LinkedList content nor the length
    public void testIndexOfInvalidMultiple(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        assertEquals("(A)",ll.toString());
        assertEquals(1,ll.getLength());

    }
    @Test
    //Test insertAtHead to a LinkedList with one element. The length will increment by 1. Content will change
    public void testInsertHeadOne(){
        LinkedList ll = new LinkedList();
        ll.insertAtTail("A");
        ll.insertAtHead("D");
        assertEquals(2,ll.getLength());
        assertEquals("(D, A)",ll.toString());

    }

    @Test
    //Test insertAtHead to a LinkedList with more than one elements. The content and length will change
    public void testInsertHeadMultiple(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtTail("D");
        ll.insertAtHead("D");
        assertEquals(2,ll.getLength());
        assertEquals("(D, D)",ll.toString());

    }

    @Test
    //Test insertAtHead of a LinkedList with multiple identical elements. Content and length should change
    public void testInsertHeadSameMultiple(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());

    }

    @Test
    //Test isEmpty of a non-empty LinkedList. Should return false
    public void testIsEmptyFalse(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("F");
        ll.insertAtTail("D");
        assertFalse(ll.isEmpty());

    }

    @Test
    //Test getLength of an empty LinkedList. Return 0
    public void testGetLengthEmpty(){
        LinkedList ll = new LinkedList();
        assertEquals(0,ll.getLength());
    }

    @Test
    //Test getLength of a non-empty LinkedList. Return the length
    public void testGetLengthNonEmpty(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("R");
        assertEquals(2,ll.getLength());
    }

    @Test
    //Test toString of empty LinkedList.
    public void testToStringEmpty(){
        LinkedList ll = new LinkedList();
        assertEquals("()",ll.toString());

    }

    @Test
    //Test toString of multiple elements LinkedList
    public void testToStringMultiple(){
        LinkedList ll = new LinkedList();
        ll.insertAtTail("A");
        ll.insertAtTail("D");
        ll.insertAtHead("F");
        assertEquals("(F, A, D)",ll.toString());
    }

    @Test
    //Test toString of one element LinkedList
    public void testToStringOne(){
        LinkedList ll = new LinkedList();

        ll.insertAtHead("F");
        assertEquals("(F)",ll.toString());
    }


    @Test
    //test getItemAt valid position. Return the data corresponding to the wanted index
    public void testGetItemAtNonEmptyValid(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        assertNull(ll.getItemAt(0));

    }
    @Test
    //Test removeTail of a non empty linkedlist. After removing the length will decrement by 1
    public void testRemoveTailNonEmpty(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.removeTail();
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());
    }

    @Test
    //Test removeTail One Element. After removing the linkedlist becomes empty
    public void testRemoveTailOne(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.removeTail();
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());
    }

    @Test
    //Test remove at index of a non-empty linkedlist with valid index. After removing, the length will decrement by 1
    public void testRemoveAtIndexValidNonEmpty(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.removeAtIndex(10);
        assertEquals("()",ll.toString());
        assertEquals(0,ll.getLength());
    }

    @Test

    //Remove at index of one-element linkedlist. After removing, the linkedlist becomes empty
    public void testRemoveAtIndexOne(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.removeAtIndex(0);
        assertTrue(ll.isEmpty());
    }

    @Test
    //Remove at index with invalid index (negative integer). Should remain the same

    public void testRemoveAtIndexNegative(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.removeAtIndex(0);
        assertEquals("(B)",ll.toString());
    }

    @Test
    //Remove at index with index at the end of the linkedlist. Remove the tail of the linkedlist
    public void testRemoveAtIndexTail(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.removeAtIndex(1);
        assertEquals("(A)",ll.toString());
    }

    @Test
    //Remove at index with index in the middle of the linkedlist. Remove the middle element of the linkedlist
    public void testRemoveAtIndexMiddle(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtIndex("A",-1);
        assertEquals("(A)",ll.toString());
    }

    @Test
    //Insert at index with negative index of a nonempty linkedlist. Should remain the same

    public void insertAtIndexNegative(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("Hello");
        ll.insertAtTail("Goodbye");
        ll.insertAtIndex("Hi",-1);
        assertEquals("(Hello, Goodbye)",ll.toString());
    }

    @Test
    //insert at index greater than linkedlist.length. Should remain the same

    public void insertAtIndexGreater(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("Hello");
        ll.insertAtTail("Goodbye");
        ll.insertAtIndex("Hi",10);
        assertEquals("(Hello, Goodbye)",ll.toString());
    }



    @Test
    //Insert at index with index == 0. Insert at the head of the linkedlist
    public void testInsertAtIndexHead(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtIndex("C",0);
        assertEquals("(C, A, B)",ll.toString());
    }

    @Test
    //Insert at index with index at the end of the linkedlist. Insert at the tail of the linkedlist
    public void testInsertAtIndexTail(){
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("B");
        ll.insertAtIndex("C",2);
        assertEquals("(A, B, C)",ll.toString());
    }

    @Test
    //Remove at index with index in the middle of the linkedlist. Remove the middle element of the linkedlist
    public void testInsertAtIndexMiddle(){
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
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
        LinkedList ll = new LinkedList();
        ll.insertAtHead("A");
        ll.insertAtTail("A");
        ll.removeTail();

        assertEquals("(A)",ll.toString());
        assertEquals(1,ll.getLength());
    }

    @Test
    //remove tail multiple times of a non-empty linkedlist. Contents and length will change
    public void testRemoveTailMultiple(){
        LinkedList ll = new LinkedList();
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
