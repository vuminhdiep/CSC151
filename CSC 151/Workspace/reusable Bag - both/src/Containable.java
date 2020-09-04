
/**
 * Defines a generic object that a bag can hold.  This will
 * remove the limitation that the bag can only hold Strings.
 * 
 * @author Chris Fernandes
 * @version 4/29/12
 */

public interface Containable
{
    // need a way to define equality between Containables
    // for things like finding a Containable in a Bag
	// Note that this overrides the equals method in the Object class
    public boolean equals(Object otherContainable);

    // converts a Containable object to a printable string
    public String toString();
}
