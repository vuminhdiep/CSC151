package proj4;

/**
 * This class implements Token interface and represents Right Parenthesis ")"
 * 
 * @author Emma Vu
 * @version 5/25/2020
 */
public class RightParen implements Token {
    /**
     * PRECONDITION: THERE IS AT LEAST ONE LEFT PAREN IN THE STACK
     * For a non-empty stack,
     * check if there is at least one left parenthesis in the stack by seeing the top of the stack.
     * If the top is a left parenthesis, pop it and discard both pair of parenthesis.
     * Else, pop all The Token out until the top of the stack is a Left Parenthesis, and add
     * those pop value to returned string.
     * After that, pop that left Parenthesis to discard both Left and Right Parenthesis and return the string
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return  the String resulted by the above operation.
     */
    public String handle(Stack<Token> s){
        String result = "";
        while(!s.peek().toString().equals("(") && !s.isEmpty()){
            result += s.pop();
        }
        s.pop();

        return result;
    }

    /**
     * Print out the representation of Right parenthesis in toString()
     * @return the string representation of Right parenthesis, which is ")"
     */

    public String toString(){
        return ")";
    }


}
