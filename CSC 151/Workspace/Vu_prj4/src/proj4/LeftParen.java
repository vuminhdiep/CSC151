package proj4;

/**
 * This class implements the Token interface and represents LeftParen as "("
 * 
 * @author Emma Vu
 * @version 5/23/2020
 */
public class LeftParen implements Token {
    /**
     * Push this Token onto the stack because it's a left parenthesis
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return an empty string
     */
    public String handle(Stack<Token> s){
        s.push(this);
        return "";
    }

    /**
     * Print out the representation of LeftParen
     * @return the representation, in this case it's "("
     */
    public String toString(){
        return "(";
    }

}
