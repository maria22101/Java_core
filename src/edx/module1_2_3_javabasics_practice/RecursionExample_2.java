package edx.module1_2_3_javabasics_practice;

public class RecursionExample_2 {

    static String repeat(String s, int n) { //method should return n copies of string s
        if (n < 0) {
            throw new IllegalArgumentException();
        }else if (n == 0) {
            return "";
        }else if (n == 1) {
            return s;
        }else{
            StringBuilder builder = new StringBuilder(s).append(repeat(s, n - 1));
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(repeat("Rose ", 5));
    }
}
