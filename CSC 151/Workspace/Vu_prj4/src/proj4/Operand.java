package proj4;
/**
 *
 * This class implements Token and represents operands (capital letters) like "A", "B", "C", etc.
 * Anything that is not an operator, left parenthesis, right parenthesis, and semicolon is considered to be an operand.
 * The input of this operand is a String.
 *
 * @author Emma Vu
 * @version 5/25/2020
 */
public class Operand implements Token {
    private String inputStr;

    /**
     * default constructor where the operand is represented by an empty string
     */
    public Operand(){
        inputStr = "";
    }

    /**
     * non-default constructor where it is represented by a string
     * @param initialStr
     */
    public Operand(String initialStr){
        inputStr = initialStr;
    }

    /**
     * Return the String representation of this operand
     * @return The String of operand.
     */

    public String toString(){
        return inputStr;
    }

    /**
     * An operand (represented by a capital letter), immediately append it to the postfix string.
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the string of this operand so that can add it to the postfix later
     */
    public String handle(Stack<Token> s){
        return toString();
    }
}
