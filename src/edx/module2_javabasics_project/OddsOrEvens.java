package edx.module2_javabasics_project;

import java.util.*;

public class OddsOrEvens {
    public static void main(String[] args) {

        //Part 1: Pick Odds or Evens
        System.out.println("Let’s play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.print("Hi, " + userName + "! Which do you choose? (O)dds or (E)vens? ");
        String userChoice = scanner.next();
        if (userChoice.equals("O")) {
            System.out.println(userName + " has picked odds! The computer will be evens.");
        }else{
            System.out.println(userName + " has picked evens! The computer will be odds.");
        }
        System.out.println("--------------------------------------------------------------");

        //Part 2: Playing the game
        System.out.print("How many “fingers” do you put out? ");
        int userNumber = scanner.nextInt();
        Random rand = new Random();
        int computerNumber = rand.nextInt(10);
        System.out.println("The computer plays " + computerNumber + " \"fingers\"!");
        System.out.println("--------------------------------------------------------------");
        int sum = userNumber + computerNumber;
        System.out.println(userNumber + " + " + computerNumber + " = " + sum);

        //Part 3: Who won?
        if (sum % 2 == 0) {
            System.out.println(sum + " is even!");
            if (userChoice.equals("E")){
                System.out.println("That means " + userName + " wins!");
            }else{
                System.out.println("That means computer wins!");
            }
        }else{
            System.out.println(sum + " is odd!");
            if (userChoice.equals("O")){
                System.out.println("That means " + userName + " wins!");
            }else{
                System.out.println("That means computer wins!");
            }
        }
        System.out.println("--------------------------------------------------------------");
    }
}
