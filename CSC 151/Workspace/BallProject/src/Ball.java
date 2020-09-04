import java.awt.Color;

/**
 * The ball class
 * @author nick
 * @version 0.2
 */
public class Ball {

    // CONSTANTS
    private final String DEFAULT_SPORT = "Football";
    private final Color DEFAULT_COLOR = Color.white;
    private final double DEFAULT_RADIUS = 10.0;
    private final double DEFAULT_BOUNCINESS = 2.0;

    // instance variables
    private double radius;
    private double bounciness;
    private String sport;
    private Color color;

    /**
     * Default constructor
     */
    public Ball() {
        radius = DEFAULT_RADIUS;
        bounciness = DEFAULT_BOUNCINESS;
        sport = DEFAULT_SPORT;
        color = DEFAULT_COLOR;
    }

    /**
     * Non-default constructor
     * @param newSport the sport for the ball
     * @param newColor the color of the ball
     */
    public Ball(String newSport, String newColor) {
        radius = DEFAULT_RADIUS;
        bounciness = DEFAULT_BOUNCINESS;
        setSport(newSport);
        color = selectColor(newColor);
    }

    /**
     *
     * @return the string representing the sport
     */
    public String getSport() {
        return sport;
    }

    /**
     *
     * @param newSport the String newSport
     */
    private void setSport(String newSport){
        sport = newSport;
    }

    /**
     * Private helper method, to convert from string to Color object
     * @param newColor String version of color
     * @return color as a Color object
     */
    private Color selectColor(String newColor){
        if (newColor.equals("orange")) {
            return Color.orange;
        }
        else {
            return Color.white;
        }
    }

    /**
     *
     * @return radius of ball
     */
    public double getRadius() {
        return radius;
    }

    /**
     * BAD - returns an object publicly
     * We should write a public facing method that
     * returns a String.
     * @return Color object
     */
    //public Color getColor(){
    //    return color;
    //}

    /**
     *
     * @return String representation of color object
     */
    public String getColor(){
        if(color.equals(Color.orange)){
            return "orange";
        }
        else {
            return "white";
        }
    }

    /**
     * Inflates a ball
     * @param amount to inflate the ball by
     */
    public void inflate(double amount) {
        double newRadius;
        newRadius = getRadius() + amount;
        setRadius(newRadius);
    }

    /**
     * Don't just let people setRadius
     * Use public method inflate
     * Which uses this private method to increase radius
     * @param newRadius
     */
    private void setRadius(double newRadius){
        radius = newRadius;
    }

    /**
     *
     * @return the string representation of the ball
     */
    public String toString(){
        String toReturn = "This is a " + getColor() + " ball used for " + getSport();
        toReturn += " that is " + getRadius() + " inches radius";
        return toReturn;
    }
}

