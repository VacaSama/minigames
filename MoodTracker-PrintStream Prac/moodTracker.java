// Author : Kourtnie M
// I alwasy forget to put stuff in here. I am working on getting better at JavaDoc.. Even though this isn't one but I am still 
// learning.

import java.util.*; 
import java.io.*;
/** This however is a JavaDoc 
 Here i have a moodTracker Program that allows you to basically journal in one spot and 
 make a text file of everything that you've written. Once you type in "exit" it should save to the file. 
*/
public class moodTracker { 
    public static Scanner journal = new Scanner(System.in); 
    
    public static void main(String[] args) { 
        // public Scanner journal = new Scanner(System.in); 
        introToMoody();
        journalWithMoody();
    }  
    /** JAVADOC
    Method: introToMoody() -- this is the into prompt just telling the user what this program is 
    for and instructions on how to use it
    */
    public static void introToMoody() { 
        System.out.println("Hiya! Welcome to Moody!");
        System.out.println("Sometimes we have issues recalling or managing emotions,");
        System.out.println("Moody helps you keep track of how you're feeling and "
        + "how often you're feeling these emotions.");
        System.out.println("Let's start with a date,");
        System.out.println("then how you're feeling, and finally a note if you like");     
    }
    /** JAVADOC
    Method: journalWithMoody() -- this is the structure to everything and how the printStream gets sent to the 
    txt file or notepad.. what have you :) 
    */
    
    public static void journalWithMoody() {  
        try (PrintStream entry = new PrintStream("journalEntry.txt")) { 
            String input;
            /* 
            WHILE it is TRUE that the JOURNAL(SCANNER) has a 
            NEXTLINE... INPUT it into the STRING(Input)
            */
            while (true) {    
                input = journal.nextLine();
                // close condition
                if ("exit".equalsIgnoreCase(input)) { 
                    break;
                }
                // write user input to file 
                entry.println(input);
            }         
            entry.close();   
        } 
        catch (FileNotFoundException e) { 
            System.err.println("Error: Could not add journal entry sucessfully");         
        }           
    }
}
