/**
 * JUnit test class.  Use these tests as models for your own.
 */
import org.junit.*;


import org.junit.rules.Timeout;

import static org.junit.Assert.*;

import proj3.Sequence;




public class SequenceTest {

    @Rule
    // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    /**
     * customize the sequence from the string array and be able to set the capacity and current index
     * @param newArray the string array given so that convert to sequence
     * @param capacity the capacity wanted in the sequence
     * @param currentIndex the current index for the element in the sequence
     * @return the customized sequence
     */

    private Sequence createSequence(String[] newArray, int capacity, int currentIndex){
        Sequence sq = new Sequence(capacity);
        for(String element:newArray){
            sq.addAfter(element);
        }
        sq.start();
        for(int i = 0; i < currentIndex; i++){
            sq.advance();
        }
        return sq;

    }


    @Test
    //Test  default constructor
    public void test_DefaultConstructor_EmptySequence(){
        Sequence sq = new Sequence();
        String toStringExpected = "{} (capacity = 10)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals(10,sq.getCapacity());
        assertNull(sq.getCurrent());
        assertEquals(0,sq.size());

    }


    @Test
    //Test non-default constructor with positive initial capacity
    public void test_NonDefaultConstructor_EmptySequence_PositiveCap(){
        Sequence sq = new Sequence(22);
        String toStringExpected = "{} (capacity = 22)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals(22,sq.getCapacity());
        assertNull(sq.getCurrent());
        assertEquals(0,sq.size());

    }

    @Test
    //Test non-default constructor with negative initial capacity. Then the capacity set to 10
    public void test_NonDefaultConstructor_EmptySequence_NegativeCap(){
        Sequence sq = new Sequence(-3);
        String toStringExpected = "{} (capacity = 10)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals(10,sq.getCapacity());
        assertNull(sq.getCurrent());
        assertEquals(0,sq.size());

    }


    @Test
    //Test addBefore to empty sequence.
    // Then the element added is the first element in the sequence and also the current element
    public void test_AddBefore_EmptySequence(){
        Sequence sq = new Sequence();


        sq.addBefore("A");

        String toStringExpected = "{>A} (capacity = 10)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals("A",sq.getCurrent());
        assertEquals(10,sq.getCapacity());
        assertEquals(1,sq.size());

    }

    @Test
    //Test addBefore to a full sequence.
    //Then the sequence's current capacity will expand twice plus 1
    //The size should +1, the added element become the current element
    public void test_AddBefore_FullSequence(){
        Sequence sq = createSequence(new String[]{"A","B","C"},3,3);
        sq.addBefore("D");
        assertEquals(4,sq.size());
        assertEquals(7,sq.getCapacity());
        assertEquals("D",sq.getCurrent());
        String toStringExpected = "{>D, A, B, C} (capacity = 7)";
        assertEquals(toStringExpected,sq.toString());
    }

    @Test
    //Test addBefore to a sequence that has room so capacity not change. The added element becomes the current
    public void test_AddBefore_NonEmptySequence_ThatHasRoom(){
        Sequence sq = createSequence(new String[]{"A","B","C"},8,1);
        sq.addBefore("D");
        assertEquals(4,sq.size());
        assertEquals(8,sq.getCapacity());
        assertEquals("D",sq.getCurrent());
        String toStringExpected = "{A, >D, B, C} (capacity = 8)";
        assertEquals(toStringExpected,sq.toString());

    }

    @Test

    //add an element to an almost full sequence. The size should increase by 1, capacity stay the same

    public void test_AddBefore_AlmostFull(){
        Sequence sq = createSequence(new String[]{"A", "B", "C","D","E"},6,4);
        sq.addBefore("F");
        assertEquals(6,sq.size());
        assertEquals(6,sq.getCapacity());
        assertEquals("F",sq.getCurrent());
        String toStringExpected = "{A, B, C, D, >F, E} (capacity = 6)";
        assertEquals(toStringExpected,sq.toString());

    }

    @Test
    //test add before to a sequence with no current. Then the added element become the current at the first
    public void test_AddBefore_NoCurrent(){

        Sequence sq = createSequence(new String[]{"A","B","C"},5,3);
        sq.addBefore("D");
        assertEquals(4,sq.size());
        assertEquals(5,sq.getCapacity());
        assertEquals("D",sq.getCurrent());
        String toStringExpected = "{>D, A, B, C} (capacity = 5)";
        assertEquals(toStringExpected,sq.toString());

    }


    @Test
    //Test addAfter to an empty sequence
    //Then the element added is the end of the sequence and also the current element
    public void test_AddAfter_EmptySequence(){
        Sequence sq = new Sequence();
        sq.addAfter("A");
        String toStringExpected = "{>A} (capacity = 10)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals("A",sq.getCurrent());
        assertEquals(10,sq.getCapacity());
        assertEquals(1,sq.size());
    }

    @Test
    //Test addAfter to a full sequence
    //Then the sequence's current capacity is expanded twice plus 1
    public void test_AddAfter_FullSequence(){
        Sequence sq = createSequence(new String[]{"A", "B", "C", "D"},4,4);
        sq.addAfter("F");

        assertEquals("F",sq.getCurrent());
        assertEquals(9,sq.getCapacity());
        assertEquals(5,sq.size());

        String toStringExpected = "{A, B, C, D, >F} (capacity = 9)";
        assertEquals(toStringExpected, sq.toString());
    }

    @Test

    //Test add after to non empty sequence that has room. Capacity should not change, size should + 1

    public void test_AddAfter_NonEmptySequence_ThatHasRoom(){

        Sequence sq = createSequence(new String[]{"A", "B", "C", "D"},6,1);
        sq.addAfter("F");

        assertEquals("F",sq.getCurrent());
        assertEquals(6,sq.getCapacity());
        assertEquals(5,sq.size());

        String toStringExpected = "{A, B, >F, C, D} (capacity = 6)";
        assertEquals(toStringExpected, sq.toString());

    }

    @Test
    //Should be added at the end. The added is the current
    public void test_AddAfter_NoCurrent(){

        Sequence sq = createSequence(new String[]{"A", "B", "C", "D"},6,4);
        sq.addAfter("F");

        assertEquals("F",sq.getCurrent());
        assertEquals(6,sq.getCapacity());
        assertEquals(5,sq.size());

        String toStringExpected = "{A, B, C, D, >F} (capacity = 6)";
        assertEquals(toStringExpected, sq.toString());


    }

    @Test

    //The capacity should not change. Size + 1

    public void test_AddAfter_AlmostFull(){

        Sequence sq = createSequence(new String[]{"A", "B", "C", "D"},5,4);
        sq.addAfter("F");

        assertEquals("F",sq.getCurrent());
        assertEquals(5,sq.getCapacity());
        assertEquals(5,sq.size());

        String toStringExpected = "{A, B, C, D, >F} (capacity = 5)";
        assertEquals(toStringExpected, sq.toString());

    }

    @Test
    //return false to an empty default sequence. Return true after adding
    public void test_IsCurrent_EmptyDefault(){
        Sequence sq = new Sequence();
        assertFalse(sq.isCurrent());
        sq.addAfter("A");
        assertTrue(sq.isCurrent());


    }


    @Test
    //Test isCurrent to a sequence after advancing the last current to no current.Return false
    public void test_IsCurrent_Advancing_LastCurrent(){
        Sequence sq = createSequence(new String[]{"A","B","C"},5,2);
        assertTrue(sq.isCurrent());
        sq.advance();
        assertFalse(sq.isCurrent());

    }



    @Test
    //Test getCapacity to a default sequence. Return 10
    public void test_GetCapacity_DefaultSequence(){
        Sequence sq = new Sequence();
        assertEquals(10,sq.getCapacity());

    }

    @Test
    //Test getCapacity to a non-default sequence. Return the capacity
    public void test_GetCapacity_NonDefaultSequence(){
        Sequence sq = new Sequence(12);
        assertEquals(12,sq.getCapacity());
    }

    @Test
    //return null if sequence is empty
    public void test_GetCurrent_Empty(){
        Sequence sq = new Sequence();
        assertNull(sq.getCurrent());

    }

    @Test
    //return null if the non empty sequence has no current
    public void test_GetCurrent_NonEmpty_NoCurrent(){
        Sequence sq = createSequence(new String[]{"A","B","C"},4,3);
        assertNull(sq.getCurrent());


    }

    @Test
    //return the element of the non empty sequence
    public void test_GetCurrent_NonEmpty_Current(){
        Sequence sq = createSequence(new String[]{"A","B","C"},4,1);
        assertEquals("B",sq.getCurrent());
    }

    @Test
    //Test ensureCapacity of a sequence that has capacity smaller than minCapacity.
    //Increase the capacity equal to minCapacity
    //Contents don't change
    public void test_EnsureCapacity_Smaller(){
        Sequence sq = createSequence(new String[]{"A","B","C"},10,1);
        sq.ensureCapacity(1000);
        assertEquals(1000,sq.getCapacity());
        String toStringExpected = "{A, >B, C} (capacity = 1000)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals(3,sq.size());
        assertEquals("B",sq.getCurrent());

    }

    @Test
    //Test ensureCapacity of a sequence that has capacity greater than minCapacity
    //Do nothing to the capacity
    //Contents don't change
    public void test_EnsureCapacity_Greater(){

        Sequence sq = createSequence(new String[]{"A","B","C"},1000,1);
        sq.ensureCapacity(10);
        assertEquals(1000,sq.getCapacity());
        String toStringExpected = "{A, >B, C} (capacity = 1000)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals(3,sq.size());
        assertEquals("B",sq.getCurrent());

    }

    @Test
    //Test ensureCapacity of a sequence that has capacity equal to minCapacity
    //Do nothing to the capacity
    //Contents don't change
    public void test_EnsureCapacity_Equal(){

        Sequence sq = createSequence(new String[]{"A","B","C"},1000,1);
        sq.ensureCapacity(1000);
        assertEquals(1000,sq.getCapacity());
        String toStringExpected = "{A, >B, C} (capacity = 1000)";
        assertEquals(toStringExpected,sq.toString());
        assertEquals(3,sq.size());
        assertEquals("B",sq.getCurrent());

    }

    @Test
    //Test addAll of an empty sequence to non empty sequence.
    //If this.sequence is empty and the other is not, then return this.sequence with contents of the other sequence
    //The size of this.sequence must include the size of the other sequence. Capacity not change
    //BUT when call isCurrent of this.sequence it's still false, getCurrent other sequence it's still the same element


    public void test_AddAll_Empty_To_NonEmpty_Current(){

        Sequence sq = new Sequence();
        Sequence toAddAllSq = createSequence(new String[]{"A","B"},3,0);
        sq.addAll(toAddAllSq);
        assertEquals(2,sq.size());

        assertEquals("A",toAddAllSq.getCurrent());
        assertFalse(sq.isCurrent());
        String toStringExpected = "{A, B} (capacity = 10)";
        assertEquals(toStringExpected, sq.toString());

    }

    @Test

    //Test addAll of an empty sequence to non empty sequence without current.
    //If this.sequence is empty and the other is not, then return this.sequence with contents of the other sequence
    //The size of this.sequence must include the size of the other sequence. Capacity not change
    //BUT when call isCurrent of this.sequence it's still false, of the other sequence it's still false


    public void test_AddAll_Empty_To_NonEmpty_NoCurrent(){

        Sequence sq = new Sequence();
        Sequence toAddAllSq = createSequence(new String[]{"A","B"},3,2);
        sq.addAll(toAddAllSq);
        assertEquals(2,sq.size());

        assertFalse(toAddAllSq.isCurrent());
        assertFalse(sq.isCurrent());
        String toStringExpected = "{A, B} (capacity = 10)";
        assertEquals(toStringExpected, sq.toString());


    }

    @Test
    //Test addAll of non empty sequence to empty sequence.
    //Return this.sequence with contents of the other sequence. In this case, contents don't change
    //The size of this.sequence must include the size of the other sequence. Capacity not change
    //BUT when call isCurrent of other.sequence it's still false, getCurrent this.sequence it's still the same element



    public void test_AddAll_NonEmpty_Current_To_Empty(){


        Sequence toAddAllSq = new Sequence();
        Sequence sq = createSequence(new String[]{"A","B"},3,1);
        sq.addAll(toAddAllSq);
        assertEquals(2,sq.size());


        assertEquals("B",sq.getCurrent());

        String toStringExpected = "{A, >B} (capacity = 3)";
        assertEquals(toStringExpected, sq.toString());

    }

    @Test
    //Test addAll of non empty sequence to empty sequence without current.
    //Return this.sequence with contents of the other sequence. In this case, contents don't change
    //The size of this.sequence must include the size of the other sequence. Capacity not change
    //BUT when call isCurrent of other.sequence it's still false, of this.sequence it's still false


    public void test_AddAll_NonEmpty_NoCurrent_To_Empty(){

        Sequence toAddAllSq = new Sequence();
        Sequence sq = createSequence(new String[]{"A","B"},3,2);
        sq.addAll(toAddAllSq);
        assertEquals(2,sq.size());


        assertFalse(sq.isCurrent());

        String toStringExpected = "{A, B} (capacity = 3)";
        assertEquals(toStringExpected, sq.toString());
    }

    @Test
    //Test addAll of both empty sequences.
    // Then print out empty contents and both sequences when call isCurrent still false

    public void test_AddAll_BothEmpty(){
        Sequence sq = new Sequence(3);
        Sequence toAddAllSq = new Sequence();
        sq.addAll(toAddAllSq);
        assertFalse(sq.isCurrent());

        assertEquals(0,sq.size());

        assertEquals(3,sq.getCapacity());
        String expected = "{} (capacity = 3)";
        String expectedToAdd = "{} (capacity = 10)";
        assertEquals(expected,sq.toString());
        assertEquals(expectedToAdd,toAddAllSq.toString());

    }

    @Test
    //Test addAll of two filled sequences but adding all the elements of other.sequence will result in this.sequence
    // expanding just enough room (the capacity is changed). Then the contents are both the elements from this and
    // other sequence and the current elements are the same

    public void test_AddAll_NotEnoughCapacity(){
        Sequence sq = createSequence(new String[]{"A","B"},2,1);
        Sequence toAddAllSq = createSequence(new String[]{"C","D","E"},3,0);
        sq.addAll(toAddAllSq);
        String expected = "{A, >B, C, D, E} (capacity = 5)";
        assertEquals(expected, sq.toString());
        assertEquals(5,sq.size());
        assertEquals(5,sq.getCapacity());
        assertEquals("C",toAddAllSq.getCurrent());
        assertEquals(3,toAddAllSq.size());
        assertEquals(3,toAddAllSq.getCapacity());

    }


    @Test
    //other.sequence has repeated contents to this.sequence. But still add all to this.sequence anyway.
    // Current elements don't change
    public void test_AddAll_Repeat_One(){
        Sequence sq = createSequence(new String[]{"A"},5,1);
        Sequence toAddAllSq = createSequence(new String[]{"A","B","C","D"},4,3);
        sq.addAll(toAddAllSq);
        assertEquals(5,sq.size());
        assertEquals("D",toAddAllSq.getCurrent());
        String expected = "{A, A, B, C, D} (capacity = 5)";
        assertEquals(expected,sq.toString());


    }


    @Test
    //other.sequence has repeated contents to this.sequence. But still add all to this.sequence anyway.
    // Current elements don't change
    public void test_AddAll_Repeat_Two(){
        Sequence sq = createSequence(new String[]{"A","B","C"},5,1);
        Sequence toAddAllSq = createSequence(new String[]{"A","B"},3,2);
        sq.addAll(toAddAllSq);
        assertEquals(5,sq.size());
        String expected = "{A, >B, C, A, B} (capacity = 5)";
        assertEquals(expected,sq.toString());
        assertFalse(toAddAllSq.isCurrent());

    }


    @Test
    //other.sequence has same contents to this.sequence. But still add all to this.sequence anyway.
    // Current elements don't change. They are different objects
    public void test_AddAll_Repeat_All(){
        Sequence sq = createSequence(new String[]{"A","B"},5,1);
        Sequence toAddAllSq = createSequence(new String[]{"A","B"},5,1);
        sq.addAll(toAddAllSq);
        assertEquals(4,sq.size());
        String expected = "{A, >B, A, B} (capacity = 5)";
        assertEquals(expected,sq.toString());
        assertEquals("B",toAddAllSq.getCurrent());
        toAddAllSq.start();
        assertNotEquals(sq.getCurrent(),toAddAllSq.getCurrent());
        assertNotSame(sq,toAddAllSq);

    }

    @Test
    //Add all two non empty sequences without current element. The size should be the sum of two sequences
    //After add two sequences still have no current elements
    public void test_AddAll_NonEmpty_NoCurrent(){

        Sequence sq = createSequence(new String[]{"A","B"},5,2);
        Sequence toAddAllSq = createSequence(new String[]{"C","D"},3,2);
        sq.addAll(toAddAllSq);
        assertEquals(4,sq.size());
        String expected = "{A, B, C, D} (capacity = 5)";
        assertEquals(expected,sq.toString());
        assertFalse(toAddAllSq.isCurrent());
        assertFalse(sq.isCurrent());


    }

    @Test

    //Add all two non empty sequences without current element. The size should be the sum of two sequences
    //After add two sequences still have their original current elements

    public void test_AddAll_NonEmpty_Current(){
        Sequence sq = createSequence(new String[]{"A","B"},5,0);
        Sequence toAddAllSq = createSequence(new String[]{"C","D"},3,1);
        sq.addAll(toAddAllSq);
        assertEquals(4,sq.size());
        String expected = "{>A, B, C, D} (capacity = 5)";
        assertEquals(expected,sq.toString());
        assertEquals("D",toAddAllSq.getCurrent());
        assertEquals("A",sq.getCurrent());

    }


    @Test
    //test Advance empty sequence. Nothing change
    public void test_Advance_Empty(){
        Sequence sq = new Sequence();
        sq.advance();
        assertEquals(10,sq.getCapacity());
        assertEquals(0,sq.size());
        assertFalse(sq.isCurrent());
        String toStringExpected = "{} (capacity = 10)";
        assertEquals(toStringExpected,sq.toString());

    }

    @Test
    //Test advance a non empty sequence with current. After advancing the current element change to the next one
    public void test_Advance_Current(){
        Sequence sq = createSequence(new String[]{"A","B","C","D"},4,0);
        sq.advance();
        assertEquals("B",sq.getCurrent());
        String toStringExpected = "{A, >B, C, D} (capacity = 4)";

        assertEquals(toStringExpected,sq.toString());

        sq.advance();
        assertEquals("C",sq.getCurrent());
        String expected = "{A, B, >C, D} (capacity = 4)";
        assertEquals(expected,sq.toString());

        sq.advance();
        assertEquals("D",sq.getCurrent());
        String answer = "{A, B, C, >D} (capacity = 4)";
        assertEquals(answer,sq.toString());


    }

    @Test
    //Test advance with a non empty sequence without current element. Call isCurrent return false
    public void test_Advance_NoCurrent(){
        Sequence sq = createSequence(new String[]{"A","B","C","D"},4,4);
        sq.advance();
        assertFalse(sq.isCurrent());
        String toStringExpected = "{A, B, C, D} (capacity = 4)";
        assertEquals(toStringExpected,sq.toString());

    }



    @Test
    //Test advance with a sequence whose current element is at the end. Then advancing causes no current element (null)
    public void test_Advance_Last(){
        Sequence sq = createSequence(new String[]{"A","B","C","D"},4,3);
        sq.advance();
        assertFalse(sq.isCurrent());
        String toStringExpected = "{A, B, C, D} (capacity = 4)";
        assertEquals(toStringExpected,sq.toString());


    }



    @Test
    //Test clone with an empty sequence. Then the clone has the same contents as the original
    public void test_Clone_EmptySequence(){
        Sequence sq = new Sequence();
        Sequence toCloneSq = sq.clone();
        assertEquals(10,toCloneSq.getCapacity());
        assertEquals(0,toCloneSq.size());
        assertFalse(toCloneSq.isCurrent());
        String expected = "{} (capacity = 10)";
        assertEquals(expected,toCloneSq.toString());

    }

    @Test
    //Test clone of a non empty sequence. Then the current elements of both sequences are the same position
    //When make changes to clone or original, the other one doesn't change

    public void test_Clone_Sequence_DifferentObjects(){
        Sequence sq = createSequence(new String[]{"A","B","C","D","E"},10,3);
        Sequence toCloneSq = sq.clone();
        assertNotSame(sq,toCloneSq);
        sq.addAfter("F");
        //assertNotEquals(sq.toString(),toCloneSq.toString());

        toCloneSq = sq.clone();
        toCloneSq.addAfter("F");
        assertNotSame(sq,toCloneSq);

    }

    @Test
    //Cloning should produce identical contents: same size, capacity, current element
    public void test_Clone_Identical(){
        Sequence sq = createSequence(new String[]{"A","B","C","D","E"},10,3);
        Sequence toCloneSq = sq.clone();
        assertTrue(sq.equals(toCloneSq));

    }

    @Test
    //Test removeCurrent of non empty sequence with no current element.
    //When getCurrent it is null
    public void test_Remove_NoCurrent(){
        Sequence sq = createSequence(new String[]{"A","B"},3,2);
        sq.removeCurrent();
        assertNull(sq.getCurrent());
    }

    @Test
    //Test removeCurrent of an empty sequence which means there is no current element.
    //When getCurrent it is null
    public void test_Remove_EmptySequence(){
        Sequence sq = new Sequence();
        sq.removeCurrent();
        assertNull(sq.getCurrent());

    }

    @Test
    //Test removeCurrent of a non empty sequence whose current element is at the end.
    //Then after remove call getCurrent it is null
    public void test_Remove_Last(){
        Sequence sq = createSequence(new String[]{"A","B","C"},4,2);
        sq.removeCurrent();
        assertNull(sq.getCurrent());

    }

    @Test
    //Test removeCurrent of a non empty sequence whose current element is NOT at the end.
    //Then the next element is the current element
    public void test_Remove_First(){
        Sequence sq = createSequence(new String[]{"A","B","C"},4,0);
        sq.removeCurrent();
        assertEquals("B",sq.getCurrent());

    }

    @Test
    //Test removeCurrent of a non empty sequence whose current element is NOT at the end.
    //Then the next (last) element is the current element
    public void test_Remove_Middle(){
        Sequence sq = createSequence(new String[]{"A","B","C"},4,1);
        sq.removeCurrent();
        assertEquals("C",sq.getCurrent());
    }

    @Test
    //Test the number of element in an empty default sequence. Return 0

    public void test_Size_Default(){
        Sequence sq = new Sequence();
        assertEquals(0,sq.size());

    }

    @Test
    //Test the number of element in an empty non default sequence. Return 0

    public void test_Size_NonDefault(){
        Sequence sq = new Sequence();
        assertEquals(0,sq.size());

    }

    @Test
    //Test the number of element in a non empty sequence. Return that number

    public void test_Size_NonEmpty(){
        Sequence sq = createSequence(new String[]{"A","B"},3,1);
        assertEquals(2,sq.size());

    }

    @Test
    //Test start of an empty sequence. Then do nothing because it has no current element.
    //When call isCurrent return false
    public void test_Start_EmptySequence(){

        Sequence sq = new Sequence();
        sq.start();
        assertFalse(sq.isCurrent());


    }

    @Test
    //Test start of a filled sequence. Then the first element of the sequence is the current element
    public void test_Start_NonEmpty_Current(){

        Sequence sq = createSequence(new String[]{"A","B","C"},5,1);
        sq.start();
        assertEquals("A",sq.getCurrent());
        String toStringExpected = "{>A, B, C} (capacity = 5)";
        assertEquals(toStringExpected,sq.toString());
    }

    @Test
    //Test start of a filled sequence. Then the first element of the sequence is the current element

    public void test_Start_NonEmpty_NoCurrent(){

        Sequence sq = createSequence(new String[]{"A","B","C"},5,3);
        sq.start();
        assertEquals("A",sq.getCurrent());
        String toStringExpected = "{>A, B, C} (capacity = 5)";
        assertEquals(toStringExpected,sq.toString());

    }

    @Test
    //Test trimToSize of an empty sequence. Then capacity = 0
    public void test_TrimToSize_EmptySequence(){
        Sequence sq = new Sequence();
        sq.trimToSize();
        assertEquals(0,sq.getCapacity());

    }

    @Test
    //Test trimToSize of a filled sequence. Reduce the capacity to its actual size

    public void test_TrimToSize_NonEmpty(){

        Sequence sq = createSequence(new String[]{"A","B"},10,1);
        sq.trimToSize();
        assertEquals(2,sq.getCapacity());

    }

    @Test
    //Test toString of an empty sequence. Return {} followed by its capacity
    public void test_ToString_Empty(){
        Sequence sq = new Sequence();
        String expected = "{} (capacity = 10)";
        assertEquals(expected,sq.toString());

    }


    @Test
    //Test toString of a sequence with no current element
    public void test_ToString_NoCurrent(){
        Sequence sq = createSequence(new String[]{"A","D"},3,2);
        String expected = "{A, D} (capacity = 3)";
        assertEquals(expected,sq.toString());

    }

    @Test
    //Test toString of a sequence with current element.

    public void test_ToString_Current(){
        Sequence sq = createSequence(new String[]{"A","D"},3,1);
        String expected = "{A, >D} (capacity = 3)";
        assertEquals(expected,sq.toString());

    }

    @Test
    //should be equal if they both have no current, same cap, same size same order
    public void test_Equals_NoCurrent(){
        Sequence sq = createSequence(new String[]{"A","B","D"},3,3);
        Sequence anotherSq = createSequence(new String[]{"A","B","D"},3,3);
        assertTrue(sq.equals(anotherSq));


    }

    @Test
    //Test equals of two empty sequences. Return true
    public void test_Equals_TwoEmpty_Sequences(){
        Sequence sq = new Sequence();
        Sequence anotherSq = new Sequence(12);
        assertTrue(sq.equals(anotherSq));


    }

    @Test
    //empty sequence != non-empty sequence
    public void test_Equals_EmptyVsNonEmpty(){
        Sequence sq = new Sequence();
        Sequence anotherSq = createSequence(new String[]{"A","B"},3,1);
        assertFalse(sq.equals(anotherSq));

    }

    @Test
    //non-empty sequence != empty sequence

    public void test_Equals_NonEmptyVsEmpty(){
        Sequence anotherSq = new Sequence();
        Sequence sq = createSequence(new String[]{"A","B"},3,1);
        assertFalse(sq.equals(anotherSq));

    }

    @Test
    //Test equals of two non-empty sequences
    //Checks whether another sequence is equal to this one.
    // To be considered equal, the other sequence must have the same size
    // as this sequence, have the same elements, in the same order, and with the same element marked current.
    // The capacity can differ.
    public void test_Equals_TwoDifferentCapacity(){
        Sequence sq = createSequence(new String[]{"A"},2,0);
        Sequence anotherSq = createSequence(new String[]{"A"},3,0);
        assertTrue(sq.equals(anotherSq));

    }

    @Test
    //not equal when two equals  have different size even though they have same capacity and same current element
    public void test_Equals_DifferentSize(){
        Sequence sq = createSequence(new String[]{"A","B","C"},3,1);
        Sequence anotherSq = createSequence(new String[]{"A","B"},3,1);
        assertFalse(sq.equals(anotherSq));

    }

    @Test
    //Two sequences with different elements should not be equal even if they have same capacity, size, current element

    public void test_Equals_DifferentElements(){
        Sequence sq = createSequence(new String[]{"A","B","D"},3,1);
        Sequence anotherSq = createSequence(new String[]{"A","B","G"},3,1);
        assertFalse(sq.equals(anotherSq));

    }

    @Test
    //Should not be equal even though they are identical in capacity, size, elements, order

    public void test_EqualsIdentical_ButOneHasCurrentOneNot(){
        Sequence sq = createSequence(new String[]{"A","B","D"},3,1);
        Sequence anotherSq = createSequence(new String[]{"A","B","D"},3,3);
        assertFalse(sq.equals(anotherSq));


    }

    @Test
    //Should not be equal even though they are identical in element, capacity, size, current element
    public void test_Equals_DifferentOrder(){
        Sequence sq = createSequence(new String[]{"A","B","D"},3,1);
        Sequence anotherSq = createSequence(new String[]{"D","B","A"},3,1);
        assertFalse(sq.equals(anotherSq));



    }

    @Test
    //Should not be equal even though they are identical in element, capacity, size, order
     public void test_Equals_DifferentCurrent(){
        Sequence sq = createSequence(new String[]{"A","B","D"},3,1);
        Sequence anotherSq = createSequence(new String[]{"A","B","D"},3,0);
        assertFalse(sq.equals(anotherSq));

    }

    @Test
    //equal to itself
    public void test_Equals_Reflexivity(){
        Sequence sq = createSequence(new String[]{"A","B","C"},3,1);
        assertTrue(sq.equals(sq));

    }

    @Test
    //clone equal to original
    public void test_Equals_Clone(){
        Sequence sq = createSequence(new String[]{"A","B","D"},3,1);
        Sequence anotherSq = sq.clone();
        assertTrue(sq.equals(anotherSq));


    }

    @Test
    //if A = B then B = A

    public void test_Equals_Symmetry(){
        Sequence sq = createSequence(new String[]{"A","B","C"},3,1);
        Sequence anotherSq = createSequence(new String[]{"A","B","C"},7,1);
        assertTrue(sq.equals(anotherSq));
        assertTrue(anotherSq.equals(sq));


    }

    @Test
    //Test isEmpty of an empty sequence. Return true

    public void test_IsEmpty_EmptySequence(){
        Sequence sq = new Sequence();
        assertTrue(sq.isEmpty());

    }

    @Test
    //Test isEmpty of a non empty sequence with current. Return false
    public void test_IsEmpty_NonEmptySequence_Current(){
        Sequence sq = createSequence(new String[]{"A","B"},3,0);
        assertFalse(sq.isEmpty());
    }

    @Test
    //Test isEmpty of a non empty sequence without current. Return false
    public void test_IsEmpty_NonEmptySequence_NoCurrent(){
        Sequence sq = createSequence(new String[]{"A","B"},3,2);
        assertFalse(sq.isEmpty());
    }

    @Test
    //Test clear an empty sequence. Capacity not change. Still the same contents
    public void test_Clear_EmptySequence(){
        Sequence sq = new Sequence();
        sq.clear();
        assertEquals(10,sq.getCapacity());
        assertFalse(sq.isCurrent());
        assertEquals(0,sq.size());
        String toStringExpected = "{} (capacity = 10)";
        assertEquals(toStringExpected,sq.toString());


    }

    @Test
    //Test clear a non empty sequence. After clearing the sequence should be empty and there is no current element
    //Capacity don't change. Size after clearing = 0
    public void test_Clear_NonEmpty(){
        Sequence sq = createSequence(new String[]{"A","B"},3,0);
        sq.clear();
        assertEquals(0,sq.size());
        assertEquals(3,sq.getCapacity());
        assertFalse(sq.isCurrent());
        String toStringExpected = "{} (capacity = 3)";
        assertEquals(toStringExpected,sq.toString());



    }







}
