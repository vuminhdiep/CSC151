
/**
 * StringContent is the "wrapper" that will let your bag hold strings
 * It's something that's containable by a bag
 * 
 * @author Chris Fernandes 
 * @version 10/18/08
 */
public class StringContent implements Containable
{
    private String content;

    public StringContent(String newString)
    {
        content=newString;
    }

    public boolean equals(Object otherContainable)
    {
    	// if the *pointers* are the same, then by golly it must be the same object!
    	if (this == otherContainable)
    		return true;
    	
    	// if the parameter is null or the two objects are not instances of the same class,
    	// they can't be equal
    	else if (otherContainable == null || this.getClass() != otherContainable.getClass())
    		return false;
    	
        //Since this class is what the bag will use if it wants
        //to hold strings, we'll use the equals() method in the
        //String class to check for equality
    	else if ((this.content).equals(((StringContent)otherContainable).content))
            return true;
    	
        else return false;
    }

    //since this is already a string, just return it!
    public String toString()
    {
        return content;
    }
}
