package edx.javabasics_final_project_Mazerunner;

import java.util.Scanner;

public class MazeRunner {

    static void intro(Maze maze) {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        maze.printMap();
        System.out.println("-----------------------------------------------------");
    }

    static String userMove() {
        System.out.println("Where would you like to move?");
        System.out.println("Enter \"R\"- for right, \"L\"- for left, \"U\"- for up, \"D\"- for down: ");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();

        while (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {
            System.out.print("Only R, L, U, D signs allowed. Please, enter: ");
            direction = scanner.nextLine();
        }
        return direction;
    }

    static boolean isMovePermitted(Maze maze, String userMove) {
        boolean isPathFree = false;
        switch (userMove) {
            case "R":
                isPathFree = maze.canIMoveRight();
                break;
            case "L":
                isPathFree = maze.canIMoveLeft();
                break;
            case "U":
                isPathFree = maze.canIMoveUp();
                break;
            case "D":
                isPathFree = maze.canIMoveDown();
        }
        return isPathFree;
    }

    static void successfulMove(Maze maze, String usermove) {
        switch (usermove) {
            case "R":
                maze.moveRight();
                break;
            case "L":
                maze.moveLeft();
                break;
            case "U":
                maze.moveUp();
                break;
            case "D":
                maze.moveDown();
        }
        maze.printMap();
    }

    static boolean isPit(Maze maze, String usermove) {
        boolean isPitHere = false;
        switch (usermove) {
            case "R":
                isPitHere = maze.isThereAPit("R");
                break;
            case "L":
                isPitHere = maze.isThereAPit("L");
                break;
            case "U":
                isPitHere = maze.isThereAPit("U");
                break;
            case "D":
                isPitHere = maze.isThereAPit("D");
        }
        return isPitHere;
    }

    static int navigatePit(Maze maze, String usermove, int stepsCount) {
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        if (userAnswer.charAt(0) == 'y' || userAnswer.charAt(0) == 'Y') {
            maze.jumpOverPit(usermove);
            maze.printMap();
            printMovesMessage(stepsCount);
            return stepsCount;
        } else {
            System.out.println("You do not want to jump over the pit?");
            String userMoveInsteadOfPitJump = userMove();
            stepsCount++;
            userProgress(maze, userMoveInsteadOfPitJump, stepsCount);
            return stepsCount;
        }
    }

    static int userProgress(Maze maze, String userMove, int stepsCount) {
        String userMoveUpdate;

        while (!isMovePermitted(maze, userMove)) {
            if (isMaxStepsExceeded(stepsCount)) {
                return stepsCount;
            } else {
                printMovesMessage(stepsCount);
            }

            System.out.println("Attention: there is wall in that direction! Choose another direction!");
            userMoveUpdate = userMove();
            stepsCount++;

            if (userMove.equals(userMoveUpdate)) {
                System.out.println("Sorry, you've hit the wall!");
                continue;
            }
            userMove = userMoveUpdate;
        }

        if (isMaxStepsExceeded(stepsCount)) {
            return stepsCount;
        } else {
            successfulMove(maze, userMove);
            printMovesMessage(stepsCount);
            return stepsCount;
        }
    }

    static void printMovesMessage(int movesNum) {
        switch (movesNum) {
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 MOVES REMAINIG before the maze exit closes");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 MOVES lEFT to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 MOVES LEFT to escape!!");
                break;
            case 100:
                System.out.println("OH NO! You took too long to escape, and now the maze exit is CLOSED :(");
                break;
        }
    }

    static boolean isMaxStepsExceeded(int stepsCount) {
        if (stepsCount < 100) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Maze myMap = new Maze();
        intro(myMap);
        String move = "";
        int steps = 0;

        while (!(myMap.didIWin()) && !(isMaxStepsExceeded(steps))) {
            move = userMove();
            steps++;
            if (isPit(myMap, move)) {
                steps = navigatePit(myMap, move, steps);
            } else {
                steps = userProgress(myMap, move, steps);
            }
        }

        if (isMaxStepsExceeded(steps)) {
            System.out.println("Sorry, but you didn't escape in time- you lose!");
        } else {
            System.out.println("Congratulations! You made it out alive! and you did it in " + steps + " moves.");
        }
    }

}
