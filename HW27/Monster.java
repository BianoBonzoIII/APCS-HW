/*
  Team Basement Dwellers -- Brian, George, Kendrick 
  Brian Lin 
  APCS1 - pd8
  2017-11-08
*/

public class Monster {
    private static int hp; 
    private static int str;
    private static int def;
    private static double atkrate;
    private static String name;

    public Monster() { // Initializes all attributes
	hp = 150;
	def = 20;
	atkrate = 1.0;
	str = 30;
	name = "Lava Ogre";
    }
    
    public static boolean isAlive() { // Returns boolean indicating living or dead
	boolean alive = true;
	if (hp <= 0) {
	    return !alive;
	}
	return alive;
    }
    
    public static int getDefense() { // Returns value of defense attribute
	return def;
    }

    public static String getName() { // Returns value of name attribute
	return name;
    }

    public static void lowerHP(int damage) { // takes an int parameter, decreases life attribute by that amount
	hp -= damage;
    }

    public static int attack(Object protag) {
	int damage = (int) ((str * atkrate) - Protagonist.getDefense());// finds damage dealt based on monster's attack and warrior's defense
	lowerHP(damage);//reduces hp based on preceding method
	return damage;//returns damage dealt
    }

    public static void main (String[] args) {
    }
}
	
