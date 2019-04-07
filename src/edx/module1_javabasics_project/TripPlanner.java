package edx.module1_javabasics_project;

import java.util.Scanner;

public class TripPlanner {

    public static void greet(){
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name?\t");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Nice to meet you " + name + ", " + "where are you travelling to?\t");
        String city = scanner.nextLine();
        System.out.println("Great! " + city + " sounds like a great trip");
        System.out.println("**********");
    }

    public static void timing_and_budgeting() {
        System.out.print("How many days are you going to spend travelling?\t");
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip?\t");
        int sum = scanner.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination?\t");
        String curr_sign = scanner.next();
        System.out.print("How many " + curr_sign + " are there in one USD?\t");
        double ex_rate = scanner.nextDouble();
        System.out.println();
        System.out.println("If you are travelling for " + days + " days" + " that is the same as " + days*24 +
                " hours " + "or " + days*24*60 + " minutes");
        System.out.println("If you are going to spend " + "$" + sum + " USD" +
                " that means per day you can spend up to " + "$" + (double)sum/days + " USD");
        System.out.println("Your total budget in " + curr_sign + " is " + sum*ex_rate + " " + curr_sign +
                ", which per day is " + sum*ex_rate/days + " " + curr_sign);
        System.out.println("**********");

    }

    public static void main(String[] args) {
//        greet();
        timing_and_budgeting();
    }
}
