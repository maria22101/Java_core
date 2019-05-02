package edx.module1_2_3_javabasics_practice;

public class RecursionExample_1 {

    private static String starString(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }else if (n == 0) {
            return "*";
        }else if (n == 1) {
            return "**";
        }else {
            return starString(n - 1) + starString(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(starString(3));
    }

}
