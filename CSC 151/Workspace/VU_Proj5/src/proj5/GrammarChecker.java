package proj5;

/**
 * Uses a thesaurus and word frequencies to replace overused words in a text document with random synonyms.
 */
public class GrammarChecker {
    private Thesaurus thesaurus;
    private int threshold;
    private WordCounter wordCounter;
    private LineReader reader;
    private String[] currentLine;

    /**
     * Non-default constructor.
     * Builds a thesaurus out of the given comma-separated file and sets the threshold for overused words
     * @param thesaurusFile path to comma-separated file used to build a thesaurus
     * @param threshold a word is considered "overused"
     * if it appears more than (but not equal to) this many times in a text document
     */
    public GrammarChecker(String thesaurusFile, int threshold){

        thesaurus = new Thesaurus(thesaurusFile);
        this.threshold = threshold;
        wordCounter = new WordCounter();
        reader = null;
        currentLine = null;
    }

    /**
     * Given a text file, replaces overused words with synonyms. Finished text is printed to the console.
     * @param textfile file with original text
     */
    public void improveGrammar(String textfile){

        wordCounter.findFrequencies(textfile);
        reader= new LineReader(textfile," ");
        currentLine= reader.getNextLine();

        String res="";

        while (currentLine!=null){
            for(String s:currentLine){
                if(isOnlyLetters(s)) {
                    res += handleString(s, wordCounter);
                }
                else{
                    res += s + " ";
                }
            }


            currentLine = reader.getNextLine();

            if(currentLine!=null){
                res+="\n";
            }
        }
        System.out.println(res);
    }

    /**
     * Check if a String contains only letters
     * @param toCheck the String to check
     * @return true if the String contains only letter, false otherwise.
     */
    private boolean isOnlyLetters(String toCheck){
        for(int i=0;i<toCheck.length()-1;i++){
            char c=toCheck.charAt(i);
            if(!Character.isLetter(c)){
                return false;
            }

        }
        return true;
    }


    /**
     * Handle a word in the input file:
     * 1. Check to see if the word is in upper case. If it is, make the word lower to check for frequency
     * 2. Strip the last part of the word if it is not a letter
     * to check for frequency with word counter
     * 3. Check if the word need replace has the frequency is higher than
     * threshold. If it is higher, get the synonyms of that word
     * 4. Change the word back to original state
     * by putting the non-letter characters back if any and by making the word upper case again
     * @param toHandle the word to handle
     * @param wc the counter to count for frequency
     * @return the newly handled word with space for a new word
     */
    private String handleString(String toHandle, WordCounter wc){
        boolean hasUppercase = !toHandle.equals(toHandle.toLowerCase());
        toHandle=toHandle.toLowerCase();

        char last = toHandle.charAt(toHandle.length() - 1);
        if (!Character.isLetter(last)){
            toHandle = toHandle.substring(0, toHandle.length() - 1);
        }

        int freq = wc.getFrequency(toHandle);
        String replace = toHandle;
        if (freq > threshold && thesaurus.isInThesaurus(toHandle)) {
            replace = thesaurus.getSynonymFor(toHandle);
        }

        if (Character.isLetter(last)) {
            replace += "";
        }
        else{
            replace += last;
        }
        if (hasUppercase)
            replace = (replace.charAt(0) + "").toUpperCase() + replace.substring(1, replace.length());
        return  replace + " ";
    }
}
