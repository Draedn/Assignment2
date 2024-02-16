/*
Title: Dart Game Program
Author: Draedn Groves
Date: Feb.13th/2024
Purpose: Create a Dart Game
 */

import java.util.Scanner;

// Class container for everything
public class Main {

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

    public static void startProgram(){
        displayMenu();
        initializePlayers();
        throwToDecideFirst();
    }
    // </editor-fold>

    // The methods inside "Start Method" are shown here
    // <editor-fold desc="Start Method Stuff">
    // <editor-fold desc="Display Menu">
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);

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
            
            Enter your choice below.
            """);

            // Error handling
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter either [1 or 2] please: ");
                scanner.next();
            }

            // Set choice = the next int it finds.
            choice = scanner.nextInt();

            // Do something based on selection
            switch (choice) {
                case 1: // Option to play
                    System.out.println("You chose option 1. Let's prep the dart match!");
                    initializePlayers();
                    break;
                case 2: // Exit option
                    System.out.println("Exiting the program.");
                    break;
                default: // Otherwise, tell them this.
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 2);

        scanner.close();

    }
    // </editor-fold>

    // <editor-fold desc="Initialize Players">
    public static void initializePlayers(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the first player:");
        String playerOne = scanner.nextLine();

        System.out.println("Enter the name of the second player:");
        String playerTwo = scanner.nextLine();
    }
    // </editor-fold>

    // <editor-fold desc="Throw to Decide First">
    public static void throwToDecideFirst(){

    }
    // </editor-fold>
    // </editor-fold>
    // </editor-fold>

    // What is run after the program has been started.
    // <editor-fold desc="Run Method">
    public static void runProgram(){

    }
    // </editor-fold>

    // The last thing the program does before closing.
    // <editor-fold desc="END">
    // <editor-fold desc="End Method">
    public static void endProgram(){
        displayWinner();
        displayPlayerStats();
    }
    // </editor-fold>

    // <editor-fold desc="End Method Stuff">
    // Display The Winner's Name
    // <editor-fold desc="Winner">
    public static void displayWinner() {

    }
    // </editor-fold>

    // Display both players stats (game scores, 3 dart avg)
    // <editor-fold desc="Player Stats">
    public static void displayPlayerStats(){

    }
    // </editor-fold>
    // </editor-fold>
    // </editor-fold>
}