package framework.utils;

public class Random {

    public static int getRandomNumber(int since, int to){
        return (int) (Math.random() * (to)) + since;
    }
}