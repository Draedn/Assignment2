/*
Title: Tools
Author: Draedn Groves
Date: Feb.13th/2024
Purpose: Tools
 */


import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


// Container for Tools to be used.
// Tools should be GENERIC enough to be used in other programs.
public class Tools {

    public static boolean p1Thrown = false;
    public static boolean p2Thrown = false;
    public static int tempScore;

    public static int tempDartsThrown;

    static Scanner scan = new Scanner(System.in);

    // <editor-fold desc="Pause Program">
    public static void pauseProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Waits for user to hit Enter
    }
    // </editor-fold>

    // <editor-fold desc="Get String From Console">
    public static String getStringFromConsole(String inputPrompt) {
        System.out.print(inputPrompt + " > ");
        return scan.nextLine();
    }
    // </editor-fold>

    public static int genRandomInt(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    }

    public static void switchThrower() {
        //
        if (Main.CURRENT_THROWER == 2) {
            p2Thrown = true;
            Main.CURRENT_THROWER = 1;
            //Game.printPlayer2DartsAndValues();
        }
        else if (Main.CURRENT_THROWER == 1) {
            p1Thrown = true;
            Main.CURRENT_THROWER = 2;
           //Game.printPlayer1DartsAndValues();
        }

    }

    public static boolean isStringNumeric(String inputString) {

        boolean isValid = true;

        try {
            int testNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            isValid = false;
        }

        return isValid;
    }

    public static void getTempScoreValid() {
        Scanner ts = new Scanner(System.in);

        do {
            System.out.println("Please enter your score: ");
            while (!ts.hasNextInt()) {
                System.out.println("That's not a valid score! Please enter a positive integer:");
                ts.next(); // discard the non-integer input
            }
            tempScore = ts.nextInt();
            if (tempScore < 0) {
                System.out.println("You've entered a negative number. Please enter a positive integer:");
            }
        } while (tempScore <= 0); // repeat until positive integer is entered

    }

    public static void getTempDartsThrownValid() {
        Scanner td = new Scanner(System.in);

        do {
            System.out.println("Please enter how many darts it took: ");
            while (!td.hasNextInt()) {
                System.out.println("That's not a valid amount of darts! Please enter a positive integer:");
                td.next(); // discard the non-integer input
            }
            tempDartsThrown = td.nextInt();
            if (tempDartsThrown < 0) {
                System.out.println("You've entered a negative number. Please enter a positive integer:");
            }
            if (tempDartsThrown > 3) {
                System.out.println("You can't throw more than 3 darts. Please enter a valid amount of darts 1-3:");
            }

        } while (tempDartsThrown <= 0); // repeat until positive integer is entered

    }



    public static void checkRoundComplete(){
        if (Tools.p1Thrown && Tools.p2Thrown) {
            Game.roundTracker();
        }
    }
}





