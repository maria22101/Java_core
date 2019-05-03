package edx.module3_javabasics_project;

import java.util.Scanner;

public class Crypto {

    static String normalizeText(String s) {
        String result = s.replaceAll("[^\\w]", "").toUpperCase();
        return result;
    }

    public static String shiftAlphabet(int shift) { //this method was provided by the project team
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    static String caesarify(String s, int shift) {
        String helpAlphabet = shiftAlphabet(shift);
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < helpAlphabet.length(); j++) {

                if (shift > 0) {
                    if (j < helpAlphabet.length() - shift) {
                        if (s.charAt(i) == helpAlphabet.charAt(j)) {
                            result = result + helpAlphabet.charAt(j + shift);
                            break;
                        }
                    } else {
                        if (s.charAt(i) == helpAlphabet.charAt(j)) {
                            result = result + helpAlphabet.charAt(j - helpAlphabet.length() + shift);
                            break;
                        }
                    }

                } else {
                    if (j >= -shift) {
                        if (s.charAt(i) == helpAlphabet.charAt(j)) {
                            result = result + helpAlphabet.charAt(j + shift);
                            break;
                        }
                    } else {
                        if (s.charAt(i) == helpAlphabet.charAt(j)) {
                            result = result + helpAlphabet.charAt(j + shift + helpAlphabet.length());
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    static String groupify(String s, int chunk) {
        String result = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            result = result + s.charAt(i);
            count++;
            if (count < chunk && i != s.length()-1) {
                continue;
            }
            if (i == s.length()-1 && count < chunk) {
                for (int j = 0; j < chunk - count; j++) {
                    result = result + 'x';
                }
            }
            if (i != s.length()-1) {
                result = result + " ";
            }
            count = 0;
        }
        return result;
    }

    static String encryptString(String s, int shift, int chunk){
        String result = "";
        result = normalizeText(s);
        result = caesarify(result, shift);
        result = groupify(result, chunk);
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Hello, enter your input message here: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        System.out.print("Enter the shift step (an int number) here: ");
        int shift = scanner.nextInt();

        System.out.println("Enter an int number for letters in a group here: ");
        int chunk = scanner.nextInt();

        System.out.println(encryptString(inputString, shift, chunk));
    }
}
