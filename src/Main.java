/*
Title: Dart Game Program
Author: Draedn Groves
Date: Feb.13th/2024
Purpose: Create a Dart Game
 */

import java.util.Scanner;

// Class container for everything
public class Main {

    public static String P1NAME;
    public static String P2NAME;
    static final int MIN_NUM = 1, MAX_NUM = 100;
    public static int CURRENT_THROWER = 0;
    public static int p1CurrentScore = 501;
    public static int p2CurrentScore = 501;
    public static int p1GameWins = 0;
    public static int p2GameWins = 0;
    public static int CURRENT_ROUND = 1;
    public static int roundTotal = 0;
    public static String WINNER;


    // Main method - The basics of how the program will run
    // <editor-fold desc="MAIN">
    public static void main(String[] args) {
        startProgram();
        runProgram();
        endProgram();
    }
    // </editor-fold>

    // The first thing the program does once run.
    // <editor-fold desc="START">
    // <editor-fold desc="Start Method">

    public static void startProgram() {
        displayMenu();
        initializePlayers();
    }
    // </editor-fold>

    // The methods inside "Start Method" are shown here
    // <editor-fold desc="Start Method Stuff">
    // <editor-fold desc="Display Menu">
    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);

        // Set choice NOT EQUAL to a menu option
        int choice = 0;

        do { // Display menu options
            System.out.println("""
                    *********************************************
                    |              Darts Game Menu              |
                    *********************************************
                    Please select one of the following options:      
                    1) Play Game
                    2) Exit Program
                    -----------------------
                    Enter your choice below.""");

            // Error handling
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter either [1 or 2] please: ");
                sc.next();
            }

            // Set choice = the next int it finds.
            choice = sc.nextInt();

            // Do something based on selection
            switch (choice) {
                case 1: // Option to play
                    System.out.println("You chose option 1. Let's prep the dart match!");
                    initializePlayers();
                    break;
                case 2: // Exit option
                    System.out.println("Exiting the program.");
                    endProgram();
                    break;
                default: // Otherwise, tell them this.
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 2);

        sc.close();

    }
    // </editor-fold>

    // <editor-fold desc="Initialize Players">
    public static void initializePlayers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the first player:");
        P1NAME = sc.nextLine();

        System.out.println("Enter the name of the second player:");
        P2NAME = sc.nextLine();

        runProgram();
    }
    // </editor-fold>
    // </editor-fold>
    // </editor-fold>

    // The last thing the program does before closing.
    // <editor-fold desc="END">
    // <editor-fold desc="End Method">
    public static void endProgram() {
        displayMatchWinner();
        displayPlayerStats();

    }
    // </editor-fold>

    // <editor-fold desc="End Method Stuff">
    // Display The Winner's Name
    // <editor-fold desc="Winner">
    public static void displayMatchWinner() {
        if (p1GameWins == 3) {
            System.out.println(P1NAME + " WON THE BEST OF 5 DART MATCH!");
        }
        else if (p2GameWins == 3) {
            System.out.println(P2NAME + " WON THE BEST OF 5 DART MATCH!");
        }
    }
    // </editor-fold>

    // Display both players stats (game scores, 3 dart avg)
    // <editor-fold desc="Player Stats">
    public static void displayPlayerStats() {
        System.out.println("                || MATCH RESULTS || ");

                Game.sumAtEndOfEachMatch();
//                + P1NAME + "'s Match Stats: " + p1GameWins
//                + " 3 dart average for the match ");
//        System.out.println("");
//        System.out.println("                || MATCH RESULTS || "
//                + P2NAME + "'s Match Stats: " + p2GameWins
//                + " 3 dart average for the match ");
        Tools.pauseProgram();
    }
    // </editor-fold>
    // </editor-fold>
    // </editor-fold>

    // What is run after the program has been started.
    // <editor-fold desc="Run Method">
    public static void runProgram() {
        throwToDecideFirst();
        startDartMatch();
        startDartGame();
    }

    // <editor-fold desc="Throw to Decide First">
    public static void throwToDecideFirst() {
        System.out.println("Let's throw a dart! Closest to the bullseye starts the game");

        Tools.pauseProgram();

        boolean isDecided = false;

        while (!isDecided) {

            int p1DecidingThrow = Tools.genRandomInt(MIN_NUM, MAX_NUM);
            int p2DecidingThrow = Tools.genRandomInt(MIN_NUM, MAX_NUM);

            if (p1DecidingThrow > p2DecidingThrow) {
                System.out.println(P1NAME + " threw closer to the bullseye and wins!");
                System.out.println(P1NAME + " Starts the match!");
                CURRENT_THROWER = 1;
                isDecided = true;
            } else if (p2DecidingThrow > p1DecidingThrow) {
                System.out.println(P2NAME + " threw closer to the bullseye and wins!");
                System.out.println(P2NAME + " Starts the match!");
                CURRENT_THROWER = 2;
                isDecided = true;
            } else
                System.out.println("It's a tie, throw again");
        }
    }
    // </editor-fold>

    // <editor-fold desc="Start Dart Match">
    public static void startDartMatch() {
        System.out.println("Let's play a match of darts! Best of 5 wins! ");
        Tools.pauseProgram();
        startDartGame();
    }

    // </editor-fold>
    public static void startDartGame() {




        while (p1GameWins < 3 && p2GameWins < 3) {
            System.out.println("           Get Ready for GAME " + Game.gamesPlayed);
            System.out.println("ROUND: " + Main.CURRENT_ROUND);
            Tools.pauseProgram();
            Tools.checkRoundComplete();

            if (CURRENT_THROWER == 1) {

                if (p1CurrentScore <= 170) {

                    System.out.println(P1NAME + " Your score is: " + p1CurrentScore + ", Your dart outs are: " + Game.indexOutShootsOnPlayer1CurrentScore());
                    Tools.pauseProgram();
                    Game.throwFakeDart();
                    Tools.getTempScoreValid();



                    if (p1CurrentScore - Tools.tempScore > 1) {
                        p1CurrentScore = p1CurrentScore - Tools.tempScore;
                        Game.saveTheFakeDarts();
                        Tools.switchThrower();

                    }
                    else if (p1CurrentScore - Tools.tempScore == 0) { // add double throw requirement.
                        Tools.getTempDartsThrownValid();
                        System.out.println("You won! ");
                        Game.saveTheWinningFakeDarts();
                        WINNER = P1NAME;
                        p1GameWins ++;
                        System.out.println(P1NAME + " Current Game Wins: " + p1GameWins);
                        Tools.pauseProgram();
                        Tools.switchThrower();
                        Game.endCurrentGame();
                    }
                    else if (p1CurrentScore - Tools.tempScore < 0) {
                        System.out.println(" You overthrew! ");
                        Game.saveTheFakeDarts();
                        Tools.switchThrower();

                    }
                    else if (p1CurrentScore - Tools.tempScore == 1) {
                        System.out.println(" You can't throw a double with only 1 point. ");
                        Game.saveTheFakeDarts();
                        Tools.switchThrower();

                    }

                }
                else {
                    Game.throwDart();
                    p1CurrentScore = p1CurrentScore - Game.sumRound();
                    System.out.println(P1NAME + "'s score is now: " + p1CurrentScore);
                    Tools.switchThrower();
                }


            } else if (CURRENT_THROWER == 2) {

                if (p2CurrentScore <= 170) {

                    System.out.println(P2NAME + " Your score is: " + p2CurrentScore + ", Your dart outs are: " + Game.indexOutShootsOnPlayer2CurrentScore());
                    Tools.pauseProgram();
                    Game.throwFakeDart();
                    Tools.getTempScoreValid();



                    if (p2CurrentScore - Tools.tempScore > 1) {
                        p2CurrentScore = p2CurrentScore - Tools.tempScore;
                        Game.saveTheFakeDarts();
                        Tools.switchThrower();
                    }
                    else if (p2CurrentScore - Tools.tempScore == 0) {
                        Tools.getTempDartsThrownValid();
                        System.out.println("You won! ");
                        Game.saveTheWinningFakeDarts();
                        WINNER = P2NAME;
                        p2GameWins ++;
                        System.out.println(P2NAME + " Current Game Wins: " + p2GameWins);
                        Tools.pauseProgram();
                        Game.endCurrentGame();
                        Tools.switchThrower();

                    }
                    else if (p2CurrentScore - Tools.tempScore < 0) {
                        System.out.println(" You overthrew! ");
                        Game.saveTheFakeDarts();
                        Tools.switchThrower();
                    }
                    else if (p2CurrentScore - Tools.tempScore == 1) {
                        System.out.println(" You can't throw a double with only 1 point. ");
                        Game.saveTheFakeDarts();
                        Tools.switchThrower();
                    }
                }
                else {
                    Game.throwDart();
                    p2CurrentScore = p2CurrentScore - Game.sumRound();
                    System.out.println(P2NAME + "'s score is now: " + p2CurrentScore);
                    Tools.switchThrower();
                }

            }

        }endProgram();
    }
}// </editor-fold> // RUN PROGRAM







