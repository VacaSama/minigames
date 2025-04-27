// Kourtnie Moore 
// Personal Project - Java 
// This program is a mini-game, that shows a greater understanding of while loops,
// if/else if statements, this/super keyword,classes and inheritance. 

import java.util.Random;
import java.util.Scanner;

public class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected Random randDamage = new Random(); // Use for attack randomness

    public Character(String name, int health, int attackPower) {
        Scanner newName = new Scanner(System.in);
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Character target) {
        // Generate random attack damage between 1 and attackPower. 
        int damage = randDamage.nextInt(attackPower) + 1;
        target.health -= damage; // apply damage to enemy

    }

    public boolean isAlive() {
        //Return whether health is greater than 0.
        return health > 0; 
    }

    public void displayStats() {
        // Print the character's health so the player can track it.
        System.out.println("Character Health: " + health); 
    }

        public static void main(String[] args) {
            Scanner userInput = new Scanner(System.in);
            Hero hero = new Hero("Knight"); // reate a new Hero object.
        
            Character[] monsters = {new Goblin(), new Dragon(), new Minotaur()}; // Store monsters in an array.

            System.out.println("Welcome, " + hero.name + "! Get ready for battle!");
            System.out.println("Hero Stats: " + hero.name + " HP " + hero.health + ". Max Attack " + hero.attackPower);

        // Loop through monsters
            for (Character monster : monsters) {
                System.out.println("\n A wild " + monster.name + " appears!"); 
                System.out.println("Monster Stats: " + monster.name + " HP " + monster.health + ". Max Attack " + monster.attackPower);

                while (hero.isAlive() && monster.isAlive()) { //  Battle continues while both are alive.
                    System.out.println("\nChoose an action: [1] Attack [2] Heal");
                    int choice = userInput.nextInt();
                    
                                                         
                    if (choice == 1) { 
                    //  Hero should attack monster.
                        hero.attack(monster);
                        System.out.println(hero.name + " has attacked the " + monster.name + " their health has dropped to: " + monster.health);
                    //  Monster should attack Hero (if still alive).
                        try { 
                            System.out.println(monster.name + " is preparing to attack...");
                            Thread.sleep(2000);
                            monster.attack(hero);
                            System.out.println(monster.name + " has attacked. Your health dropped to: " + hero.health);
                        }
                        catch (InterruptedException e) { 
                            e.printStackTrace();
                        }  
                    }
                    else if (choice == 2) { 
                    //Call Hero's heal method.
                        hero.heal(); // HERO dot Heal(); because we need to heal the hero not the monsters 
                    }
                }

                    if (!hero.isAlive()) {
                        System.out.println("\n It would appear that you've been vanquished... Game Over!");
                        break; // Stop loop if Hero dies.
                    }                
                    else {
                        System.out.println("\n You defeated the " + monster.name + "!");
                    }
            }
            if (hero.isAlive()) {
                System.out.println("\n Congratulations, " + hero + "! You defeated all monsters!");
            }
        }
    }
