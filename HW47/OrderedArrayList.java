import java.util.ArrayList; 
/*
  Brian Lin
  APCS1 pd8
  HW47 -- ascending
  2017-12-05
*/  

public class OrderedArrayList {
    public static int numGen1() {  // Generates an integer, x, where 1 <= x <= 10
	double number = Math.random(); // Utilizes random() in order to draw a double
	number = number * 10; // Since random() returns doubles that are >= 0.0 and < 1.0, multiplying the
	// double by 10 is necessary in order to draft an integer value                      
	number += 1; // Ensures that array.length can't be 0
	return (int) number; // Typecasts the number so that the return value is an integer
    }

    public static int numGen2() { // Generates an integer, x, where 1 <= x <= 100 for more variety
	return numGen1() * numGen1();
    }

    public static void sorted (ArrayList<Comparable> x) { // Maintains the invariant that ArrayList's elements are sorted
	// Runs when at least 2 meaningful elements are in ArrayList
        for (int i = x.size() - 1; i > 0 && ((x.get(i)).compareTo(x.get(i - 1))) == -1; i--) {
	    Comparable old = x.get(i);
	    x.set(i, x.get(i - 1));
	    x.set(i - 1, old); // Swaps the elements added and the previous element if the elements added is less than the previous
	}
	
    }
    
    public static void populate (ArrayList<Comparable> x) { // Populates ArrayList
	for (int i = 0; i < 23; i++) {
	    int value = numGen2();
	    x.add(numGen2());
	    sorted(x); // Ensures that ArrayList is sorted with every addition
	}
    }

    public static void main(String[] args) {
	System.out.println("=========== Initialization Test ========");
	System.out.println("Initializing foo...");
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	System.out.println("\n======== Size Test =======");
	System.out.println(foo.size());
	System.out.println("\n========== Population Test =======");
	System.out.println("Populating Sorted foo...");
	populate(foo);
	System.out.println("Post-Population:   \n" + foo);
    }
}
