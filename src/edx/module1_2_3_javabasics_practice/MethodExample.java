package edx.module1_2_3_javabasics_practice;

public class MethodExample {

    static void printString(String a, int repetition) {
        for (int i = 1; i <= repetition; i++) {
            System.out.print(a);
        }
    }

    public static void main(String[] args) {
        printString("Beautiful ", 4);
    }
}
