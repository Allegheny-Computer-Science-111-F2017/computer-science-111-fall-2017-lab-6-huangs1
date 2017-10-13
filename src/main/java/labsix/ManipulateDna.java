package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/** This class has a method that will proceed with a total of 5 steps.
 *  First step will read in a chosen dna string from another file.
 *  Second step will change the original dna string to its complement.
 *  Third step will insert a random dna letter into the 0th position of the string.
 *  Fourth step will randomly delete a letter from the dna string.
 *  Fifth step will randomly replace a letter in the original string with a random dna letter.
 *
 *@author Spencer Huang
 */

public class ManipulateDna {
  
  /** The main entry point for WordHide.
   *  The source code inside of this method will be executed when the program is
   *  run in the command-line. The output of this program will appear in the
   *  terminal window. The println statements make the program display output.
   *  The program will process the five steps and print out the corresponding output.
   *
   * @param args The command-line arumgents
   **/

  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Spencer Huang " + new Date());
    System.out.println("Okay, I am going to manipulate the Dna string \"actg\".");
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen Dna string
    String chosenDna = scanner.nextLine();
    chosenDna = chosenDna.toLowerCase();
    System.out.println("\nEnter a string containing only C, G, T, and A: " + chosenDna);
    // Step Two: Compute the complement of the Dna String
    String mutation1;
    mutation1 = chosenDna.replace('a', 'T');
    String mutation2;
    mutation2 = mutation1.replace('c', 'G');
    String mutation3;
    mutation3 = mutation2.replace('t', 'A');
    String mutation4;
    mutation4 = mutation3.replace('g', 'C');
    
    String complementDna = mutation4;
    System.out.println("Complement of ACTG is " + complementDna);

    // Step Three: Insert a randomly chosen Dna letter into the Dna String
    chosenDna = chosenDna.toUpperCase();
    Random insert = new Random();
    char rdmLetter = chosenDna.charAt(insert.nextInt(chosenDna.length()));
    System.out.println("Inserting " + rdmLetter + " at position 0 gives " + rdmLetter + chosenDna);
    // Step Four: Delete a Dna letter from a randomly chosen position in the Dna string
    Random deletion = new Random();
    int num1 = deletion.nextInt(chosenDna.length());
    String mutation5;
    mutation5 = chosenDna.substring(0, num1);
    String mutation6;
    mutation6 = chosenDna.substring(num1 + 1);
    // mutation 6 allows us to skip num1 and go on until the end of the string)
    System.out.println("Deleting from position " + num1 + " gives " + mutation5 + mutation6);
    // Step Five: Change a random position in the Dna String to a randomly chosen Dna letter
    Random change = new Random();
    int num2 = change.nextInt(chosenDna.length());
    String mutation7;
    mutation7 = chosenDna.substring(0, num2);
    char chLetter = chosenDna.charAt(insert.nextInt(num2));
    String mutation8;
    mutation8 = chosenDna.substring(num2 + 1, chosenDna.length());

    System.out.println("Changing position " + num2 + " gives " + mutation7 + chLetter + mutation8);
    // Step Six: Display a final thankyou message
    System.out.println("\nThanks for using the ManipulateDna program. \nHave an awesome day.");
  }

}
