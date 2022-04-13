//=============================================================================
//PROGRAMMER1: Samantha Loeb
// PANTHER ID1: 5503481
// CLASS: Your class: COP5507
//
//PROGRAMMER2: William Pennebaker
// PANTHER ID2: 6154734
// CLASS: Your class: COP5507
//
// SEMESTER: Spring 2022
// CLASSTIME: COP5507 Online
//
// Project: Depending on the user input, this program will run random or manual, 
// and return payoff entries in a 1x1 to 9x9 display.
//
//
// DUE: Sunday, April 17, 11:59pm
//
// CERTIFICATION: I certify that this work is my own and that
// none of it is the work of any other person.
//=============================================================================
package app;
import java.util.Scanner;  // Import the Scanner class for user input
import java.util.Random;

public class Controller {
    
    static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    static int[][] playerOne;
    static int[][] playerTwo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initializing vars
        String mode = "";
        int row = 0, col = 0;
        
        // Random or Manual
        do {
            System.out.println("Enter (R)andom or (M)anual payoffs enteries");
            mode = myObj.nextLine();
            // Checking if user entered "M" or "R"
            if (!(mode.equals("M") || mode.equals("R"))) {
                System.out.println("Please enter (R)andom or (M)anual.");
            }
        // Loop until user entered "M" or "R"
        } while (!(mode.equals("M") || mode.equals("R")));
        
        // Asking for rows
        do {
            System.out.println("How many rows (1-9)?");
            row = myObj.nextInt(); 
            myObj.nextLine(); // Clearing scanner buffer
            // Checking if user entered a number 1-9
            if (row < 1 || row > 9) {
                System.out.println("Please enter a number between 1 and 9.");
            }
        // Loop until user enters a number 1-9
        } while(row < 1 || row > 9);
        
        // Asking for columns
        do {
            System.out.println("How many columns(1-9) ?");
            col = myObj.nextInt(); 
            myObj.nextLine();
            if (col < 1 || col > 9) {
                System.out.println("Please enter a number between 1 and 9.");
            }
        } while(col < 1 || col > 9);
        
        System.out.println("You selected: " + mode); 
        System.out.println("Number of rows: " + row); 
        System.out.println("Number of colums: " + col); 
        
        playerOne = new int [row][col];
        playerTwo = new int [row][col];
        
        if (mode.equals("M")) {
            Manual(row, col);
        } else {
            Random(row, col);
        }
    }
    
    /**
     * 
     * @param row
     * @param col
     */
    public static void Random(int row, int col) {
        
        /**
         * Need to add 2x2 with no Pure Nash Equilibrium after figuring these out
         */
        //int[] pureNash = new int[10]; -- Not sure if using this or the boolean yet
        boolean foundPureNash = false;
        Random myRan = new Random();
        
        // Generate player 1 strategies from row count
        System.out.println("--------------------------------");
        System.out.println("Player: Player1's strategies");
        System.out.println("--------------------------------");
        
        for (int i = 1; i <= row; i++) {
            if (i == 1) {
                System.out.print("{A" + i + ", ");
            } else if (i == row) {
                System.out.println("A" + i + "}");
            } else {
                System.out.print("A" + i + ", ");
            }
        }
        // Random number gen for player 1 playoff between -99 and 99
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("Player: Player1's payoffs");
        System.out.println("--------------------------------");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int random = myRan.nextInt((99 + 99) + 1) - 99;
                playerOne[i][j] = random;
                if (j == col - 1) {
                    System.out.println(playerOne[i][j]);
                } else {
                    System.out.printf("%-5s", playerOne[i][j] + ", ");
                }
            }
        }
        
        // Generate player 2 strategies from col count
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("Player: Player2's strategies");
        System.out.println("--------------------------------");
        for (int i = 1; i <= col; i++) {
            if (i == 1) {
                System.out.print("{B" + i + ", ");
            } else if (i == col) {
                System.out.println("B" + i + "}");
            } else {
                System.out.print("B" + i + ", ");
            }
        }
        // Random number gen for player 2 payoffs between -99 and 99
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("Player: Player2's payoffs");
        System.out.println("--------------------------------");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int random = myRan.nextInt((99 + 99) + 1) - 99;
                playerTwo[i][j] = random;
                if (j == col - 1) {
                    System.out.println(playerTwo[i][j]);
                } else {
                    System.out.printf("%-5s", playerTwo[i][j] + ", ");
                }
            }
        }
        
        // Display Normal Form
        PrintNormalForm(row, col);
        
        // Display Nash Pure Equilibrium Locations
        System.out.println("");
        System.out.println("================================");
        System.out.println("Nash Equilibrium Locations");
        System.out.println("================================");
        
        
        // Find Pure Nash(s) and put them in pureNash array
        
        
        if (row == 2 && col == 2 && !foundPureNash) {
            
        } else if (!foundPureNash) { // No Pure Nash
            System.out.println("Nash Equilibrium(s): No Pure Nash Found");
            // Print Normal Form
            PrintNormalForm(row, col);
        } else { // Found Pure Nash
            System.out.println("Nash Equilibrium(s): ");
        }
        
        
        
        
        // Random beliefs Player 1
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Player 1 Expected Payoffs with Player 2 Mixing");
        System.out.println("----------------------------------------------");
        
        // Best Response Player 1
        System.out.println("");
        System.out.println("-------------------------------------------");
        System.out.println("Player 1 Best Response with Player 2 Mixing");
        System.out.println("-------------------------------------------");
        
        // Random beliefs Player 1
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Player 2 Expected Payoffs with Player 1 Mixing");
        System.out.println("----------------------------------------------");
        
        // Best Response Player 1
        System.out.println("");
        System.out.println("-------------------------------------------");
        System.out.println("Player 2 Best Response with Player 1 Mixing");
        System.out.println("-------------------------------------------");
        
        
        
        
        // Expected Payoffs with both Players Mixing
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Player 1 & 2 Expected Payoffs with both Players Mixing");
        System.out.println("------------------------------------------------------");
    }
    
    /**
     * 
     * 
     * @param row
     * @param col
     */
    public static void Manual(int row, int col) {
        System.out.println("Manual Entries");
    }
    
    /**
     * Printing Normal Form
     * @param row
     * @param col
     */
    public static void PrintNormalForm(int row, int col) {
        System.out.println("");
        System.out.println("================================");
        System.out.println("Display Normal Form");
        System.out.println("================================");
        
        for (int i = 0; i < row; i++) {
            // Print out B index
            // B1 B2 B3 ...
            if (i==0) {
                System.out.print("           ");
                for (int j = 0; j < col; j++) {
                    System.out.printf("%-14s", "B" + (j+1));
                }
                System.out.println("");
            }
            
            System.out.print("    ");
            System.out.println("--------------".repeat(col));
            System.out.printf("A" + (i+1) + " | ");
            for (int j = 0; j < col; j++) {
                System.out.printf("%3s", "(");
                System.out.printf("%1$3s", playerOne[i][j]);
                System.out.print(",");
                System.out.printf("%1$-3s", playerTwo[i][j]);
                System.out.printf(")");
                System.out.printf("%3s", "|");
            }
            System.out.println("");
        }
        System.out.print("    ");
        System.out.println("--------------".repeat(col));
    }
}
