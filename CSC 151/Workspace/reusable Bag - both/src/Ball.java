import java.awt.Color;
/** models a real-world ball
 * 
 * @author Chris Fernandes
 * @version 4/9/12
 */
public class Ball implements Containable{

	final Color DEFAULT_COLOR = Color.yellow;
	final double DEFAULT_RADIUS = 4.0;
	final double MAX_RADIUS = 10.0;
	
	//properties = instance variables
	private double radius;
	//private String color;
	private Color color;
	
	/**
	 * default constructor
	 */
	public Ball() {
		radius=DEFAULT_RADIUS;
		color=DEFAULT_COLOR;
	}
	
	/**
	 * non-default constructor
	 * @param someRadius initial radius in cm (<=10)
	 * @param someColor  initial color
	 */
	public Ball(double someRadius, String someColor) {
		if (checkRadius(someRadius)){
			radius = someRadius;
		}
		else {
			System.out.println("illegal radius");
			System.out.println("defaulting to "+DEFAULT_RADIUS);
			radius = DEFAULT_RADIUS;
		}
		color = convertColor(someColor);
	}
	
	
	/**
	 * another non-default constructor; only radius can be specified
	 * @param someRadius initial radius in cm (<=10)
	 */
	public Ball(double someRadius) {
		if (checkRadius(someRadius)){
			radius = someRadius;
		}
		else {
			System.out.println("illegal radius");
			System.out.println("defaulting to "+DEFAULT_RADIUS);
			radius = DEFAULT_RADIUS;
		}
		color=DEFAULT_COLOR;
	}
	
	/**
	 * 
	 * @return true if radius is valid (<=10)
	 */
	private boolean checkRadius(double radius){
		return radius<=MAX_RADIUS;
	}
	
	/** convert String to Color object
	 * 
	 * @param color color as string like "yellow"
	 * @return color as Color object like Color.yellow
	 */
	private Color convertColor(String color) {
		if (color.equals("yellow")){
			return Color.yellow;
		}
		else if (color.equals("orange")){
			return Color.orange;
		}
		else if (color.equals("red")){
			return Color.red;
		}
		else
			return null;
	}
	//behavior = instance methods

	/**
	 * bounces ball from given height
	 * @param height height in meters
	 */
	public void bounce(double height){
		// code to bounce
		System.out.println("Look ma, I'm bouncing");
	}
	
	/** returns sport that most likely uses this ball
	 * 
	 * @return name of sport
	 */
	public String identify_sport(){
		if (this.getColor().equals("orange")){
			return "basketball";
		}
		else if (getColor().equals("yellow")){
			return "tennis";
		}
		else if (getColor().equals("white")){
			return "volleyball";
		}
		else{
			return "no sport identified";
		}
	}
	
	/** setter method
	 * 
	 * @param newColor new color for ball (if legal)
	 */
	public void setColor(String newColor){
		if (newColor.equals("yellow") ||
				newColor.equals("orange")||
				newColor.equals("red")) {
			color = convertColor(newColor);
		}
		else {
			System.out.println(newColor +
					" is not a color. Blow off.");
		}
	}
	
	/**
	 * getter: return value of color
	 * @return color as string
	 */
	public String getColor(){
		if (color.equals(Color.WHITE)){
			return "white";
		}
		else if (color.equals(Color.YELLOW)){
			return "yellow";
		}
		else if (color.equals(Color.ORANGE)){
			return "orange";
		}
		else if (color.equals(Color.RED)){
			return "red";
		}
		else
			return null;
	}
	
	/**
	 * getter
	 * @return radius of ball in inches
	 */
	public double getRadius(){
		return radius;
	}
	
	/**
	 * returns stats of this ball as a string
	 */
	public String toString(){
		return "This " + getColor() + " ball has radius " + radius + " cm ";
	}
	
	/**
	 * this ball is equal to otherBall if they have the same color and radius
	 * @param otherBall other ball to compare to
	 */
	public boolean equals(Object otherBall)
    {
    	// if the *pointers* are the same, then by golly it must be the same object!
    	if (this == otherBall)
    		return true;
    	
    	// if the parameter is null or the two objects are not instances of the same class,
    	// they can't be equal
    	else if (otherBall == null || this.getClass() != otherBall.getClass())
    		return false;
    	
        // At this point we must be comparing two Balls.  Two balls
        // are equal if they have the same color and radius
    	else {
    		double thisRadius = this.getRadius();
    		double otherRadius = ((Ball)otherBall).getRadius();
    		String thisColor = this.getColor();
    		String otherColor = ((Ball)otherBall).getColor();
    		if (thisRadius == otherRadius && thisColor.equals(otherColor)){
                return true;
    		}
            else {
            	return false;    	
            }
    	}
    			 

    }
}
