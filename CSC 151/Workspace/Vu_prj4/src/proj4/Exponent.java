package proj4;

/**
 * The token represents the operator exponent "^"
 * This is an operator which implements the interface Operator and interface Token
 * This operator has precedence 3 when it comes to the order of operation
 * The higher the order of operation, the higher the precedence
 *
 * 
 * @author Emma Vu
 * @version 5/23/2020
 */
public class Exponent implements Token, Operator{
    private final int PRECEDENCE = 3;

    /**
     * Get the precedence of the operator
     * @return the precendence of divide, which is 3
     */
    public int getPrecedent(){
        return PRECEDENCE;
    }

    /**
     * Compare this operator to other operator, if this operator has higher precedent
     * return 1, if this operator has lower precedent return -1, if this operator has
     * equal precedent return 0
     * @param other other Operator to compare to
     * @return 1 if higher, -1 if lower, 0 if equal precedent
     */

    public int compareTo(Operator other){
        if(this.getPrecedent() > other.getPrecedent()){
            return 1;
        }
        else if(this.getPrecedent() < other.getPrecedent()){
            return -1;
        }
        else{
            return 0;
        }
    }

    /**
     * Print out the toString of the operator
     * @return the String of Exponent, which is "^"
     */

    public String toString() {
        return "^";
    }
    /**
     * Take a stack, pop and append to the postfix string every operator on the
     * stack until one of the following conditions occurs:
     * 1. the stack is empty
     * 2. the top of the stack is a left parenthesis (which stays on the stack)
     * 3. the operator on top of the stack has a lower precedence than the current operator
     * Then push the current operator onto the stack.
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the string with the popped operators, "^"
     */

    public String handle(Stack<Token> s) {
        String result = "";

        while(!s.isEmpty() && !s.peek().toString().equals("(") && this.compareTo((Operator)s.peek()) <= 0){
            result += s.pop().toString();
        }
        s.push(this);

        return result;
    }




}
