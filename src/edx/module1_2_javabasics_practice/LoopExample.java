package edx.module1_2_javabasics_practice;

import java.util.Scanner;

public class LoopExample {

    static void longestName(Scanner console, int numOfEntries) {
        int stringLength_new = 0;
        int stringLength_max = 0;
        String string_max = null;
        int i = 1;
        while (i <= numOfEntries) {
            System.out.print("name #" + i + "? ");
            String input = console.nextLine();
            stringLength_new = input.length();
            if (stringLength_new > stringLength_max) {
                string_max = input;
                stringLength_max = stringLength_new;
            }
            i++;
        }
        String string_max_formated = string_max.substring(0,1).toUpperCase() + string_max.substring(1).toLowerCase();
        System.out.println(string_max_formated + "'s name is the longest");
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        longestName(console, 3);
    }
}
