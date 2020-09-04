package hwk3;
import java.awt.Color;

/**
 * Simulates a ball used in sporting events like volleyball, basketball, etc.
 * 
 * @author Chris Fernandes and Emma Vu
 * @version 1/9/2018
 * updated version 5/16/2020
 */
public class Ball implements Comparable<Ball>{
	
	// named constants
	private final Color DEFAULT_COLOR = Color.yellow;
	private final double DEFAULT_DIAMETER = 10;
	private final String DEFAULT_MATERIAL = "rubber";
	private final double DEFAULT_ELASTICITY = 4.5;
	private final double MAX_DIAMETER = 1000;
	
	// instance vars
	// All instance variables have a scope of
	// the entire class
	
	//private String color;
	private Color color;
	private double diameter;  // in cm
	private String material;
	private double elasticity;  // in squishiness units
	
	// constructor methods



	
	/**
	 *  default constructor
	 */
	public Ball() {
		color = DEFAULT_COLOR;
		diameter = DEFAULT_DIAMETER;
		material = DEFAULT_MATERIAL;
		elasticity = DEFAULT_ELASTICITY;
	}

	/**
	 * non-default constructor
	 * @param new_color color of new ball
	 * @param new_diam  diameter of new ball in cm
	 */
	public Ball(String new_color, double new_diam) {
		color = convertColor(new_color);
		diameter = new_diam;
		material = DEFAULT_MATERIAL;
		elasticity = DEFAULT_ELASTICITY;
	}
	
	/**
	 * converts string color like "yellow" to Color object like Color.yellow
	 * @param someColor string version of color
	 * @return color as a Color object
	 */
	private Color convertColor(String someColor) {
		if (someColor.equals("yellow")) {
			return Color.yellow;
		}
		else if (someColor.equals("orange")) {
			return Color.orange;
		}
		else if (someColor.equals("red")) {
			return Color.red;
		}
		else {
			return Color.black;
		}
	}
	

	
	// instance methods
	
	/**
	 * inflates ball by given amount of air
	 * @param amt_of_air in lbs PSI
	 */
	public void inflate(double amt_of_air) {
		if (amt_of_air < MAX_DIAMETER) {
			double newDiam = amt_of_air * 1.2;
			setDiameter(newDiam);
		}
	}
	
	/** 
	 * @return color of Ball
	 */
	public String getColor() {
		return color2String(color);
	}
	
	/**
	 * takes color object like Color.yellow and 
	 * returns string version like "yellow"
	 * @param c Color object constant
	 * @return String version of that color
	 */
	private String color2String(Color c) {
		if (c.equals(Color.yellow)) {
			return "yellow";
		}
		else if (c.equals(Color.orange)) {
			return "orange";
		}
		else if (c.equals(Color.red)) {
			return "red";
		}
		else {
			return "black";
		}
	}
	
	/**
	 * getter for material
	 * @return material ball is made from
	 */
	public String getMaterial() {
		return material;
	}
	
	/**
	 * getter for diameter
	 * @return diameter of ball in cm
	 */
	public double getDiameter() {
		return diameter;
	}
	
	/**
	 * sets diameter to new_diam if positive
	 * Does nothing if new_diam <= 0
	 * @param new_diam
	 */
	private void setDiameter(double new_diam) {
		if (new_diam > 0) {
			diameter = new_diam;
		}
	}
	
	/**
	 * Sport this ball is used in
	 * @return returns the sport this Ball is associated with
	 */
	public String getSport() {
		if (getColor().equals("yellow")) {
			return "tennis";
		}
		else if (getColor().equals("orange")) {
			return "basketball";
		}
		else if (getColor().equals("red")) {
			return "dodge ball";
		}
		else {
			return "no such sport";
		}
	}
	
	/**
	 * bounces the ball given initial force
	 * @param force in Newtons
	 * @return distance ball traveled after bouncing off surface (in cm)
	 */
	public double bounce(double force) {
		return 0;
	}
	
	/**
	 * @return ball as a printable string
	 */
	public String toString() {
		String toReturn = getColor() + " " + getMaterial() + " ball";
		toReturn+=" with " + getDiameter() + "cm diameter";
		return toReturn;
	}

	public int compareTo(Ball other){

		if(this.getDiameter() == other.getDiameter()){
			return 0;
		}
		else if(this.getDiameter() > other.getDiameter()){
			return 1;
		}
		else{
			return -1;
		}
	}
}
