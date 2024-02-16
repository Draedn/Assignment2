/*
Title: Tools
Author: Draedn Groves
Date: Feb.13th/2024
Purpose: Tools
 */


import java.io.IOException;
import java.util.Scanner;
import java.io.Console;


// Container for Tools to be used.
// Tools should be GENERIC enough to be used in other programs.
public class Tools {

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

}



