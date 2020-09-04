

/**
 * An Event is a gathering that happens on a particular date.  
 * It has a defined name, starting time, and ending time.
 * 
 * @author Chris Fernandes
 * @version 5/14/12
 */
public class Event implements Comparable<Event>
{
    private String name;
    private int year;
    private int month;      //1=Jan, 12=Dec
    private int day;
    private int startTime;  //military time
    private int endTime;    //military time

    //constructor
    public Event(String event, int year, int month, int day, int start, int end)
    {
        this.name=event;
        this.year=year;
        this.month=month;
        this.day=day;
        startTime=start;
        endTime=end;
    }

    //returns the event as a printable String
    public String toString()
    {
        return name + "  " + month + "/" + day + "/" + year + "  " + startTime + "-" + endTime;
    }
    
    // returns 1 if this event later than otherEvent
    // returns -1 if this event earlier than otherEvent
    // returns 0 if events occur on the same day at exactly the same START time
    public int compareTo(Event otherEvent)
    {
        if (this.year > otherEvent.year)
            return 1;
        else if (this.year < otherEvent.year)
            return -1;
        else // same year; check months
            if (this.month > otherEvent.month)
                return 1;
            else if (this.month < otherEvent.month)
                return -1;
            else // same year and same month; check day
                if (this.day > otherEvent.day)
                    return 1;
                else if (this.day < otherEvent.day)
                    return -1;
                else  // same day; check start time
                    if (this.startTime > otherEvent.startTime)
                        return 1;
                    else if (this.startTime < otherEvent.startTime)
                        return -1;
                    else return 0;
    }
}
