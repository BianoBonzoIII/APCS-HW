/*
  Brian Lin 
  APCS1 pd8
  HW36 -- Be Rational 
  2017-11-17
*/

public class Rational {
    private static int num; // Numerator
    private static int den; // Denominator
    private static float value;
    private static int rnum; // Numerator for r
    private static int rden; // Denominator for r
    private static int snum; // Numerator for s 
    private static int sden; // Denominator for s
    
    // Default Constructor 
    public Rational() {
	setNum(0);
	setDen(1);
    }
    
    // Returns a floating point approximation of the number
    public static float floatValue(Rational x) {
        value = ((float) x.getNum()) / ((float) x.getDen());
	return value;
    }

    // Returns the numerator of a Rational object
    public static int getNum() {
	return num;
    }

    // Returns the denominator of a Rational object
    public static int getDen() {
	return den;
    }

    // Sets the value of the numerator to the given input
    public static void setNum(int x) {
	num = x;
    }

    // Sets the value of the denominator to the given input
    public static void setDen(int x) {
	den = x;
    }
    
    // Overloaded Constructor
    public Rational(int num, int den) {
	this();
	if (den == 0) { // If the denominator is 0, Rational is defaulted to 0/1
	    System.out.println("Your Input for the Denominator is Invalid");
	    System.out.println("The number has defaulted to 0/1");
	    setNum(0);
	    setDen(1); 
	}
	else {
	    setNum(num);
	    setDen(den);
	}
    }

    public String toString() { 
	return "================================\n" + 
	    "Your Rational Number is: " + num + "/" + den + 
		"\n================================";
    }

    // Multiplies two Rational objects
    public static void multiply(Rational x) {
	rnum *= x.getNum();
	rden *= x.getDen();
    }

    // Divides two Rational objects
    public static void divide(Rational x) {
	rnum /= x.getNum();
	rden /= x.getDen();
    }
    
    public static void main(String[] args) {
	Rational r = new Rational(2,3); //Stores rational number 2/3
	rnum = getNum();
	rden = getDen();
	Rational s = new Rational(1,2); //Stores rational number 1/2
	snum = getNum();
	sden = getDen();
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(rnum); // Should return 2
	System.out.println(rden); // Should return 6
	System.out.println(snum); // Should return 1
	System.out.println(sden); // Should return 2
	System.out.println(floatValue(s)); // Should return 0.5
    }
}
