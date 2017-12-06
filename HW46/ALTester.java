import java.util.ArrayList; 
/*
  Brian Lin
  APCS1 pd8
  HW46 -- AI<B> Sorted
  2017-12-04
*/  

public class ALTester {
    public static int numGen1() {  // Generates a number, x, where 1 <= x <= 10
	double number = Math.random(); // Utilizes random() in order to draw a double
	number = number * 10; // Since random() returns doubles that are >= 0.0 and < 1.0, multiplying the
	// double by 10 is necessary in order to draft an integer value                      
	number += 1; // Ensures that array.length can't be 0
	return (int) number; // Typecasts the number so that the return value is an integer
    }

    public static int numGen2() {
	return numGen1() * numGen1();
    }
    public static void populate (ArrayList<Comparable> x) {
	for (int i = 0; i < 23; i++) {
	    x.add(numGen2());
	}
    }

    public static boolean sort (ArrayList<Comparable> x) {
	int i = 0;
	boolean output = true;
	while (i < x.size() - 1) {
	    if ( (x.get(i)).compareTo(x.get(i + 1)) == -1) {
		output = true;
	    }
	    else {
		output = false;
		return output;
	    }
	    i++;
	}
	return output;
    }
    
    public static void main(String[] args) {
	System.out.println("=========== Initialization Test ========");
	System.out.println("Initializing foo...");
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	System.out.println("\n======== Size Test =======");
	System.out.println(foo.size());
	System.out.println("\n========== Population Test =======");
	System.out.println("Populating foo...");
	populate(foo);
	System.out.println("Post-Population:   \n" + foo);
	System.out.println("\n========== Sort Test =======");
	System.out.println("Is foo Sorted: " + sort(foo));
    }
}
