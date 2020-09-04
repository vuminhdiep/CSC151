public class Client {

    public static void main(String[] args) {

        // Create an instance of a ball
        Ball ball1;
        ball1 = new Ball();

        Ball ball2 = new Ball();

        System.out.println("Printing ball information");
        System.out.println(ball1);
        System.out.println(ball2);

        //ball2.radius = 1000000.0;


        Ball ball3 = new Ball("Basketball","orange");
        System.out.println(ball3);

        System.out.println(ball3.getRadius());
        System.out.println(ball3.getSport());

        //ERROR: no public method setRadius
        //ball3.setRadius(100.0);

        ball3.inflate(2.0);
        System.out.println(ball3);

        //ERROR: no constructor for just a single string
        //Ball ball4 = new Ball("Baseball");

    }
}
