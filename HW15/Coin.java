/*
Brian Lin 
APCS1 pd08
HW15 -- Wayne's World 
2017-10-11
 */

public class Coin {
    
    private double value;
    private String upFace;
    private String name;
    private int flipCtr; 
    private int headsCtr;
    private int tailsCtr;
    private double bias; 

    public double assignValue() {
	if (name == "penny") {
	    value = 0.01;
	} else if (name == "nickel") {
	    value = 0.05;
	} else if (name == "dime") {
	    value = 0.10;
	}  else if (name == "quarter") {
	    value = 0.25;
	}  else if (name == "dollar") {
	    value = 1.00;
	}
	return 0.0;
    }
    
    public Coin() {
	value = 0.0;
	upFace = "heads";
	name = null;
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 1.0;
    }
    
    // denomination means value of $
    public Coin(String denom) {
	value = 0.25;
	name = denom;
    }
    
    public Coin(String denom, String face) {
	value = 0.50;
	name = denom;
	upFace = face;
    }

    public String flip() {
	if ( bias >= 0.5 && bias <= 1.0) {
	    flipCtr += 1;
	    headsCtr += 1;
	    upFace = "heads";
	} else {
	flipCtr += 1;
	tailsCtr += 1;
	upFace = "tails";
	}
	return null;
    }	

    public void toString(String denom, String face) {
	System.out.println(denom + ": -- " + face);
	return null;
}
    
public static void main (String[] args) {

} 
}
