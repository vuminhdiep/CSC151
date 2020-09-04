package proj5;

/**
 * Run the program to check the output of grammar checker
 */
public class Client {
    public static void main(String[] arg){
        System.out.println("Original:");
        System.out.println();
        GrammarChecker test = new GrammarChecker("src/smallThesaurus.txt", 10);
        test.improveGrammar("src/grammarTest.txt");
        System.out.println();
        System.out.println("Change threshold should replace all:");
        System.out.println();
        GrammarChecker test2 = new GrammarChecker("src/smallThesaurus.txt", 8);
        test2.improveGrammar("src/grammarTest.txt");
        System.out.println();
        System.out.println("Output of two given text:");
        GrammarChecker apartment = new GrammarChecker("src/smallThesaurus.txt", 2);
        apartment.improveGrammar("src/apartment.txt");
        System.out.println();
        GrammarChecker lamb = new GrammarChecker("src/bigThesaurus.txt", 3);
        lamb.improveGrammar("src/lamb.txt");
        System.out.println();
        System.out.println("Test upperCase: output should maintain the upper case whether they are improved grammar");
        System.out.println();
        GrammarChecker test3 = new GrammarChecker("src/bigThesaurus.txt",3);
        test3.improveGrammar("src/upperCase.txt");
        System.out.println();
        System.out.println("Test punctuation: output should still include punctuation like comma, period");
        System.out.println();
        GrammarChecker test4 = new GrammarChecker("src/smallThesaurus.txt",3);
        test4.improveGrammar("src/punctuationTest.txt");

    }
}
