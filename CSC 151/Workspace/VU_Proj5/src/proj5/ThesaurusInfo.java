package proj5;
/**
 * @author Emma Vu
 * @version 6/4/2020
 * A wrapper that contains the content of a thesaurus (like a node in a Thesaurus BST)
 * CLASS INVARIANT: This class has two instance variable
 * which holds the value of a String, and a correspond synonyms list in a bag
 * synonyms.
 * WHEN COMPARING TWO ThesaurusInfo, WE ONLY CARE AND COMPARE THE STRING VALUE
 * NOT THE synonyms list
 * (because if two ThesaurusInfo has the same String entry, then its synonyms is by default
 * equal. The class invariant of the compareTo method to be the result of comparing the
 * two instance variable String entry, ignoring the synonyms)
 */


public class ThesaurusInfo implements Comparable {
    private final int INITIAL_CAPACITY = 10;
    private String entry;
    private GenericBag<StringContent> syns;

    /**
     * Non default constructor to create the content of the thesaurus with a keyword and a synonym list
     * @param keyword
     */

    public ThesaurusInfo(String keyword){
        entry = keyword;
        syns = new GenericBag<StringContent>(INITIAL_CAPACITY);
    }

    /**
     * determine if this ThesaurusInfo is greater, less, or equal other ThesaurusInfo
     * look at class invariant for the definition of comparing two ThesaurusInfo.
     * @param other the other ThesaurusInfo
     * @return 1 if greater, -1 if smaller, 0 if equal
     */

    public int compareTo(Object other){
        return this.entry.compareTo(((ThesaurusInfo) other).entry);
    }

    /**
     * get the entry (keyword) in the thesaurus
     * @return the keyword
     */

    public String getEntry() {
        return entry;
    }

    /**
     * get a random synonyms of entry
     * @return a random element of synonyms
     */
    public String getSyns(){
        if(!syns.isEmpty()){
            return syns.grabRandom().getContent();
        }
        else return "";
    }

    /**
     * add the new value to synonyms
     * @param value the value to be added
     */
    public void addSyns(String value){
        StringContent valueContent = new StringContent(value);
        syns.add(valueContent);
    }
    /**
     * Return the string value of the ThesaurusInfo, which is represented by an
     * entry, following by the synonyms list.
     */

    public String toString(){
        return entry + " - " + syns.toString();

    }

}
