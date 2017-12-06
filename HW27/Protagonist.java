/*
  Team Basement Dwellers -- Brian, George, Kendrick 
  Brian Lin 
  APCS1 - pd8
  2017-11-08
 */

public class Protagonist{
    private static String name;// initializes String name 
    private static int hp;// initializes an int hp representing health
    private static int str;// initializes an int str representing strength
    private static int def; // initializes an int def representing defense
    private static double atkRate; // initializes a double atkRating representing attack rating

    public Protagonist(String n){
	name = n; // sets name to n
	hp = 125;// sets health to 125
	str = 100;// sets strength to 100
	def = 40;// sets defense to 40
	atkRate = 0.4;// sets atkRate to 0.4
    }

    public static boolean isAlive(){
	if (hp <= 0){ // returns false if an object's health is less than or equal to 0, in case that an overkill happens
	    return false;
	}
	return true;// returns true if an object's health is not less than or equal to 0, meaning they are alive 
    }

    public static int getDefense(){
	return def; // returns object's defense
    }

    public static String getName(){
	return name;// returns object's name
    }
    public static void lowerHP(int dmg){// lowers hp based on the value of dmg
	hp -= dmg;
    }
    public static int attack(Object mons){
	int dmg = (int)((str * atkRate) - Monster.getDefense());//calculates damage
	lowerHP(dmg);//sets hp based on method above
	return dmg;//returns the amount of damage done
    }
    public static void specialize(){//buffs attack at cost of defense
	atkRate += .8;
	str += 8;
	def -= 10;
    }
 
    public void normalize(){// debuffs all stats that were buffed in specialize() back to their original values
	atkRate = 0.4;
	str = 100;
	def = 40;
    } 
}
