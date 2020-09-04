package proj5;

/**
 * StringContent is the "wrapper" that will let your bag hold strings
 * It's something that's comparable by a bag
 * Class Invariant : comparing two String content is the same as comparing two content (unboxing)
 * which justify for the compare method
 * 
 * @author Chris Fernandes 
 * @version 10/18/08
 */
public class StringContent implements Comparable
{
    private String content;

    /**
     * non default constructor to create a new content from a new string
     * @param newString
     */
    public StringContent(String newString)
    {
        content=newString;
    }

    /**
     * Check if this String content and other are equal.
     * @param other the other object to check
     * @return true if they are the same object or if the contents are equal.
     * If they are not the same class or the parameter is null or the contents are not equal, return false
     */
    public boolean equals(Object other)
    {
    	// if the *pointers* are the same, then by golly it must be the same object!
    	if (this == other)
    		return true;
    	
    	// if the parameter is null or the two objects are not instances of the same class,
    	// they can't be equal
    	else if (other == null || this.getClass() != other.getClass())
    		return false;
    	
        //Since this class is what the bag will use if it wants
        //to hold strings, we'll use the equals() method in the
        //String class to check for equality
    	else if ((this.content).equals(((StringContent)other).content))
            return true;
    	
        else return false;
    }

    /**
     * The printable version
     * @return the toString version, which is the content
     */
    //since this is already a string, just return it!
    public String toString()
    {
        return content;
    }

    /**
     * Comparing this StringContent with other
     * @param other the other StringContent to compare to
     * @return 1 if this String's value is greater than the other, -1 if less, 0 otherwise
     * Precondition: Object must be a StringContent
     */

    public int compareTo(Object other){
        return this.content.compareTo(((StringContent)other).content);
    }

    /**
     * Get the content
     * @return the content, which is a string
     */
    public String getContent(){
        return content;
    }
}
