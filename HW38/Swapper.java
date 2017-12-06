/* 
   Brian Lin 
   APCS1 pd8
   HW40 -- Make It Better
   2017-11-21
*/ 

/*** 
     SUMMARY:
     There is a final instance variable called WORDS where it contains unique 3-4 character 
     words. The 2D array is a 5 by 5 array. The arrayPop() method assigns each 
     "box" with a unique String from WORDS. print1() prints each row in the array 
     one line at a time. swap() takes in 4 parameters so that the two locations are 
     clear. It swaps the items at these locations and use print1() to show the array. 
***/

/***
    TWO IMPROVEMENTS
    - Robustify Comments
    - Error Handling
***/

import cs1.Keyboard;

public class Swapper {

    private static final String[] WORDS = { // Instance variable that contains unique 3-4 char Strings
	"lime", "cat", "cool", 
	"blue", "red", "dog", 
	"tick", "tock", "up", 
	"down", "more", "less", 
	"peel", "draw", "read", 
	"hose", "tube", "big", 
	"box", "job", "sing", 
	"jinx", "zap", "sin", 
	"jury", "mage", "tree",
    };
	
    public static String[][] array; // Initialization of array
    
    public static void arrayPop() { // Populates the array with words
	Keyboard in = new Keyboard();
	System.out.println("\n=============== Sup ================\n");
	System.out.println("Time for you to Make an Array.\n");
	System.out.println("Please make sure your inputs are less than 6 Please...\n");
	System.out.print("Input Your Row # Please: ");
	int rownum = in.readInt();
	if (rownum > 5 || rownum == 0) {
	    System.out.println("How dare you... rownum is now defaulted to 5");
	    rownum = 5;
	}
 	System.out.print("\nInput Your Column # Please: ");
	int colnum = in.readInt();
	if (colnum > 5 || colnum == 0) {
	    System.out.println("How dare you... colnum is now defaulted to 5");
	    colnum = 5;
	}
	array = new String[rownum][colnum];
	int counter = 0;
	for (int i = 0; i < array.length; i++) { // For loop that populates array with integer values
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = WORDS[counter];
		counter++;
	    }	
	}
    }
    
    //postcond: prints each row of 2D String array a on its own line
    //          uses a FOR loop
    public static void print( String[][] a ) {
	System.out.println("\n============ Long and Behold! =============\n");	
	for (int r = 0; r < a.length; r++) { // In each row
	    System.out.print("|");
	    for (int j = 0; j < a[r].length; j++) { // In each box in the row
		System.out.print("|" + a[r][j] + "|");
		if (j == a[r].length - 1) {
		    System.out.print("|");
		}
	    }
	    System.out.println("\n ");
	}
	System.out.println("===============================================");
    }
		
    public static void swap() { // Swaps two items in array
	Keyboard on = new Keyboard();
	System.out.println("\n=============== Time to Create Some Chaos! ================\n");
	System.out.println("You will now give me the 'coordinates' of the first word\n");
	System.out.print("Input the First Row # You Want to Replace Please: ");
	int rownum1 = on.readInt();
	if (rownum1 > (array.length - 1)) {
	    System.out.println("NO NOt AGAin... rownum is now defaulted to 0");
	    rownum1 = 0;
	}
 	System.out.print("\nInput the First Column # You Want to Replace Please: ");
	int colnum1 = on.readInt();
	if (colnum1 > array[0].length) {
	    System.out.println("NO NOt AGAin... colnum is now defaulted to " + (array[0].length - 1));
	    colnum1 = array[0].length - 1;
	}
	System.out.println("\nAWESOME!");
	System.out.println("\nYou will now give me the 'coordinates' of the second word\n");
	System.out.print("Input the Second Row # You Want to Replace Please: ");
	int rownum2 = on.readInt();
	if (rownum2 > array.length) {
	    System.out.println("NO NOt AGAin... rownum is now defaulted to " + (array.length - 1));
	    rownum2 = array.length - 1;
	}
 	System.out.print("\nInput the Second Column # You Want to Replace Please: ");
	int colnum2 = on.readInt();
	if (colnum2 > (array[0].length - 1)) {
	    System.out.println("NO NOt AGAin... colnum is now defaulted to 0");
	    colnum2 = 0;
	}
	System.out.println("================== And Voila! ===================");
	String oldElement = array[rownum1][colnum1];
	array[rownum1][colnum1] = array[rownum2][colnum2];
	array[rownum2][colnum2] = oldElement;
	print(array);
    }
    
    public static void main( String [] args ) {
	arrayPop();
	print(array);
	swap();
    }
}  
