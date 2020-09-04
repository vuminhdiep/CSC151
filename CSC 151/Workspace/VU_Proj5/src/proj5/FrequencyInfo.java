package proj5;
/**
 * @author Emma Vu
 * @version 5/30/2020
 * A wrapper that contains the content of a word counter (like a node in a Word Counter BST)
 * CLASS INVARIANT: This class has two instance variable
 * which holds the value of a String, and a correspond occurence in variable
 * count.
 * WHEN COMPARING TWO FREQUENCY INFO, WE ONLY CARE AND COMPARE THE STRING VALUE
 * NOT THE INT COUNT
 * (because if two Frequency Info has the same value, then its occurence is by default
 * equal. The class invariant of the compareTo method to be the result of comparing the
 * two instance variable String value)
 */
public class FrequencyInfo implements Comparable {
    private int frequency;
    private String entry;

    public FrequencyInfo(String keyword){
        entry = keyword;
        frequency = 0;
    }
    /**
     * determine if this FrequencyInfo is greater, less, or equal other FrequencyInfo
     * look at class invariant for the definition of comparing two FrequencyInfo.
     * @param other the other FrequencyInfo
     * @return 1 if greater, -1 if smaller, 0 if equal
     */
    public int compareTo(Object other){   return this.entry.compareTo(((FrequencyInfo) other).entry);}
    /**
     * get the occurence
     * @return count, representing the occurence
     */
    public int getFrequency(){
        return frequency;
    }
    /**
     * increment the occurence by one, adding 1 to instance count
     */
    public void increaseFrequency(){
        frequency ++;
    }
    /**
     * Return the String representing the FrequencyInfo, which is the value
     * following a comma and the count value
     */
    public String toString(){
        return entry + ": " + frequency;
    }
}
