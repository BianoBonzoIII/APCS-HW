/*
Brian Lin 
APCS pd8
HW21 -- Karmacomma
2017-23-10
*/

public class Commafier {

    public static String commafyR (int num) { //Recursive Method for commafier
	String num2 = Integer.toString(num); //String version of num
	int index = num2.length(); //Length of num
	if (num < 999) { // Base Case
	    return num2;
	}
	index -= 3; // This skips the number around in 3 digits
	String remainder = num2.substring(index); // Truncates num2 and saves increments of 3 digits
	return commafyR(num / 1000) + "," + remainder;
    }
    
    public static String commafyF (int num) { //Iterative Method for commafier
	String num2 = Integer.toString(num); //String version of num
	int numLength = num2.length();
	String comma = ",";
	String output = "";
	for (int index = 0; index < numLength; index += 3) {
	if (num < 999) {
	    return num2;
	}
	if (index - 3 < 0){
	    return output;
	}
	int placeholder = numLength % 3;
	String attachment = num2.substring(index, placeholder);
        output += attachment + ",";
	numLength -= 3;
	if (numLength < 3) {
	    return output;
	}
	}
	return output;
    }
    
    public static void main(String[] args) {
	/*
	System.out.println(commafyR(1000));
	System.out.println(commafyR(100));
	System.out.println(commafyR(12345));
	System.out.println(commafyR(12345678));
	System.out.println(commafyF(1000));
	System.out.println(commafyF(100));
	System.out.println(commafyF(12345));
	System.out.println(commafyF(12345678));
	*/
	for (int s: args) {
	    System.out.println(commafyR(s));
	    System.out.println(commafyF(s));
	}
}
}
