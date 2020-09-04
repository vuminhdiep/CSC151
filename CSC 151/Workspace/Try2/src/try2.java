
/**
 * try2 -- parallel array version of scheduler
 * 
 * @author Chris Fernandes
 * @date 9/9/08
 */

import javabook.*;
    
public class try2
{
    final static int ORIG_SIZE = 15;   //better have enough room...
    static int size;                   //current # of events in arrays
    
    public static void main(String[] args)
    {
        String[] eventName = new String[ORIG_SIZE];
        String[] eventDate = new String[ORIG_SIZE];
        String[] startTime = new String[ORIG_SIZE];
        String[] endTime = new String[ORIG_SIZE];
        size=0;  // arrays start out empty

        insertRequests(eventName, eventDate, startTime, endTime);
        printEvents(eventName, eventDate, startTime, endTime);
    }
    
    public static void insertRequests(String[] eventName, String[] eventDate,
                    String[] startTime, String[] endTime)
    {
        String c;           // current token
        String tempname;    // event name read from file
        String tempdate;    // event date read from file
        String tempstart;   // event start time read from file
        String tempend;     // event end time read from file
        int counter;
        FileReader myReader = new FileReader("src/requests.txt");
        c = myReader.nextToken();
        while (!c.equals("EOF"))
        {
        	// parse the reservation into four pieces
            tempname=c;
            tempdate=myReader.nextToken();
            tempstart=myReader.nextToken();
            tempend=myReader.nextToken();
            counter=0;
            
            // find correct place in array (sorted by date)
            while (counter < size && eventDate[counter].compareTo(tempdate)<0)
            {
                counter++;
            }
            
            // make room by moving 1 to the right
            for (int i=size; i>counter; i--)
            {
                eventName[i]=eventName[i-1];
                eventDate[i]=eventDate[i-1];
                startTime[i]=startTime[i-1];
                endTime[i]=endTime[i-1];
            }
            
            // insert the new reservation
            eventName[counter]=tempname;    // insert event name
            eventDate[counter]=tempdate;    // insert event date
            startTime[counter]=tempstart;   // insert event start
            endTime[counter]=tempend;       // insert event end
            size++;
            c = myReader.nextToken();
        }
    }
    
    public static void printEvents(String[] eventName, String[] eventDate,
                    String[] startTime, String[] endTime)
    {
        String userdate;
        InputBox inbox = new InputBox();
        userdate=inbox.getString("Events for what date?");
        System.out.println("Events for " + userdate);
        System.out.println("-------------------");
        int counter=0;
        
        // while events in array are not yet later than searched-for date
        while (counter < size && eventDate[counter].compareTo(userdate)<=0)
        {
            if (eventDate[counter].equals(userdate))
            {
                System.out.println(eventName[counter]);
                System.out.println("Starting at " + startTime[counter]);
                System.out.println("Until " + endTime[counter]);
                System.out.println();
            }
            counter++;
        }
    }
}
