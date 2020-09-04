package proj5;

/**
 * class for computing word frequencies from a text file
 * For the word counter, you should build the frequency BST in one pass of the input file. For each
 * word, search for it in the BST. If you find it, increase its frequency counter by 1. If you don't find
 * it, insert the brand new word into the tree.
 * This class is implemented using a BST holding FrequencyInfo
 * Each FrequencyInfo represents a string and its correspond frequency.
 */
public class WordCounter {

    private BinarySearchTree<FrequencyInfo> counter;
    private LineReader reader;
    private String[] currentLine;

    public WordCounter(){

        counter = new BinarySearchTree<FrequencyInfo>();
        reader = null;
        currentLine = null;
    }

    /**
     * PRECONDITION: file cannot be empty, or else there would be error
     * Computes frequency of each word in given file
     * SPECIFICATION: Each FrequencyInfo in the tree represents a string and its correspond frequency.
     * Thus each time we see an old word, we check if there is a FrequencyInfo in the tree
     * holding that word first, before incrementing the correspond frequency.
     * Computes frequency of each word in given file
     * @param file path to file, such as "src/input.txt"
     *
     *
     */
    public void findFrequencies(String file){

        reader = new LineReader(file, " ");
        currentLine = reader.getNextLine();
        while(currentLine!=null) {
            for (String word : currentLine) {
                String res = keepOnlyLetter(word);
                if(!res.equals("")) {
                    FrequencyInfo content = counter.search(new FrequencyInfo(res));
                    if (content == null){
                        counter.insert(new FrequencyInfo(res));

                        content = counter.search(new FrequencyInfo(res));
                        content.increaseFrequency();
                    }
                    else{
                        content.increaseFrequency();
                    }
                }

            }
            currentLine = reader.getNextLine();
        }
    }

    /**
     * returns the frequency of the given word
     * @param word string to get the frequency of
     * @return the number of times word appears in the input file
     */
    public int getFrequency(String word){
        FrequencyInfo frequency = counter.search(new FrequencyInfo(word));
        if(frequency == null){
            return 0;
        }
        return frequency.getFrequency();

    }

    /**
     * Each word/frequency pair should be on a separate line, and the format of each line should be <word>: <frequency>
     * For example,
     * are: 3
     * bacon: 2
     * Words should be in alphabetical order.
     * @return words and their frequencies as a printable String.
     */
    public String toString(){
        return counter.toStringOrder();
    }

    /**
     * PRECONDITION: s is not null
     * handle syntax and keep only letter
     * @param s the String to handle
     * @return the handled String stripped of all non letter
     */
    private String keepOnlyLetter(String s){
        String finalS= "";
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetter(c)){
                finalS += c;
            }
        }
        return finalS;
    }



}
