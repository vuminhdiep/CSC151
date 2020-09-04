
/**
 * IntegerContent is the "wrapper" that will let your bag hold ints
 * It's something that's containable by a bag
 * 
 * @author Chris Fernandes 
 * @version 10/18/08
 */
public class IntegerContent implements Containable
{
    private int content;

    public IntegerContent(int new_int)
    {
        content=new_int;
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
        //to hold ints, we can use == since int is a primitive
    	else if (this.content==((IntegerContent)otherContainable).content)
            return true;
    	
        else return false;
    }

    //an int is not already a string, but the String class has got
    //a method (valueOf) that will convert it for us
    public String toString()
    {
        return String.valueOf(content);
    }
}
