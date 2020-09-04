/**
 * Tests two types of bags (that use the same GenericContainableBag class!)
 * 
 * @author Chris Fernandes
 * @version 5/3/12
 */
public class Client
{
    public static void main(String[] args)
    {
        // make 2 bags: one for strings, one for ints
         GenericContainableBag<StringContent> stringBag = new GenericContainableBag<StringContent>(3);
         GenericContainableBag<IntegerContent> intBag = new GenericContainableBag<IntegerContent>(3);
    
        // make a StringContent object to hold a string...
        StringContent string1;
        string1 = new StringContent("hello");

        //... and an IntegerContent object to hold an int
        IntegerContent integer1;
        integer1 = new IntegerContent(4);

        // now the good part.  The SAME CODE in GenericContainableBag can handle both
        // the IntegerContent object and the StringContent object
        stringBag.add(string1);
        intBag.add(integer1);
        System.out.println("The stringBag holds: " + stringBag);
        System.out.println("The intBag holds: " + intBag);
        
        GenericContainableBag<Ball> b = new GenericContainableBag<Ball>(5);
    	Ball ball1 = new Ball();
    	Ball ball2 = new Ball(5,"orange");
    	Ball ball3 = new Ball();
    	
    	// testing equals:
    	System.out.println("two default Balls equal? " + ball1.equals(ball3));
    	System.out.println("two different Balls equal? " + ball2.equals(ball3));
    	System.out.println();
    	
    	// put them in a bag!
    	b.add(ball1);
    	b.add(ball2);
    	b.add(ball3);
    	System.out.println("The ball bag holds: " + b.toString());
        
        // and you DO get a compiler error if you try to mix types. WIN.
//        stringBag.add(integer1);
        //System.out.println("The stringBag holds: " + stringBag);
        
        // and you DO get a compiler error if you do not want a bag of doubles. WIN.
//        GenericContainableBag<Double> doubleBag= new GenericContainableBag<Double>(3);
        //doubleBag.add(3.3);
        
    }
}
