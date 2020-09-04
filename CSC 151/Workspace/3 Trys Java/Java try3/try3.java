
/**
 * try3 -- array of structs version of scheduler
 * 
 * @author Chris Fernandes
 * @date 9/9/08
 */

import javabook.*;
    
public class try3
{
    final static int ORIG_SIZE = 15;   //better have enough room...
    static int size;                   //# of events in array
    
    public static void main(String[] args)  
    {
        Event[] reserve = new Event[ORIG_SIZE];  //array of events
        size=0;     //array of Events starts out empty

        insertRequests(reserve);
        printEvents(reserve);
    }
    
    public static void insertRequests(Event[] reserve)
    {
        String c;       // current token
        int counter;    // counter to place next Event in array
        FileReader myReader = new FileReader("requests.txt");
        c = myReader.nextToken();
        while (!c.equals("EOF"))
        {
        	// get new event info
            Event newEvent = new Event();
            newEvent.eventName=c;   
            newEvent.eventDate=myReader.nextToken();
            newEvent.startTime=myReader.nextToken();
            newEvent.endTime=myReader.nextToken();
            
            counter=0;

            // find correct place in array (sorted by date)
            while (counter<size && (reserve[counter].eventDate).compareTo(newEvent.eventDate)<0)
            {
                counter++;
            }
            
            // make room by moving one to the right
            for (int i=size; i>counter; i--)  
            {
                reserve[i]=reserve[i-1]; 
            }
            
            // place the event and increase the size
            reserve[counter]=newEvent;
            size++;                    
            c = myReader.nextToken();
        }
    }
    
    public static void printEvents(Event[] reserve)
    {
        String userdate;
        InputBox inbox = new InputBox();
        userdate=inbox.getString("Events for what date?");
        System.out.println("Events for " + userdate);
        System.out.println("-------------------");
        int counter=0;
        // while events in array are not yet later than searched-for date
        while (counter < size && (reserve[counter].eventDate).compareTo(userdate)<=0)
        {
            if ((reserve[counter].eventDate).equals(userdate))
            {
                System.out.println(reserve[counter].eventName);
                System.out.println("Starting at " + reserve[counter].startTime);
                System.out.println("Until " + reserve[counter].endTime);
                System.out.println();
            }
            counter++;
        }
    }
}
