package proj5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test the functionality of Thesaurus
 *
 * @author: Emma Vu
 * @version: 6/5/2020
 */
public class ThesaurusTest {


    private Thesaurus makeDefaultThesaurus() {
        Thesaurus thesaurus = new Thesaurus();
        return thesaurus;
    }

    private Thesaurus makeNonDefaultThesaurus(String file) {
        Thesaurus thesaurus = new Thesaurus(file);
        return thesaurus;
    }

    @Test
    public void testToStringEmpty(){
        Thesaurus empty = makeDefaultThesaurus();
        assertEquals(empty.toString(),"");
    }

    @Test
    public void testToStringAndConstructor(){
        Thesaurus empty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        assertEquals(empty.toString(),"blue - {cyan, azure, cobalt, navy, aquamarine}\n" +
                "hi - {hello, sup, cia, chao}\n");
    }

    @Test
    public void testInsertNotIn(){
        Thesaurus empty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        empty.insert("tiger",new String[]{"cat","lion","panther"});
        assertEquals(empty.toString(),"blue - {cyan, azure, cobalt, navy, aquamarine}\n" +
                "hi - {hello, sup, cia, chao}\n" +
                "tiger - {cat, lion, panther}\n");
    }
    @Test
    public void testInsertIn(){
        Thesaurus empty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        empty.insert("blue",new String[]{"xanh"});
        assertEquals(empty.toString(),"blue - {cyan, azure, cobalt, navy, aquamarine, xanh}\n" +
                "hi - {hello, sup, cia, chao}\n");
    }

    @Test
    public void testIsInThesaurusEmpty(){
        Thesaurus empty = makeDefaultThesaurus();
        assertFalse(empty.isInThesaurus("hi"));
    }

    @Test
    public void testIsInThesaurus(){
        Thesaurus nonEmpty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        assertTrue(nonEmpty.isInThesaurus("blue"));
    }

    @Test
    public void testGetSynonymExist(){
        Thesaurus nonEmpty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        assertNotEquals("blue",nonEmpty.getSynonymFor("blue"));
    }

    @Test
    public void testGetSynonymNonExist(){
        Thesaurus nonEmpty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        assertEquals("", nonEmpty.getSynonymFor("aabc"));
    }

    @Test
    public void testDeleteExist(){
        Thesaurus nonEmpty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        nonEmpty.delete("blue");
        assertEquals(nonEmpty.toString(),"hi - {hello, sup, cia, chao}\n");
    }

    @Test
    public void testDeleteNonExist(){
        Thesaurus nonEmpty = makeNonDefaultThesaurus("src/thesaurusText.txt");
        nonEmpty.delete("green");
        assertEquals(nonEmpty.toString(),"blue - {cyan, azure, cobalt, navy, aquamarine}\n" +
                "hi - {hello, sup, cia, chao}\n");    }



}

