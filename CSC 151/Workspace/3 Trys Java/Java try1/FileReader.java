
/**
 * A FileReader object will read tokens from an input file.  The name of
 * the input file is given when the constructor is run.  (For BlueJ users,
 * the entire path must be specified.  See below.)  The lone method,
 * nextToken(), will return the next word in the file as a String.
 * Don't worry about understanding this code for now.  But test it to
 * be sure it works on your system.
 * 
 * @author Chris Fernandes
 * @version 2/9/02
 */
import java.io.*;

public class FileReader 
{
    
    private StreamTokenizer st;     //file descriptor

    //the input file is given at object creation time.  For BlueJ users,
    //the entire path must be given using TWO slashes for the directory.
    //For example, "C:\\bluej\\project 5\\input.txt"
    public FileReader(String fileName) 
    {
        try {
        st = new StreamTokenizer(
                 new BufferedReader(
                     new InputStreamReader(
                         new FileInputStream(fileName))));
        } catch (IOException e) {}
        st.resetSyntax();                     // remove default rules                
        st.ordinaryChars(0, Character.MAX_VALUE); //turn on all chars
        st.wordChars(33,122);      
        st.whitespaceChars(0, 32);   // space separates tokens
        st.whitespaceChars(123, Character.MAX_VALUE);
    }

    //returns the next token as a String.  Possible tokens are
    //words, the pound symbol "#" signifying the end of a page,
    //and the special token "EOF" which is returned when the end 
    //of the input file is reached.
    public String nextToken() 
    {
        try
        {
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            if (st.ttype < 0)
            {
                return st.sval;
            }
            else
            {
                return String.valueOf((char)st.ttype);
            }
        }
        return "EOF";
        } catch (IOException e) {}
        return "error";
    }
}
