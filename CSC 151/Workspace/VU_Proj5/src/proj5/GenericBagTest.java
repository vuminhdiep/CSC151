package proj5;
/**
 * @author: Emma Vu
 * @version: 6/6/2020
 * JUnit test class.  Use these tests as models for your own.
 */
import org.junit.*;


import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class GenericBagTest {

    @Rule

    public Timeout timeout = Timeout.millis(100);

    private GenericBag<StringContent> genericBag;

    @Before

    public void setUp() throws Exception {
        genericBag = new GenericBag<StringContent>();
    }

    @After
    public void tearDown() throws Exception {
        genericBag = null;
    }


    @Test
    public void testDefaultConstructor(){
        assertEquals("{}",genericBag.toString());
        assertEquals(10,genericBag.capacity());
        assertEquals(0,genericBag.size());
    }

    @Test
    public void testNonDefaultConstructorValidCap(){
        genericBag = new GenericBag<StringContent>(4);
        assertEquals(4,genericBag.capacity());
        assertEquals("{}",genericBag.toString());

    }

    @Test
    public void testNonDefaultConstructorInvalidCap(){
        genericBag = new GenericBag<>(-2);
        assertEquals(10,genericBag.capacity());
        assertEquals("{}",genericBag.toString());
    }

    @Test
    public void testToStringNonEmpty(){
        StringContent sc = new StringContent("A");
        genericBag.add(sc);
        assertEquals("{A}",genericBag.toString());
        genericBag.add(new StringContent("B"));
        assertEquals("{A, B}",genericBag.toString());
    }

    @Test
    public void testAddSizeEqualCap(){
        StringContent sc1 = new StringContent("A");
        StringContent sc2 = new StringContent("B");
        StringContent sc3 = new StringContent("C");
        genericBag = new GenericBag<>(2);
        genericBag.add(sc1);
        genericBag.add(sc2);
        assertEquals(genericBag.size(),genericBag.capacity());
        genericBag.add(sc3);
        assertEquals(3,genericBag.size());
        assertEquals(4,genericBag.capacity());
    }

    @Test
    public void testAddSizeNotEqualCap(){
        genericBag = new GenericBag<>(3);
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        assertEquals("{A, B}",genericBag.toString());
        assertNotEquals(genericBag.size(),genericBag.capacity());
    }

    @Test
    public void testAddSame(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        assertEquals("{A, A, A, A}",genericBag.toString());
        assertEquals(4,genericBag.size());
        assertEquals(10,genericBag.capacity());
    }

    @Test
    public void testRemoveEmpty(){
        genericBag.remove(new StringContent("A"));
        assertTrue(genericBag.isEmpty());
    }

    @Test
    public void testRemoveOne(){

        genericBag.add(new StringContent("B"));
        genericBag.remove(new StringContent("B"));
        assertTrue(genericBag.isEmpty());
    }

    @Test
    public void testRemoveInvalid(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        genericBag.add(new StringContent("D"));
        genericBag.remove(new StringContent("E"));
        assertEquals("{A, B, C, D}",genericBag.toString());
    }

    @Test
    public void testRemoveMultiple(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        genericBag.add(new StringContent("D"));
        genericBag.add(new StringContent("E"));
        genericBag.remove(new StringContent("D"));
        genericBag.remove(new StringContent("C"));
        genericBag.remove(new StringContent("B"));
        assertEquals("{A, E}",genericBag.toString());
    }

    @Test
    public void testContainEmpty(){
        assertFalse(genericBag.contains(new StringContent("A")));
    }

    @Test
    public void testContainNonExist(){
        genericBag.add(new StringContent("A"));
        assertFalse(genericBag.contains(new StringContent("B")));
    }

    @Test
    public void testContainExist(){
        genericBag.add(new StringContent("B"));
        assertTrue(genericBag.contains(new StringContent("B")));
    }

    @Test
    public void testIsEmptyEmpty(){
        assertTrue(genericBag.isEmpty());
    }

    @Test
    public void testIsEmptyNonEmpty(){
        genericBag.add(new StringContent("A"));
        assertFalse(genericBag.isEmpty());
    }

    @Test
    public void testClearEmpty(){
        genericBag.clear();
        assertTrue(genericBag.isEmpty());
    }

    @Test
    public void testClearNonEmpty(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.clear();
        assertTrue(genericBag.isEmpty());
    }

    @Test
    public void testSizeEmpty(){
        assertEquals(0,genericBag.size());
    }

    @Test
    public void testSizeNonEmpty(){
        genericBag.add(new StringContent("A"));
        assertEquals(1,genericBag.size());
    }

    @Test
    public void testRemoveRandomEmpty(){
        genericBag.removeRandom();
        assertNull(genericBag.removeRandom());
        assertEquals(0,genericBag.size());
    }

    @Test
    public void testRemoveRandomOne(){
        genericBag.add(new StringContent("A"));
        genericBag.removeRandom();
        assertEquals("A",genericBag.removeRandom().toString());
        assertEquals(0,genericBag.size());
    }

    @Test
    public void testRemoveRandomMultiple(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        genericBag.add(new StringContent("D"));
        genericBag.removeRandom();
        assertEquals(3,genericBag.size());
    }

    @Test
    public void testRemoveRandomSame(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.removeRandom();
        assertEquals(2,genericBag.size());
        assertEquals("A",genericBag.removeRandom().toString());


    }

    @Test
    public void testGrabRandomEmpty(){
        genericBag.grabRandom();
        assertNull(genericBag.grabRandom());
        assertEquals(0,genericBag.size());
    }

    @Test
    public void testGrabRandomOne(){
        genericBag.add(new StringContent("A"));
        genericBag.grabRandom();
        assertEquals("A",genericBag.grabRandom().toString());
        assertEquals(1,genericBag.size());
    }

    @Test
    public void testGrabRandomMultiple(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        genericBag.add(new StringContent("D"));
        genericBag.grabRandom();
        assertEquals(4,genericBag.size());
    }

    @Test
    public void testGrabRandomSame(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("A"));
        genericBag.grabRandom();
        assertEquals("A",genericBag.grabRandom().toString());
        assertEquals(3,genericBag.size());
    }

    @Test
    public void testTrimToSizeEqual(){
        genericBag = new GenericBag<>(3);
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        genericBag.trimToSize();
        assertEquals(genericBag.size(),genericBag.capacity());
    }

    @Test
    public void testTrimToSizeEmpty(){
        genericBag.trimToSize();
        assertEquals(0,genericBag.capacity());
    }

    @Test
    public void testTrimToSizeLess(){
        genericBag = new GenericBag<>(2);
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        genericBag.trimToSize();
        assertEquals(3,genericBag.capacity());
    }

    @Test
    public void testTrimToSizeMore(){
        genericBag = new GenericBag<>(5);
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.trimToSize();
        assertEquals(2,genericBag.capacity());
    }

    @Test

    public void test_Clone_EmptyBag(){
        GenericBag<StringContent> gb = genericBag.clone();

        assertEquals(10,gb.capacity());
        assertEquals(0,gb.size());
        String expected = "{}";
        assertEquals(expected,gb.toString());

    }

    @Test

    public void test_Clone_Bag_DifferentObjects(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));
        GenericBag<StringContent> gb = genericBag.clone();
        assertNotSame(genericBag,gb);
        genericBag.add(new StringContent("D"));
        assertNotEquals(genericBag.toString(),gb.toString());

        gb = genericBag.clone();
        gb.add(new StringContent("D"));
        assertNotSame(genericBag,gb);

    }

    @Test

    public void test_Clone_Identical(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = genericBag.clone();
        assertTrue(genericBag.equals(gb));

    }

    @Test

    public void test_Equals_DifferentCap(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>(45);

        gb.add(new StringContent("A"));
        gb.add(new StringContent("B"));
        gb.add(new StringContent("C"));
        assertTrue(genericBag.equals(gb));


    }

    @Test

    public void test_Equals_TwoEmpty_Sequences(){

        GenericBag<StringContent> gb = new GenericBag<>(12);
        assertTrue(genericBag.equals(gb));


    }

    @Test

    public void test_Equals_EmptyVsNonEmpty(){

        GenericBag<StringContent> gb = new GenericBag<>();
        gb.add(new StringContent("A"));
        gb.add(new StringContent("B"));
        gb.add(new StringContent("C"));

        assertFalse(genericBag.equals(gb));

    }

    @Test


    public void test_Equals_NonEmptyVsEmpty(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>();

        assertFalse(genericBag.equals(gb));

    }


    @Test

    public void test_Equals_DifferentSize(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>(45);

        gb.add(new StringContent("A"));
        gb.add(new StringContent("B"));

        assertFalse(genericBag.equals(gb));

    }

    @Test


    public void test_Equals_DifferentElements(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>(45);

        gb.add(new StringContent("A"));
        gb.add(new StringContent("B"));
        gb.add(new StringContent("D"));
        assertFalse(genericBag.equals(gb));

    }



    @Test

    public void test_Equals_Reflexivity(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        assertTrue(genericBag.equals(genericBag));

    }

    @Test

    public void test_Equals_Clone(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = genericBag.clone();
        assertTrue(genericBag.equals(gb));


    }

    @Test


    public void test_Equals_Symmetry(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>(45);

        gb.add(new StringContent("A"));
        gb.add(new StringContent("B"));
        gb.add(new StringContent("C"));
        assertTrue(genericBag.equals(gb));
        assertTrue(gb.equals(genericBag));

    }

    @Test
    public void testUnionBothEmpty(){
        GenericBag<StringContent> gb = new GenericBag<>();
        GenericBag<StringContent> union = genericBag.union(gb);
        assertTrue(genericBag.isEmpty());
        assertTrue(gb.isEmpty());
        assertTrue(union.isEmpty());
    }

    @Test
    public void testUnionEmptyVsNonEmpty(){
        GenericBag<StringContent> gb = new GenericBag<>(45);

        gb.add(new StringContent("A"));
        gb.add(new StringContent("B"));
        gb.add(new StringContent("C"));

        GenericBag<StringContent> union = genericBag.union(gb);
        assertEquals("{}", genericBag.toString());
        assertEquals("{A, B, C}", gb.toString());
        assertEquals(3,union.size());


    }

    @Test
    public void testUnionNonEmptyVsEmpty(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>(45);

        GenericBag<StringContent> union = genericBag.union(gb);
        assertEquals("{A, B, C}",genericBag.toString());
        assertTrue(gb.isEmpty());
        assertEquals(3,union.size());
    }

    @Test
    public void testUnionNonEmptyVsNonEmpty(){
        genericBag.add(new StringContent("A"));
        genericBag.add(new StringContent("B"));
        genericBag.add(new StringContent("C"));

        GenericBag<StringContent> gb = new GenericBag<>(45);

        gb.add(new StringContent("D"));
        gb.add(new StringContent("E"));
        gb.add(new StringContent("F"));

        GenericBag<StringContent> union = genericBag.union(gb);
        assertEquals(6,union.size());
        assertEquals("{A, B, C}",genericBag.toString());
        assertEquals("{D, E, F}",gb.toString());

    }











}
