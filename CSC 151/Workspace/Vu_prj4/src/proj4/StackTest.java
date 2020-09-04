package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * The test for generic type stack class
 * 
 * @author Emma Vu
 * @version 5/21/2020
 *
 */
public class StackTest {

	@Rule
    public Timeout timeout = Timeout.millis(100);
	
    private Stack<String> stack;
    
    @Before
    public void setUp() throws Exception {
        stack = new Stack<String>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testStackConstructor_toString () {
        assertEquals ("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }

    @Test
    public void testToStringOneItem(){
        stack.push("A");
        assertEquals("{>A}",stack.toString());
    }

    @Test
    public void testConstructorSize(){
        assertEquals(0,stack.size());
    }

    @Test
    public void testToStringMultipleItems(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("{>C,B,A}",stack.toString());
    }

    @Test
    public void testToStringSimilar(){
        stack.push("A");
        stack.push("A");
        stack.push("A");
        assertEquals("{>A,A,A}",stack.toString());
    }
    
    @Test
    public void testStackPushOneOntoEmptyStack () {
        stack.push("A");
        assertEquals(1,stack.size());
        assertEquals ("Pushing A onto an empty stack.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushTwoOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        assertEquals(2,stack.size());
        assertEquals ("Pushing first A and then B onto an empty stack.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushThreeOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3,stack.size());
        assertEquals ("Pushing first A, then B, then C onto an empty stack.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPushSimilar(){
        stack.push("A");
        stack.push("A");

        assertEquals(2,stack.size());
        assertEquals("Push identical strings on an empty stack","{>A,A}", stack.toString().replaceAll("[ ]+",""));
    }

    @Test
    public void testIsEmptyTrue(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmptyFalse(){
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSizeEmpty(){
        assertEquals(0,stack.size());
    }

    @Test
    public void testSizeNonEmpty(){
        stack.push("A");
        stack.push("B");
        assertEquals(2,stack.size());
    }

    @Test
    public void testPeekEmpty(){
        assertNull(stack.peek());
    }

    @Test
    public void testPeekOneItem(){
        stack.push("A");
        assertEquals("A",stack.peek());
    }

    @Test
    public void testPeekMultiple(){
        stack.push("A");
        stack.push("B");
        assertEquals("B",stack.peek());
    }

    @Test
    public void testPopEmpty(){
        assertNull(stack.pop());
    }

    @Test

    public void testPopOneItem(){
        stack.push("A");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopMultipleItems(){
        stack.push("A");
        stack.push("B");
        stack.pop();
        assertEquals(1,stack.size());
        assertEquals("A",stack.peek());
        assertEquals("{>A}", stack.toString().replaceAll("[ ]+",""));
    }

    @Test
    public void testPopMultipleTimes(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.pop();
        stack.pop();
        assertEquals(2,stack.size());
        assertEquals("B",stack.peek());
        assertEquals("{>B,A}", stack.toString().replaceAll("[ ]+",""));

    }
    @Test
    public void testPopSimilar(){
        stack.push("A");
        stack.push("A");
        stack.push("A");
        stack.pop();
        assertEquals(2,stack.size());
        assertEquals("A",stack.peek());
        assertEquals("{>A,A}", stack.toString().replaceAll("[ ]+",""));






    }
    @Test
    public void testGetCapacityDefault(){
        assertEquals(10,stack.getCapacity());
    }

    @Test
    public void testGetCapacityNonDefaultNegative(){
        stack = new Stack<String>(-1);
        assertEquals(10,stack.getCapacity());
    }

    @Test
    public void testGetCapacityNonDefaultValid(){
        stack = new Stack<String>(3);
        assertEquals(3,stack.getCapacity());
    }
    @Test

    public void test_EnsureCapacity_Smaller(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.ensureCapacity(1000);
        assertEquals(1000,stack.getCapacity());
        assertEquals(3,stack.size());
    }

    @Test

    public void test_EnsureCapacity_Greater(){
        stack = new Stack<String>(1000);
        stack.push("A");
        stack.push("B");
        stack.ensureCapacity(10);
        assertEquals(1000,stack.getCapacity());
        assertEquals(2,stack.size());


    }

    @Test

    public void test_EnsureCapacity_Equal(){
        stack = new Stack<String>(20);

        stack.ensureCapacity(20);
        assertEquals(20,stack.getCapacity());

    }

    @Test

    public void test_TrimToSize_EmptySequence(){

        stack.trimToSize();
        assertEquals(0,stack.getCapacity());

    }

    @Test


    public void test_TrimToSize_NonEmpty(){

        stack.push("A");
        stack.push("B");
        stack.trimToSize();
        assertEquals(2,stack.getCapacity());

    }






}