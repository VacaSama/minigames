/** 
@Author: Kourtnie M. 
This program is a piggy bank, you can add an amount to your savings or checkings in addition to 
checking your balance of both. There is a secret case that you can guess and a company named 
"Lucky Duck" will crown you their lucky prize winner gifting you $100k (no strings attached)!!!
*/
import java.util.*;

public class PiggyBank { 
    public static double checkingAccount = 0.0; 
    public static double savingsAccount = 0.0; 
    public static boolean luckyDuck = false;
    
    public static void main(String[] args) { 
        Scanner userInput = new Scanner(System.in); 
         System.out.println("Welcome to your PiggyBank"); 
         System.out.println("You can check your savings, checking or deposit cash here:");
         System.out.println();

         cashIn(userInput);  
    }
/** 
@Param- requires a scanner with the users Input from the main to work. Main must then call the method
cashIn. A few booleans throughout the whole program, that's something I will always want to practice. 
No Return. The indentation looks slightly off to me... but I have been staring at this screen 
for a while now. 
*/
    public static void cashIn(Scanner userInput) { 
        boolean keepGoing = true;
        
        while(keepGoing){
        System.out.println("Please pick an option: ");        
        System.out.println("1. Deposit into Checkings Account\n" +
                           "2. Deposit into Savings Account\n" + 
                           "3. Check Balances\n" + 
                           "4. Close PiggyBank"); 
                                  
        int option = userInput.nextInt();
        
            switch (option) { 
                case 1: 
                    System.out.println("How much would you like to deposit? ");
                    checkingAccount += userInput.nextDouble();
                    break;
            
                case 2: 
                    System.out.println("How much would you like to deposit? ");
                    savingsAccount += userInput.nextDouble();
                    break;
            
                case 3:
                    System.out.println("You have $" + checkingAccount + " in your checkings and $" + 
                                    savingsAccount + " in savings."); 
                    break;
                    
                case 4: 
                    keepGoing = false;
                    System.out.println("Have a nice day!");
                    break;

                case 52:
                    if(!luckyDuck) { 
                        System.out.println("YOU ARE TODAY'S LUCKY DUCK!! CHECK YOUR SAVINGS TO VIEW YOUR PRIZE!");
                        savingsAccount += 100000;
                        luckyDuck = true;
                    }  
                    else {
                        System.out.println("Oh no no, you already won your 'Lucky Duck' prize. Try Again next time.");
                    }
                    break;
                 
                 default: 
                    System.out.println("That is not an option");
                    break;
            }
        }      
    }
}