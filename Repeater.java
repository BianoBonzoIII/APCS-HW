/*
Brian Lin
APCS1 pd08
HW17 -- Do I repeat myself?
2017-10-16 
*/

public class Repeater {

    // While Loop Fence Function
    public static String fenceW (int numPosts) {
	String wholeFence = "";
	while (numPosts > 1) {
	    wholeFence += "|--";
	    numPosts -= 1;
	    if (numPosts == 1) {
		wholeFence += "|";
		    }
	}
	    return wholeFence;
    }

    // Recursion Fence Function
    public static String fenceR (int numPosts) {
	String wholeFence = "";
	if (numPosts == 1) {
	    return "|";
	}
	return "|--" + fenceW(numPosts - 1);
    }

    // Test Cases
    public static void main(String[] args) {
	String output1 = fenceW(3);
	String output2 = fenceR(6);
	System.out.println(output1);
	System.out.println(output2);
    }
}

