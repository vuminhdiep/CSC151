public class ChangeClient {

    public static void main(String[] args){

        Changer change = new Changer();

        int a = 5;
        String b = "nick";

        int[] c = new int[4];
        c[0] = 27;
        c[2] = 33;

        Ball d = new Ball();


        System.out.println("BEFORE CHANGE");
        System.out.println("Int a: " + a);
        System.out.println("String b: " + b);
        System.out.println("Array c: ");
        for(int i = 0; i<4; i++) {
            System.out.println(c[i]);
        }
        System.out.println(d);

        change.changeInt(a);
        change.changeString(b);
        change.changeArray(c);
        change.changeBall(d);

        System.out.println("AFTER CHANGE");
        System.out.println("Int a: " + a);
        System.out.println("String b: " + b);
        System.out.println("Array c: ");
        for(int i = 0; i<4; i++) {
            System.out.println(c[i]);
        }
        System.out.println(d);

    }
}
