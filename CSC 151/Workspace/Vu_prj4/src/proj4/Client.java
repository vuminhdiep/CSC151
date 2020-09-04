package proj4;
/**
 * The class to run the program by creating a converter and converting infix to postfix from the file path
 * Print out the result from the console
 * 
 * @author Emma Vu
 * @version 5/23/2020
 */

public class Client
{
    public static void main(String[] args)
    {
        Converter inFixToPostFix = new Converter("src/proj4/proj4_input.txt");
        inFixToPostFix.convert();
       
    }
}
