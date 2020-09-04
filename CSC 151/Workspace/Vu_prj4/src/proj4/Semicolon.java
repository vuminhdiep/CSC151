package proj4;

/**
 * This class implements Token interface and represents Semicolon ";"
 *
 * @author Emma Vu
 * @version 5/25/2020
 */
public class Semicolon implements Token {
    /**
     * The Semicolon indicates that the infix expression has been completely scanned.
     * However, the stack may still contain some operators. All remaining operators
     * should be popped and appended to the postfix string
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the string with all the leftover popped operators
     */
    public String handle(Stack<Token> s){
        String result = "";
        while(!s.isEmpty()){
            result += s.pop();
        }
        return result;
    }

    /**
     * print out the representation of semicolon in toString
     * @return the string representation, which is ";"
     */
    public String toString(){
        return ";";
    }
	
}
