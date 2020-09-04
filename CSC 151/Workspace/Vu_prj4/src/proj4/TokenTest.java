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
public class TokenTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private Stack<Token> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testToStringRightParen(){
        RightParen rightParen = new RightParen();
        assertEquals(")",rightParen.toString());
        stack.push(rightParen);
        assertEquals("{>)}",stack.toString());
    }

    @Test
    public void testToStringLeftParen(){
        LeftParen leftParen = new LeftParen();
        assertEquals("(",leftParen.toString());
        stack.push(leftParen);
        assertEquals("{>(}",stack.toString());
    }

    @Test
    public void testToStringPlus(){
        Plus plus = new Plus();
        assertEquals("+",plus.toString());
        stack.push(plus);
        assertEquals("{>+}",stack.toString());
    }

    @Test
    public void testToStringMinus(){
        Minus minus = new Minus();
        assertEquals("-",minus.toString());
        stack.push(minus);
        assertEquals("{>-}",stack.toString());
    }

    @Test
    public void testToStringMultiply(){
        assertEquals("*",new Multiply().toString());
        stack.push(new Multiply());
        assertEquals("{>*}",stack.toString());
    }

    @Test
    public void testToStringDivide(){
        Divide divide = new Divide();
        assertEquals("/",divide.toString());
        stack.push(divide);
        assertEquals("{>/}",stack.toString());
    }

    @Test
    public void testToStringExponent(){
        Exponent exponent = new Exponent();
        assertEquals("^",exponent.toString());
        stack.push(exponent);
        assertEquals("{>^}",stack.toString());
    }

    @Test
    public void testToStringSemiColon(){
        Semicolon semiColon = new Semicolon();
        assertEquals(";",semiColon.toString());
        stack.push(semiColon);
        assertEquals("{>;}",stack.toString());
    }

    @Test
    public void testConstructor(){
        assertEquals ("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }

    @Test
    public void testPlusEmpty(){

        Plus plus = new Plus();
        String returnStr = plus.handle(stack);
        assertEquals(stack.toString(),"{>+}");
        assertEquals("",returnStr);
    }
    @Test
    public void testPushPlus(){
        Plus plus = new Plus();
        stack.push(plus);
        assertEquals("{>+}",stack.toString());


    }


    @Test
    public void testPlusEqualPrecedent(){
        Plus plus = new Plus();

        stack.push(new Minus());
        stack.push(new Minus());
        stack.push(plus);

        String returnStr = plus.handle(stack);
        assertEquals(stack.toString(),"{>+}");
        assertEquals("+--",returnStr);
    }

    @Test
    public void testPlusHigherPrecedent(){
        stack.push(new Multiply());
        stack.push(new Divide());
        stack.push(new Exponent());
        stack.push(new Multiply());

        String returnStr = new Plus().handle(stack);
        assertEquals(stack.toString(),"{>+}");
        assertEquals("*^/*",returnStr);
    }

    @Test
    public void testPlusRandomPrecedent(){
        stack.push(new Multiply());
        stack.push(new Plus());
        stack.push(new Divide());
        stack.push(new Minus());

        String returnStr = new Plus().handle(stack);
        assertEquals(stack.toString(),"{>+}");
        assertEquals("-/+*",returnStr);
    }


    @Test
    public void testMinusEmpty(){


        String returnStr = new Minus().handle(stack);
        assertEquals(stack.toString(),"{>-}");
        assertEquals("",returnStr);
    }
    @Test
    public void testPushMinus(){

        stack.push(new Minus());
        assertEquals("{>-}",stack.toString());


    }


    @Test
    public void testMinusEqualPrecedent(){

        Minus minus = new Minus();
        stack.push(new Plus());
        stack.push(new Plus());
        stack.push(new Minus());

        String returnStr = minus.handle(stack);
        assertEquals(stack.toString(),"{>-}");
        assertEquals("-++",returnStr);
    }

    @Test
    public void testMinusHigherPrecedent(){
        stack.push(new Multiply());
        stack.push(new Divide());
        stack.push(new Exponent());
        stack.push(new Multiply());

        String returnStr = new Minus().handle(stack);
        assertEquals(stack.toString(),"{>-}");
        assertEquals("*^/*",returnStr);
    }

    @Test
    public void testMinusRandomPrecedent(){
        stack.push(new Multiply());
        stack.push(new Plus());
        stack.push(new Divide());
        stack.push(new Minus());

        String returnStr = new Minus().handle(stack);
        assertEquals(stack.toString(),"{>-}");
        assertEquals("-/+*",returnStr);
    }

    @Test
    public void testMinusLeftParen(){
        stack.push(new Multiply());
        stack.push(new Plus());
        stack.push(new LeftParen());
        stack.push(new Divide());
        stack.push(new Minus());

        String returnStr = new Minus().handle(stack);
        assertEquals(returnStr, "-/");

    }

    @Test
    public void testMultiplyEmpty(){
        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*}");
        assertEquals("",returnStr);
    }
    @Test
    public void testMultiplyLowerPrecedent(){
        stack.push(new Plus());
        stack.push(new Minus());
        stack.push(new Minus());
        stack.push(new Minus());

        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*,-,-,-,+}");
        assertEquals("",returnStr);
    }

    @Test
    public void testMultiplyEqualPrecedent(){
        stack.push(new Multiply());
        stack.push(new Divide());
        stack.push(new Multiply());
        stack.push(new Divide());

        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*}");
        assertEquals("/*/*",returnStr);
    }
    @Test
    public void testMultiplyHigherPrecedent(){
        stack.push(new Exponent());
        stack.push(new Exponent());
        stack.push(new Exponent());
        stack.push(new Exponent());

        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*}");
        assertEquals("^^^^",returnStr);
    }
    @Test
    public void testMultiplyLowerThenHigherPrecedent(){
        stack.push(new Plus());
        stack.push(new Plus());
        stack.push(new Exponent());
        stack.push(new Exponent());

        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*,+,+}");
        assertEquals("^^",returnStr);
    }
    @Test
    public void testMultiplyHigherThenLowerPrecedent(){
        stack.push(new Exponent());
        stack.push(new Exponent());
        stack.push(new Plus());
        stack.push(new Plus());

        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*,+,+,^,^}");
        assertEquals("",returnStr);

    }

    @Test
    public void testMultiplyRandomPrecedent(){
        stack.push(new Exponent());
        stack.push(new Plus());
        stack.push(new Divide());
        stack.push(new Multiply());

        String returnStr = new Multiply().handle(stack);
        assertEquals(stack.toString(),"{>*,+,^}");
        assertEquals("*/",returnStr);
    }

    @Test
    public void testExponentEmpty(){
        String returnStr = new Exponent().handle(stack);
        assertEquals(stack.toString(),"{>^}");
        assertEquals("",returnStr);
    }

    @Test
    public void testExponentLowerPrecedent(){
        stack.push(new Plus());
        stack.push(new Minus());
        stack.push(new Multiply());
        stack.push(new Divide());

        String returnStr = new Exponent().handle(stack);
        assertEquals(stack.toString(),"{>^,/,*,-,+}");
        assertEquals("",returnStr);
    }
    @Test
    public void testExponentEqualPrecedent(){
        stack.push(new Exponent());
        stack.push(new Exponent());
        stack.push(new Exponent());
        stack.push(new Exponent());

        String returnStr = new Exponent().handle(stack);
        assertEquals(stack.toString(),"{>^}");
        assertEquals("^^^^",returnStr);

    }

    @Test
    public void testSemiColonEmpty(){
        String returnStr = new Semicolon().handle(stack);
        assertEquals(stack.toString(),"{>}");
        assertEquals("",returnStr);
    }

    @Test
    public void testSemiColon(){
        stack.push(new Plus());
        stack.push(new Minus());
        stack.push(new Multiply());
        stack.push(new Divide());

        String returnStr = new Semicolon().handle(stack);
        assertEquals(stack.toString(),"{>}");
        assertEquals("/*-+",returnStr);
    }

    @Test
    public void testLeftParenEmpty(){
        String returnStr = new LeftParen().handle(stack);
        assertEquals(stack.toString(),"{>(}");
        assertEquals("",returnStr);

    }

    @Test
    public void testLeftParenNonEmpty(){
        stack.push(new Plus());
        stack.push(new Minus());
        stack.push(new Multiply());
        stack.push(new Divide());

        String returnStr = new LeftParen().handle(stack);
        assertEquals(stack.toString(),"{>(,/,*,-,+}");
        assertEquals("",returnStr);
    }

    @Test
    public void testRightParenNoneBetween(){
        stack.push(new LeftParen());

        String returnStr = new RightParen().handle(stack);
        assertEquals(stack.toString(),"{>}");
        assertEquals("",returnStr);

    }

    @Test
    public void testRightParenBetween(){
        stack.push(new Plus());
        stack.push(new Minus());
        stack.push(new LeftParen());
        stack.push(new Multiply());
        stack.push(new Divide());

        String returnStr = new RightParen().handle(stack);
        assertEquals(stack.toString(),"{>-,+}");
        assertEquals("/*",returnStr);
    }





}

