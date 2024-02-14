
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        try {
            // ask to enter file name
            System.out.print("Enter filename> "); //prompt user for file name
            Scanner scanner1 = new Scanner(System.in); //scanner for user input
            String filename = "src\\" + scanner1.nextLine(); //filename is the user input
            Dictionary dictionary = new Dictionary(new File(filename)); //creating new dictionary
            Scanner scanner = new Scanner(System.in); //creating new scanner
            System.out.println("Welcome to the dictionary!"); //welcome message
            System.out.println("");
            System.out.print("check word> "); //prompting user for input
            String s = scanner.next(); //getting user input
            dictionary.findWord(s); //finding word in dictionary
            System.out.println("");
            System.out.print("add new word>"); //prompting user for input
            s = scanner.next(); //getting user input
            try {
            dictionary.addWord(s); //adding word to dictionary
            } catch (Dictionary.WordAlreadyExistsException e) {
                System.out.println("Word already exists."); //print error message
            }
            System.out.println("");
            System.out.print("remove word> "); //prompting user for input
            s = scanner.next(); //getting user input
            try {
            dictionary.deleteWord(s); //deleting word from dictionary
            } catch (Dictionary.WordNotFoundException e) {
                System.out.println("Word not found.");; //print error message
            }
            System.out.println("");
            System.out.print("Search for similar words> "); //prompting user for input
            s = scanner.next(); //getting user input
            String[] similar = dictionary.findSimilar(s); //finding similar words
            if(similar.length==0){ //if there are no similar words
                System.out.println("No similar words found!"); //print message
            } else { //if there are similar words
                System.out.println("Similar words: " + Arrays.toString(similar)); //print similar words
            }
            System.out.println("");
            System.out.print("Save Updated Dictionary (Y/N)> "); //prompting user for input
            s = scanner.next(); //getting user input
            if (s.equals("Y")) { //if the user wants to save the dictionary
                //ask to enter file name
                System.out.print("Enter filename> ");
                String filename2 = "src\\" + scanner1.nextLine();
                dictionary.saveDictionary(filename2); //save the dictionary
                System.out.println("Dictionary saved successfully!"); //print success message
            } else { //if the user does not want to save the dictionary
                System.out.println("Dictionary not saved!"); //print message
            }
            System.out.println("Thank you for using our Dictionary"); //goodbye message
            scanner.close(); //closing scanner
        } catch (FileNotFoundException e) { //catching file not found exception
            System.out.println("File not found!"); //print error message
        } catch (IOException e) { //catching io exception
            e.printStackTrace(); //print stack trace
        }

    }
}
//END OF LAB PROJECT

