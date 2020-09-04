import static org.junit.Assert.*;

import org.junit.Test;

public class BallTest {

    @Test
    public void test_default_constructor(){
        Ball b1 = new Ball();
        String expected = "This is a white ball used for Football that is 10.0 inches radius";
        assertEquals(expected, b1.toString());
    }

    @Test
    public void test_non_default_constructor(){
        Ball b1 = new Ball("Basketball","orange");
        String expected = "This is a orange ball used for Basketball that is 10.0 inches radius";
        assertEquals(expected, b1.toString());
    }

}
