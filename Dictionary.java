import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary extends AVLTree {
    private String s;
    private int size;
    private AVLTree<String> tree;

    public Dictionary(String s) { //constructor
        this.s = s;
        tree.insert(s);
        size = 0;
    }

    public Dictionary(File f) throws FileNotFoundException { //constructor
        System.out.println("Loading dictionary..."); //loading dictionary
        tree = new AVLTree<>(); //creating new tree
        Scanner scanner = new Scanner(f); //scanning file
        size = 0; //size of dictionary
        while (scanner.hasNextLine()) { //while there is a next line
            String s = scanner.nextLine(); //s is the next line
            tree.insertAVL(s); //inserting the word into the tree
            size++; //incrementing size
        }
        scanner.close(); //closing scanner
    }

    public Dictionary() { //constructor
        tree = new AVLTree<>(); //creating new tree
        size = 0; //size of dictionary
    }

    public void addWord(String s) throws WordAlreadyExistsException { //adding word to dictionary
        if (tree.isInTree(s)) { //if the word is already in the tree
            throw new WordAlreadyExistsException("Word already exists!"); //throw exception
        } else { //if the word is not in the tree
            tree.insert(s); //insert the word into the tree
            System.out.println("Word added successfully!"); //print success message
        }
    }

    public boolean findWord(String s) { //finding word in dictionary
        if (tree.isInTree(s)) { //if the word is in the tree
            System.out.println("Word found!"); //print success message
            return true; //return true
        } else { //if the word is not in the tree
            System.out.println("Word not found!");  //print error message
            return false; //return false
        }
    }

    public void deleteWord(String s) throws WordNotFoundException { //deleting word from dictionary
        if (tree.isInTree(s)) { //if the word is in the tree
            tree.deleteAVL(s); //delete the word from the tree
            System.out.println("Word deleted successfully!"); //print success message
        } else { //if the word is not in the tree
            throw new WordNotFoundException("Word not found!"); //throw exception
        }
    }

    public String[] findSimilar(String s){ //finding similar words
        String similar =""; //creating new array of similar words
        for(int i = 0; i < s.length(); i++){ //for each letter in the word
            String temp = s.substring(0, i) + "" + s.substring(i + 1); //temp is the word without the letter
            if (tree.isInTree(temp)){ //if the word is in the tree
                // check if duplicate don't add it
                if(!similar.contains(temp)){
                    //add the word to the string similar
                    similar += temp + " ";}

            }
            for(int j = 0; j < 26; j++){ //for each letter in the alphabet
                char c = (char) (j + 'a'); //c is the letter
                temp = s.substring(0, i) + c + s.substring(i + 1); //temp is the word with the letter added
                if (tree.isInTree(temp)){ //if the word is in the tree
                    // check if duplicate don't add it
                    if(!similar.contains(temp)){
                        //add the word to the string similar
                        similar += temp + " ";
                    }
                }
            }
        }
        String[] similarWords = similar.split(" "); //splitting the string into an array
        return similarWords; //return the array of similar words
    }







    public void saveDictionary(String fileName) throws IOException { //saving dictionary to file
        //create file
        File file = new File(fileName); //creating new file
        //create file writer
        FileWriter writer = new FileWriter(file); //creating new file writer
        String[] list = tree.inorderList(); //creating list of words in dictionary
        for (String s : list) { //for each word in the list
            writer.write(s + " "); //write the word to the file
            writer.write(System.lineSeparator()); //write a new line
        }
        writer.close(); //close the writer
    }

    public static class WordNotFoundException extends Exception { //exception for word not found
        public WordNotFoundException(String errorMessage) { //constructor
            super("Word not found."); //print error message
        }
    }

    public class WordAlreadyExistsException extends Exception { //exception for word already existing
        public WordAlreadyExistsException(String errorMessage) { //constructor
            super("Word Already Exists."); //print error message
        }
    }
}



