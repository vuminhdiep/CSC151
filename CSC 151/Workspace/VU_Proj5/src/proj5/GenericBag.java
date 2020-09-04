package proj5;

/**
 * This Bag class uses both generics and interfaces!
 * Reason: you get to leave types unspecified AND get control
 * over what is baggable and what is not.
 * change to Comparable Bag to holder comparable wrapper
 * 
 * @author Chris Fernandes
 * @version 5/3/12
 * @updated version 6/4/2020
 *
 ********************************************************************/
public class GenericBag<T extends Comparable> {

	private int size;           //# of elements in bag
    private Comparable[] contents;
    private final int INITIAL_CAPACITY = 10;

    /**
     * non default constructor of a generic bag. If the capacity is negative, set the capacity = INITIAL_CAPACITY = 10
     * @param capacity
     */
    public GenericBag(int capacity)
    {
        if(capacity < 0){
            capacity = INITIAL_CAPACITY;
        }
        contents = new Comparable[capacity];
        size=0;
    }

    /**
     * default constructor of a generic bag with default capacity = 10
     */
    public GenericBag(){
        contents = new Comparable[INITIAL_CAPACITY];
        size = 0;
    }
    
    /**
     * add item to bag
     * @param value the item to add
     */
    public void add(T value)
    {
        if(size() == capacity())
                this.growDouble();
            
        contents[size]=value;
        size++;
    }

    /**
     * remove item from bag
     * @param value the item to remove
     */
    public void remove(T value)
    {

        int found_position = find(value);
        if (found_position>-1)
        {
            // move last element to fill the hole
            contents[found_position]=contents[size-1];
            size--;
        }
    }   

    /**
     * does bag contain item?
     * @param value item to search for
     * @return true if bag contains item, else false
     */
    public boolean contains(T value)
    {     
        if (find(value) == -1)
            return false;
        else
            return true;
    }   
    
    /**
     * is bag Empty?
     * @return true if bag empty, else false
     */
    public boolean isEmpty()
    {
        if (size()==0)
            return true;
        else return false;
    }
    
    /**
     * empty bag of contents
     */
    public void clear()
    {
        size=0;
    }

    /**
     * 
     * @return number of items in bag
     */
    public int size()
    {
        return size;
    }

    /**
     * return bag contents as printable string
     */
    public String toString()
    {
    	String answer = "{";
    	int currentSize=this.size();
        for(int i=0; i < (currentSize - 1); i++)  // take care of all but last one
        {
            answer = answer + contents[i] + ", ";
        }      
        if (currentSize>0)  // as long as not empty
        	answer = answer + contents[(currentSize - 1)];
        answer+= "}";
        return answer;
    }
    
    /**
     * Getter for bag capacity
     * @return how many items bag can hold
     */
    public int capacity()
    {
    	return contents.length;
    }
    
    /**
     * remove a random element from the bag
     * @return the random element removed
     */
    public T removeRandom()
    {
    	T toReturn = grabRandom();
    	remove(toReturn);
    	return toReturn;
    }
    
    /**
     * grab a random element from the bag
     * @return the element grabbed
     */
    @SuppressWarnings("unchecked")
    public T grabRandom()
    {
    	int rand = (int)(Math.random()*this.size());
    	T toReturn = (T)contents[rand];
    	return toReturn;
    }
    
    /**
     * 
     * @param otherBag another bag of the same type of item
     * @return true if this bag has same elements as otherBag.
     * Order doesn't matter.
     */
    public boolean equals(GenericBag<T> otherBag)
    {
    	if (this.size()!=otherBag.size())
    		return false;
    	else {
    		GenericBag<T> thisCopy = this.clone();
    		GenericBag<T> otherCopy = otherBag.clone();
    		while (!thisCopy.isEmpty()) {
    			T someElement = (T) thisCopy.removeRandom();
    			if (!otherCopy.contains(someElement))
    				return false;
    			else
    				otherCopy.remove(someElement);
    		}
    		return true;
    	}
    }
    
    /**
     * @return exact copy of this bag.  Changes to copy
     * do not affect the original, and vice versa.
     */
    public GenericBag<T> clone()
    {
    	GenericBag<T> newBag = new GenericBag<T>(this.capacity());
    	// since you can't make new E instances directly,
    	// I'll let you use the array's clone method here.
    	newBag.contents = this.contents.clone();
    	newBag.size = this.size();
    	return newBag;
    }
    
    /**
     * makes bag capacity equal to number of items in bag
     */
    public void trimToSize()
    {
    	int currentSize = this.size();
    	Comparable[] newContents = new Comparable[currentSize];
    	for (int i=0; i<currentSize; i++) {
    		newContents[i]=this.get(i);
    	}
    	contents=newContents;
    }
    
    /** make new bag contain all elements from this
     *  bag and otherBag.  Return the new bag. this Bag
     *  and otherBag are not altered in the process.
     * @param otherBag the other bag
     * @return the union of this bag and otherBag
     */
    public GenericBag<T> union(GenericBag<T> otherBag)
    {
    	GenericBag<T> newBag = this.clone();
    	GenericBag<T> temp = otherBag.clone();
    	while (!temp.isEmpty()) {
    		newBag.add(temp.removeRandom());
    	}
    	return newBag;
    }

    /**
     * return array index where item can be found. Return -1 if not found.
     * @param value the item to search for
     * @return -1 if not found.  Else, the array index where first one found.
     */
    private int find(T value)
    {
    	int currentSize=this.size();
        for (int i=0; i<currentSize; i++)
        {
            if (this.contents[i].equals(value))
                return i;
        }
        return -1;
    }

    /**
     * double the size of the internal array
     */
    private void growDouble()
    {       
        Comparable[] newArray;
        newArray = new Comparable[(contents.length) * 2];
        int oldSize = this.size();
        for(int i=0; i < oldSize; i++)
        {  
            newArray[i] = contents[i];          
        }
        this.contents = newArray;
    }
    
    /**
     * get the element at index i
     * @param i index of internal array where sought item is stored
     * @return the sought item
     */
    @SuppressWarnings("unchecked")
    private T get(int i)
    {
    	return (T)contents[i];
    }
}
