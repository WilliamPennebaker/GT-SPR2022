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

public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        
        String mode;
        System.out.println("Enter (R)andom or (M)anual payoffs enteries");
        mode = myObj.nextLine();        
        //need to run verification that ONLY r or M are selected
        
        String row;
        System.out.println("How many rows (1-9)?");
        row = myObj.nextLine(); 
        
        //need to run verification for > 0 and <10
        
        String col;
        System.out.println("How many columns(1-9) ?");
        col = myObj.nextLine(); 
        
        System.out.println("You selected: " + mode); 
        System.out.println("Number of rows: " + row); 
        System.out.println("Number of colums: " + col); 
        //need to run verification for > 0 and <10
    }
    
}
