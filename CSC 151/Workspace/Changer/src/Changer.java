public class Changer {

    public void changeInt(int val){
        int new_val;
        new_val = val + 2;
    }

    public void changeString(String aString){
        //String new_string;
        aString = aString + "!";
    }

    public void changeArray(int[] anArray){
        anArray[0] = 999;
    }

    public void changeBall(Ball aBall){
        aBall.inflate(2.0);
    }
}
