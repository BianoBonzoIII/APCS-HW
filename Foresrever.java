/* 
   <Brian Lin>
   APCS1 pd<8>
   HW<20> -- <For the Lulz Love of Strings>
   <2017>-<10>-<19>
*/

public class Foresrever {

    public static String fenceF (int posts) { // Returns a String representation of a fence
	String wholeFence = "";   // The output of the method
	for (int num = posts; num > 0; num -= 1) { // For loop 
	    if (num == 1) {         // Base Case
	    wholeFence += "|";       
	    return wholeFence;
	}
	    wholeFence += "|--";
	}
	return wholeFence;
    }

    public static String reverseF (String s) { // Reverse String method using a for loop
	String output = "";
	int length1 = s.length(); // length1 is an empty string
	int length2 = length1 - 1; //length2 is the last letter of the word 
	for (int ctr = length2; ctr > 0; ctr -= 1) {
	    if (ctr == 0) {
		return output;
	    }
	    output += s.substring(ctr, length1);
	    length1 -= 1;
	}
	return output + (s.substring(0,1));
    }

    public static String reverseR (String s) { // Reverse String method using recursion
	String output = "";
	int length1 = s.length(); // length1 is an empty string
	int length2 = length1 - 1; //length2 is the last letter of the word 
	if (length1 == 0) {  // Base Case
	    return output;
	}
        output += s.substring(length2, length1); //The last letter of the word becomes the value of output
	String newWord = s.substring(0, length2);
	return output += reverseR(newWord); // This ensures that output is a new character every cycle
    }

    // Testing of the Methods
    public static void main (String[] args) {
	System.out.println(fenceF(3)); // Should return |--|--|
	System.out.println(reverseF("Database")); // Should return esabataD
	System.out.println(reverseF("RacecaR")); // Should return RacecaR
	System.out.println(reverseR("MySpaceisAlive")); // Should return evilAsiecapSyM
	System.out.println(reverseR("NASCAR")); // Should return RACSAN
    }
}
