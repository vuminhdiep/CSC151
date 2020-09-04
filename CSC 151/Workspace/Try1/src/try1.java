
/**
 * try1: variable version of scheduler
 * 
 * @author Chris Fernandes
 * @date 9/9/08
 */

import javabook.*;
    
public class try1
{
    static String n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11; //names
    static String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11; //dates
    static String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11; //start times
    static String e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11; //end times

    public static void main(String[] args)
    {
        insertRequests();
        printEvents();
    }
    
    public static void insertRequests()
    {
        FileReader myReader = new FileReader("src/requests.txt");
        n1 = myReader.nextToken();
        d1 = myReader.nextToken();
        s1 = myReader.nextToken();
        e1 = myReader.nextToken();
        
        n2 = myReader.nextToken();
        d2 = myReader.nextToken();
        s2 = myReader.nextToken();
        e2 = myReader.nextToken();
        
        n3 = myReader.nextToken();
        d3 = myReader.nextToken();
        s3 = myReader.nextToken();
        e3 = myReader.nextToken();
        
        n4 = myReader.nextToken();
        d4 = myReader.nextToken();
        s4 = myReader.nextToken();
        e4 = myReader.nextToken();
        
        n5 = myReader.nextToken();
        d5 = myReader.nextToken();
        s5 = myReader.nextToken();
        e5 = myReader.nextToken();
        
        n6 = myReader.nextToken();
        d6 = myReader.nextToken();
        s6 = myReader.nextToken();
        e6 = myReader.nextToken();
        
        n7 = myReader.nextToken();
        d7 = myReader.nextToken();
        s7 = myReader.nextToken();
        e7 = myReader.nextToken();
        
        n8 = myReader.nextToken();
        d8 = myReader.nextToken();
        s8 = myReader.nextToken();
        e8 = myReader.nextToken();
        
        n9 = myReader.nextToken();
        d9 = myReader.nextToken();
        s9 = myReader.nextToken();
        e9 = myReader.nextToken();
        
        n10 = myReader.nextToken();
        d10 = myReader.nextToken();
        s10 = myReader.nextToken();
        e10 = myReader.nextToken();
        
        n11 = myReader.nextToken();
        d11 = myReader.nextToken();
        s11 = myReader.nextToken();
        e11 = myReader.nextToken();
    }

    public static void printEvents()
    {
        String userdate;
        InputBox inbox = new InputBox();
        userdate=inbox.getString("Events for what date?");
        System.out.println("Events for " + userdate);
        System.out.println("-------------------");
        if (d1.equals(userdate))
        {
            System.out.println(n1);
            System.out.println("Starting at " + s1);
            System.out.println("Until " + e1);
            System.out.println();
        }
        if (d2.equals(userdate))
        {
            System.out.println(n2);
            System.out.println("Starting at " + s2);
            System.out.println("Until " + e2);
            System.out.println();

        }
        if (d3.equals(userdate))
        {
            System.out.println(n3);
            System.out.println("Starting at " + s3);
            System.out.println("Until " + e3);
            System.out.println();
        }
        if (d4.equals(userdate))
        {
            System.out.println(n4);
            System.out.println("Starting at " + s4);
            System.out.println("Until " + e4);
            System.out.println();
        }
        if (d5.equals(userdate))
        {
            System.out.println(n5);
            System.out.println("Starting at " + s5);
            System.out.println("Until " + e5);
            System.out.println();
        }
        if (d6.equals(userdate))
        {
            System.out.println(n6);
            System.out.println("Starting at " + s6);
            System.out.println("Until " + e6);
            System.out.println();
        }
        if (d7.equals(userdate))
        {
            System.out.println(n7);
            System.out.println("Starting at " + s7);
            System.out.println("Until " + e7);
            System.out.println();
        }
        if (d8.equals(userdate))
        {
            System.out.println(n8);
            System.out.println("Starting at " + s8);
            System.out.println("Until " + e8);
            System.out.println();
        }
        if (d9.equals(userdate))
        {
            System.out.println(n9);
            System.out.println("Starting at " + s9);
            System.out.println("Until " + e9);
            System.out.println();
        }
        if (d10.equals(userdate))
        {
            System.out.println(n10);
            System.out.println("Starting at " + s10);
            System.out.println("Until " + e10);
            System.out.println();
        }
        if (d11.equals(userdate))
        {
            System.out.println(n11);
            System.out.println("Starting at " + s11);
            System.out.println("Until " + e11);
            System.out.println();
        }
    }	
}
