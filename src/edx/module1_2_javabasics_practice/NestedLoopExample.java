package edx.module1_2_javabasics_practice;

public class NestedLoopExample {
    public static void main(String[] args) {

        System.out.println("1st nested loop example:");
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("2nd nested loop example:");

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <=9; j++) {
                for (int k = 1; k <= 3; k++) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("3rd loop example:");

        int x = 100;
        int count = 0;
        while (x > 0) {
            x = x / 2;
            count++;
        }
        System.out.println(count);

        System.out.println();
        System.out.println("4th nested loop example:");

        int i = 1;
        int j = 1;
        int k = 1;
        while (i <= 2) {
            while (j <= 3) {
                while (k <= 4) {
                    System.out.print("*");
                    k++;
                }
                k = 1;
                System.out.print("!");
                j++;
            }
            System.out.println();
            j = 1;
            i++;
        }
    }
}
