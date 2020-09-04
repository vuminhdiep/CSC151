package proj5;

/**
 * Data structure that holds words and their associated synonyms. You can look up a word and retrieve a synonym for it.
 * The thesaurus gets searched for each overused word found.
 * Thesaurus class for holding all of the entries and their synonyms
 * CLASS SPECIFICATION: This class is implemented using a BST holding ThesaurusInfo
 * Each ThesaurusInfo represents an entry and its correspond synonyms.
 */
public class Thesaurus {
    private BinarySearchTree<ThesaurusInfo> thesaurus;
    private LineReader reader;
    private String[] currentLine;

    //default constructor to create an empty thesaurus
    public Thesaurus(){
        thesaurus = new BinarySearchTree<ThesaurusInfo>();
        reader = null;
        currentLine = null;
        buildThesaurus();

    }

    /**
     * non-default constructor
     * Builds a thesaurus from a text file. Each line of the text file is a comma-separated list of synonymous words.
     * The first word in each line should be the thesaurus entry.
     * The remaining words on that line are the list of synonyms for the entry.
     * @param file path to comma-delimited text file
     */
    public Thesaurus(String file){
        thesaurus = new BinarySearchTree<ThesaurusInfo>();
        reader = new LineReader(file,",");
        currentLine = reader.getNextLine();
        buildThesaurus();

    }

    /**
     * A private helper method to build the thesaurus by inserting the first word as a new entry and copying the rest
     * as synonyms. Insert in the thesaurus line by line
     */
    private void buildThesaurus(){
        while(currentLine!=null){
            thesaurus.insert(new ThesaurusInfo(currentLine[0]));
            insert(currentLine[0],copy(currentLine,1,currentLine.length));
            currentLine = reader.getNextLine();
        }
    }



    /**
     * inserts entry and synonyms into thesaurus.
     * If entry does not exist, it creates one.
     * If it does exist, it adds the given synonyms to the entry's synonym list
     * @param entry keyword to be added
     * @param syns array of synonyms for keyword entry
     */
    public void insert(String entry, String[] syns){
        ThesaurusInfo entryInfo = new ThesaurusInfo(entry);

        if(!isInThesaurus(entry)){
            thesaurus.insert(entryInfo);
            addSynsOfExistEntryToThesaurus(entry, syns);

        }
        else{

            addSynsOfExistEntryToThesaurus(entry, syns);

        }



    }

    /**
     * private helper method to add the synonyms of an exist entry to the thesaurus
     * @param entry the keyword in the thesaurus
     * @param syns the list of the synonyms to add to the thesaurus
     */

    private void addSynsOfExistEntryToThesaurus(String entry, String [] syns){
        ThesaurusInfo content = thesaurus.search(new ThesaurusInfo(entry));
        int count = 0;
        for(int i = 0; i < syns.length; i++){
            content.addSyns(syns[count]);
            count++;
        }

    }

    /**
     * removes entry (and its associated synonym list) from this thesaurus. If entry does not exist, do nothing.
     * @param entry word to remove
     */
    public void delete(String entry){
        thesaurus.delete(new ThesaurusInfo(entry));

    }

    /**
     * Gets a random synonym for the given keyword. If keyword does not exist, return the empty string
     * @param keyword word to find a synonym for
     * @return a random synonym from the synonym list of that word, or empty string if keyword doesn't exist.
     */
    public String getSynonymFor(String keyword){
        ThesaurusInfo synsList = thesaurus.search(new ThesaurusInfo(keyword));
        if(!isInThesaurus(keyword)){
            return "";
        }
        else {
            return synsList.getSyns();
        }

    }

    /**
     * Each keyword and synonym list should be on its own line.
     * The format of each line is: <keyword> - {<syn1>, <syn2>, ..., <synN>}
     * For example,
     * happy - {glad, content, joyful}
     * jump - {leap, bound}
     * The thesaurus keywords will be in alphabetical order. The order of the synonym list words is arbitrary.
     * @return this thesaurus as a printable string
     */
    public String toString(){
        return thesaurus.toStringOrder();
    }

    /**
     * check whether a keyword is in the thesaurus.
     * @param entry the keyword to check
     * @return true if the keyword is in the thesaurus. Else, false
     */
    public boolean isInThesaurus(String entry){
        if(thesaurus == null){
            return false;
        }
        ThesaurusInfo content = thesaurus.search(new ThesaurusInfo(entry));
        if(content == null){
            return false;
        } else return true;
    }

    /**
     * private helper method to copy a certain part of an array to a new array from index start to index end excluding
     * @param original the original array want to copy from
     * @param start the starting index
     * @param end the ending index
     * @return the new array with certain elements similar to the original array with corresponding indexes
     */
    private String[] copy(String[] original, int start, int end){
        int length = end - start;
        String[] newArray = new String[length];
        int count=0;
        for(int i=start;i<end;i++){
            newArray[count]=original[i];
            count++;
        }
        return newArray;


    }
}
