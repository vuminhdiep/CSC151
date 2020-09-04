package proj5;
/**
 * @author: Emma Vu
 * @version: 5/29/2020
 * JUnit test class.  Use these tests as models for your own.
 */
import org.junit.*;


import org.junit.rules.Timeout;

import static org.junit.Assert.*;



public class BSTTest {
    @Rule

    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree<String> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree<String>();
    }

    @After
    public void tearDown() throws Exception {
        bst = null;
    }

    @Test
    public void testSearchEmpty(){
        assertNull(bst.search("A"));
    }

    @Test
    public void testSearchAtRoot(){
        bst.insert("A");
        assertEquals("A",bst.search("A"));
    }

    @Test
    public void testSearchNonExist(){
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        assertNull(bst.search("D"));
    }

    @Test
    public void testSearchLeft(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        assertEquals("A",bst.search("A"));
    }

    @Test
    public void testSearchRight(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        assertEquals("C",bst.search("C"));
    }

    @Test
    public void testDeleteEmpty(){
        bst.delete("A");
        assertEquals("",bst.toString());
    }
    @Test
    public void testDeleteAtRoot(){
        bst.insert("A");
        bst.delete("A");
        assertEquals("",bst.toString());
    }
    @Test
    public void testDeleteNonExist(){
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.delete("D");
        assertEquals("( A ( B ( C )))",bst.toString());
    }

    @Test
    public void testDeleteLeaf(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        bst.delete("D");
        assertEquals("(( A ) B ( C ( E ( F ))))",bst.toString());


    }

    @Test
    public void testDeleteOneChild(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        bst.delete("C");
        assertEquals("(( A ) B (( D ) E ( F )))",bst.toString());
    }

    @Test
    public void testDeleteTwoChildren(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        bst.delete("E");
       assertEquals("(( A ) B ( C (( D ) F )))",bst.toString());
    }

    @Test
    public void testToStringOrder(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        assertEquals("A\nB\nC\nD\nE\nF\n",bst.toStringOrder());
    }

    @Test
    public void testToStringEmpty(){
        assertEquals("",bst.toString());
    }

    @Test
    public void testToStringOrderEmpty(){
        assertEquals("",bst.toStringOrder());
    }

    @Test
    public void testHeightEmpty(){
        assertEquals(-1,bst.height());
    }
    @Test
    public void testHeightNonEmpty(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        assertEquals(3,bst.height());
    }







}


