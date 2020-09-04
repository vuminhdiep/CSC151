package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

/**
 * test the functionality of WordCounter
 * @author: Emma Vu
 * @version: 6/5/2020
 */
public class WordCounterTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private WordCounter wc;

    @Before
    public void setUp() throws Exception {
        wc = new WordCounter();
    }

    @After
    public void tearDown() throws Exception {
        wc = null;
    }

    @Test
    public void testToStringEmpty(){

        assertEquals(wc.toString(),"");
    }

    @Test
    public void testFindFrequencyEmpty(){

        wc.findFrequencies("src/emptyText.txt");
        assertEquals(wc.toString(),"");
    }

    @Test
    public void testFindFrequency(){

        wc.findFrequencies("src/wordCountText.txt");
        assertEquals(wc.toString(),"a: 7\nb: 5\n");
    }
    @Test
    public void testGetFrequencyIn(){

        wc.findFrequencies("src/wordCountText.txt");
        assertEquals(7, wc.getFrequency("a"));
    }

    @Test
    public void testGetFrequencyNotIn(){

        wc.findFrequencies("src/wordCountText.txt");
        assertEquals(0, wc.getFrequency("c"));
    }


}