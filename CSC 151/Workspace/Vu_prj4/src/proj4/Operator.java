package proj4;
/**
 * Describes the methods that must be defined in order for an
 * object to be considered an operator.  Not all Tokens are operators. Every Operator must have
 * precedent and must be able to get it, also, must be able to compare its
 * precedent to other operator, in this case they are "+", "-", "*", "/", "^"
 *
 * @author Emma Vu
 * @version 5/25/2020
 *
 */
public interface Operator {
    /**
     * Get the precedent of the operator
     * @return the precedent
     */
    public int getPrecedent();
    /**
     * Compare this operator to other operator, if this operator has higher precedent
     * return 1, if this operator has lower precedent return -1, if this operator has
     * equal precedent return 0
     * @param other other Operator to compare to
     * @return 1 if higher, -1 if lower, 0 if equal precedent
     */
    public int compareTo(Operator other);
}
