// Author : Kourtnie M
//

import java.util.*; 
import java.io.*;

public class moodTracker { 
    public static Scanner journal = new Scanner(System.in); 
    
    public static void main(String[] args) { 
        // public Scanner journal = new Scanner(System.in); 
        introToMoody();
        journalWithMoody();
    }  
    
    public static void introToMoody() { 
        System.out.println("Hiya! Welcome to Moody!");
        System.out.println("Sometimes we have issues recalling or managing emotions,");
        System.out.println("Moody helps you keep track of how you're feeling and "
        + "how often you're feeling these emotions.");
        System.out.println("Let's start with a date,");
        System.out.println("then how you're feeling, and finally a note if you like");     
    }
    
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