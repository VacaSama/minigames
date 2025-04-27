//Kourtnie Moore - Inheritance Practice

//              PLAYER HERO             //
public class Hero extends Character {
    private int potions = 3; // Limited healing
    
    
    public Hero(String name) {
        super(name, 100, 20); // Set Hero's health & attack.
 
    }

    public void heal() {
        if (potions > 0) { 
            // Increase Hero's health and decrease potions count.
            this.health += 15; // increase health by 15
            potions--; // decreases potions after use
            System.out.println("You drank a healing potion! Your health is now at : " + this.health);
        }
        else {
            //Print that Hero has no potions left.
            System.out.println("Hero has no potions left");
        }
    }
}
