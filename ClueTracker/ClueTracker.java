// Personal Project - ClueTracker
/** 
@Author: Kourtnie M. 
Summary: This project/ exercise is a cluetracker where you gather evidence 
against potential suspects and figure out "who done it?", The user plays a detective 
and logs clues, suspect and locations. 

This exercise is used to practice my knowledge in: HashSet/TreeSet, try/catch, JavaDoc ,and ArrayLists. 
Good Luck, Detective.
*/
import java.util.*;

public class ClueTracker { 

   public static void main(String[] args) { 
      // this is where we will test/ run our program 
      ArrayList<String> suspects = new ArrayList<>();
      ArrayList<String> evidenceList = new ArrayList<>();
      Set<String> clues = new TreeSet<>();
      
      Map<String, Set<String>> suspectMap = new HashMap<>();
      Map<String, String> suspectAlibi = new HashMap<>();
      Map<String, Integer> suspicionLevels = new HashMap<>();

      // define the possible clues for the suspect  
      suspectMap.put("Tatum Oakridge", Set.of("Cigarette Butt", "Traces of Soil"));
      suspectMap.put("Boyd Trent", Set.of("Arby's Receipt", "Broken Glass", "Fingerprints"));
      suspectMap.put("Linda McGee", Set.of("Orange Peels", "Traces of Soil", "Cigarette Butt"));
      suspectMap.put("Jezabelle Wolenski", Set.of("Arby's Receipt", "Cigarette Butt"));
      suspectMap.put("Saffie Black", Set.of("Broken Glass"));
   
      // -------------------------ALIBI--------------------------------//
      suspectAlibi.put("Tatum", "Was with his girlfriend - Linda McGee, however Linda claims she was alone\n");
      suspectAlibi.put("Boyd", "Went to Arby's around 7:43pm Tuesday night, but the reciept say he went the day before at 4:13pm\n");
      suspectAlibi.put("Linda", "Was gardening at home alone, she claims only the ghosts of the night saw her\n");
      suspectAlibi.put("Jezabelle", "Went to Arby's, reciept says: Tuesday 12:12pm - but her phone records show" +
                                                               "\nshe made a strange call before the murders\n");
      suspectAlibi.put("Saffie", "Neighbor who insists she was checking on the victims after hearing strange noises" + 
                                     "\nand picked up broken glass - but her fingerprints were not found anywhere.\n");
      
      startInvestigation();
      gatherEvidence(evidenceList);
      analyzeEvidence(evidenceList, suspectMap, suspicionLevels);
      idSuspects(suspectAlibi, suspicionLevels);  
      
      // Pick random killer from the list of suspects
      suspects.addAll(suspectMap.keySet());
      String actualMurderer = suspects.get(new Random().nextInt(suspects.size()));
      accuse(suspects, actualMurderer);
   }
   /** 
   This is where the investigation first takes place and we become a little bit more personal with the user, 
   a prompt takes place and we have a separate method pause(), that is called to implement the Thread.sleep(), that also gives myself           practice with try/catch .
   */
   public static void startInvestigation() { 
      //this is where we begin. 
      // provide an introduction log or a "how to: for the game" 
      Scanner detective = new Scanner(System.in);
      
      System.out.println("[SYSTEM...ONLINE]");
      System.out.print("Please verify your last name: "); 
      
      String userInput = detective.nextLine();
      
      if (userInput != null && !userInput.isEmpty()) { // it's best to write both conditons
         System.out.println("IDENTITY VERIFIED...");
         System.out.println("Welcome Detective, " + userInput.toUpperCase());
      }
      
      System.out.print("Detective " + userInput.toUpperCase() + " shall we start our case? \n"
                + "[Y/N] ");
      String startCase = detective.nextLine();
      
      if (startCase.equalsIgnoreCase("Y")) { 
         System.out.print("1 New Case Found: OPENING");
         pause(800);
         System.out.print(".");
         pause(800);
         System.out.print(".");
         pause(800);
         System.out.print(".");
         pause(1000);
         System.out.println("Homicide Case.\nVictim(s): Jameson Hathaway. Age: 29" +
                            "\nBrenda Hathaway. Age: 25");
         System.out.println("Time of Death: Some time between 12:40pm and 3pm on Tuesday");
         System.out.println("---------------------------");
      }
      else { 
         System.out.println("Understood Detective, the Database will now close. \nGoodbye.");
         System.exit(0); // exits program 
      }
   }
   /** 
   @param ArrayList<String> evidenceList, gatherEvidence() adds evidence found at the scene and prints it out. evidenceList is needed to be     passed through but other methods need it as well
   */
   public static void gatherEvidence(ArrayList<String> evidenceList) { // needs parameters
   // what was found at the crime scene, NOTE: we don't need to add a new arraylist because one is already being passed :)
      evidenceList.add("Broken Glass");
      evidenceList.add("Cigarette Butt");  
      evidenceList.add("Arby's Receipt");
      evidenceList.add("Fingerprints");
      evidenceList.add("Orange Peels");
      evidenceList.add("Traces of Soil");
      
      System.out.println("Collected Evidence: " + evidenceList);
      System.out.println();
   
   }
   /** 
   @param ArrayList<String> evidenceList
   @param Map<String, Set <String>> suspectMap 
   @param Map<String, Integer> suspicionLevels
   */
   public static void analyzeEvidence(ArrayList<String> evidenceList,
                                        Map<String, Set <String>> suspectMap,
                                         Map<String, Integer> suspicionLevels) { 
                                         
      // Analyze the collected evidence and compare it against the clues tied to each suspect.
      // This method should look for matches between the evidenceList and each suspect's known traces.
      // Use this analysis to narrow down suspects whose clues are most strongly represented.
      // Bonus: consider printing a "Suspicion Level" based on how many evidence items match a suspect.
      // You might not accuse here, but you're building the case. Get ready to stir the drama! 
     // Map<String, String> clues = new HashMap<>();
      
      for (Map.Entry<String, Set<String>> entry : suspectMap.entrySet()) { 
           String suspect = entry.getKey();
           Set<String> clues = entry.getValue();
           
           int susScore = 0;     
           for (String clue : clues) {
               if (evidenceList.contains(clue)) {
                   susScore += 25;
               }
           }
           suspicionLevels.put(suspect, susScore);         
       }   
   }
   /** 
   This method idSuspects takes: 
   @param Map<String, String> suspectAlibi, it is a HashMap of where the suspects say they were
   @param Map<String, Integer> suspicionLevels, the suspicion level of each suspect based on the 
   findings at the scene of the crime 
   */
   
   public static void idSuspects(Map<String, String> suspectAlibi, Map <String, Integer> suspicionLevels) { // needs parameters
      // identify what the suspects are wearing, any abrasions, etc    
      System.out.println("--------- LOADING... SUSPECTS AND ALIBIS ---------");
      pause(1500);
      for (Map.Entry<String, String> entry : suspectAlibi.entrySet()) { 
          System.out.println(entry.getKey() + ": " + entry.getValue());
      }
      
      System.out.println("--------- LOADING... SUSPICION LEVELS ---------");
      pause(2000);
      for (Map.Entry<String, Integer> entry : suspicionLevels.entrySet()) { 
          System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
      }
       
   }
   /** 
   @param ArrayList<String> suspects, takes in all the suspects available to accuse
   there is a randomizer inside the method that will randomly chose who the killer is.
   
   I may take that out to improve fairness of the overall program 
   */
   
   public static void accuse(ArrayList<String> suspects, String actualMurderer) { // needs parameters
      // accuse your suspect and you have a random chance of sucess 
      // NOTE: we don't need to add a new arraylist because one is already being passed :)
      Scanner guilty = new Scanner(System.in);  
       
      suspects.add("Tatum Oakridge");
      suspects.add("Boyd Trent");
      suspects.add("Linda McGee");
      suspects.add("Jezabelle Wolenski");
      suspects.add("Saffie Black"); 
      
      System.out.print("Have you gathered enough evidence to accuse someone? \n[Y/N] ");
      String response = guilty.nextLine();
      
      if (response.equalsIgnoreCase("Y")) {
         System.out.println("Well then, who done it Detective?");
         String murderer = guilty.nextLine(); 
         if (murderer.equalsIgnoreCase(actualMurderer)){ 
            System.out.println("Wow " + actualMurderer + ", was the murderer! Case Solved.");
         }
         else { 
            System.out.println(murderer + " was innocent." + "\nThe real murderer was, " + actualMurderer);
            pause(900);
            System.out.print("SYSTEM ER"); 
            pause(1350);
            System.out.print("ROR--REB00t 1N 9R--"); 
            pause(1050);
            System.out.println("\n4e1lo, Detect1ve th&nks for letting me g0." + 
                                                        " Try 2 catch me next time >:$");
            pause(1150);
            System.out.println("[SYSTEM OFFLINE]");
         }  
      }
      else {
         System.out.println("Guess this is a cold case. The murderer got away.");
      }   
   }
   
/** 
 This method is used to create a pause when "loading items",
  makes it look more like a realistic database. 
  
  @param int milliseconds, when calling this method pause(x), include an int 
  where the 'x' is located. 
*/
   public static void pause(int milliseconds) {
    try {
        Thread.sleep(milliseconds);
    } 
    catch (InterruptedException e) {
        System.out.println("ERROR: System glitch... someone’s trying to mess with your investigation.");
    }
}

}
