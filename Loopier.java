/* 
   Brian Lin 
   APCS1 pd08
   HW25 -- All Hallow's Eve 
   2017-10-31
*/


public class Loopier {
    public static int numGen() {  // Generates a number, x, where 1 <= x <= 10
	double number = Math.random(); // Utilizes random() in order to draw a double
	number = number * 10; // Since random() returns doubles that are >= 0.0 and < 1.0, multiplying the
	// double by 10 is necessary in order to draft an integer value                      
	number += 1; // Ensures that array.length can't be 0
	return (int) number; // Typecasts the number so that the return value is an integer
    }
       
    public static int[] array; // Declaration of an array
    
    public static String stringify(int num) { // Stringifies integer values in array
	return Integer.toString(num);
    }
    
    public static void arrayPop() {  // Populates array with random coutning integers
	array = new int[numGen()];
	for (int index = 0; index < array.length; index++) { // For loop that populates array with integer values
	    array[index] = numGen();
	}
    }
    
    public static String arrayString() { // Returns the String form of array
      String start = "[ "; // Starting square bracket
      String breaks = " "; // Space in between each integer
      String end = "]"; // Ending square bracket
      for (int index = 0; index < array.length; index++) { // For loop that stringifies each integer in array
	  start += stringify(array[index]) + breaks;
      }
      return start + end;
      }

    public static int linSearch(int[] a, int target) {
	for (int index = 0; index < a.length; index++) { // For loop that checks the value of every slot
	    if (a[index] == target) {
		return index;
	    }
	    index += 0;
	}
	return -1; // If the target is not found, returns -1 
    }
    
    public static int linSearchR(int[] a, int target) {
	int length = a.length;
	int[] newArray; // Declaration of a newArray that will be used in the recursion process
	if (a[length - 1] == target) {
	    return length - 1;
	}
	newArray = new int[length - 1]; // The alteration of the parameters
	for (int index = 0; index < (length - 1); index++) {
	    newArray[index] = a[index];
	} 
	if (newArray.length == 0) {  // Base Case
	    return -1;
	}
	return linSearchR(newArray, target);
    }

    public static int freq(int[] a, int target) {
	int freq = 0; // The output; frequency of target in the array a
	for (int index = 0; index < a.length; index++) { // For loop that checks the value of every slot
	    if (a[index] == target) {
		freq += 1;
	    }
	    freq += 0;
	}
	return freq;
    }

    public static int freqRec(int[] a, int target) {
	int freq = 0;
	int length = a.length;
	int[] newArray; // Declaration of a newArray that will be used in the recursion process
	if (a[length - 1] == target) {
	    freq += 1;
	}
	newArray = new int[length - 1]; // The alteration of the parameters
	for (int index = 0; index < (length - 1); index++) {
	    newArray[index] = a[index];
	}
	if (newArray.length == 0) {  // Base Case
	    return freq;
	}
	return linSearchR(newArray, target);
    }
    
    public static void main(String[] args) {
	arrayPop(); // Populates array
	System.out.println(arrayString());
	System.out.println(linSearch(array, 1));
	System.out.println(linSearchR(array, 2));
	System.out.println(freq(array, 3));
	System.out.println(freqRec(array, 4));
	
	System.out.println("================ TestCases  =====================\n");
	System.out.println("System.out.println(arrayString());");
	System.out.println("System.out.println(linSearch(array, 1));");
	System.out.println("System.out.println(linSearchR(array, 2));");
	System.out.println("System.out.println(freq(array, 3));");
	System.out.println("System.out.println(freqRec(array, 4));");
	System.out.println("\n=================================================\n");
	
	System.out.println("================ Outputs 1 =======================\n");
	System.out.println("String Version of array:   [ 8 8 1 2 1 5 10 7 8 1 ]");
	System.out.println("Index of 1 with Iteration:   2");
	System.out.println("Index of 2 with Recursion:   3");
	System.out.println("Frequency of 3 with Iteration:   0");
	System.out.println("Frequency of 4 with Recursion:   -1");
	System.out.println("\n=================================================\n");

	System.out.println("================ Outputs 2 =======================\n");
	System.out.println("String Version of array:   [ 9 10 8 7 10 4 ]");
	System.out.println("Index of 1 with Iteration:   -1");
	System.out.println("Index of 2 with Recursion:   -1");
	System.out.println("Frequency of 3 with Iteration:   0");
	System.out.println("Frequency of 4 with Recursion:   -1");
	System.out.println("\n=================================================\n");
	
	System.out.println("================ Outputs 3 =======================\n");
	System.out.println("String Version of array:   [ 2 2 9 9 5 8 4 4 9 ]");
	System.out.println("Index of 1 with Iteration:   -1");
	System.out.println("Index of 2 with Recursion:  1");
	System.out.println("Frequency of 3 with Iteration:   0");
	System.out.println("Frequency of 4 with Recursion:   7");
	System.out.println("\n=================================================\n");
    }
}
