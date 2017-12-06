/*
  Brian Lin 
  APCS1 pd8
  HW37 -- Be Rational 
  2017-11-20
*/

public class Rational {
    private int num;
    private int den;

    // Default Constructor 
    public Rational() {
	num = 0;
	den = 1;
    }

    // Overloaded Constructor
    public Rational(int n, int d) {
	this();
	if (den == 0) {
	    System.out.println("Your Input for the Denominator is Invalid");
	    System.out.println("The number has defaulted to 0/1");
	}
	else {
	    num = n;
	    den = d;
	}
    }

    public String toString() {
		if (this.num == this.den) {
			return "1";
		}
        return num + " / " + den;
    }

    // Returns a floating point approximation of the number
    public double floatValue() {
	return ((double) num) / (den);
    }

    // Multiplies two Rational objects
    public void multiply(Rational x) {
	num = this.num * x.num;
	den = this.den * x.den;
    }

    // Divides two Rational objects
    public void divide(Rational x) {
	num = this.num / x.num;
	den = this.den / x.den;
    }

    // Adds two Rational objects
    public void add(Rational x) {
	den = this.den * x.den;
	num = this.num * x.den;
	int factor = this.den / x.den;
       	x.den *= (this.den / x.den);
	x.num *= factor;
	num += x.num;
    }

    
    // Subtracts two Rational objects
    public void subtract(Rational x) {
	den = this.den * x.den;
	num = this.num * x.den;
	int factor = this.den / x.den;
       	x.den *= (this.den / x.den);
	x.num *= factor;
	num -= x.num;
    }


    // Returns the gcd of the num and den of this Rational. 
    public static int gcd(int num, int den) {
	int tempgcd = 0;
	int counter = 1;
	if (num > den) {
		while (counter <= (num / 2) + 1) { 
			if ((num % counter) == 0 && (den % counter) == 0) {
				tempgcd = counter;
				counter += 1;
			}
			else {
				counter += 1;
		}
		}
	}
	if (den > num) {
		while (counter <= (den / 2) + 1) { 
			if ((num % counter) == 0 && (den % counter) == 0) {
				tempgcd = counter;
				counter += 1;
			}
			else {
				counter += 1;
		}
		}
	}
	return tempgcd; // This occurs when num = den
    }
	

    // Simplifies this Rational. Uses gcd 
    public void reduce() {
		num = this.num / gcd(this.num, this.den);
		den = this.den / gcd(this.num, this.den);
    }

    // Compares the values of two rationals
    public int compareTo(Rational x) {
		if (this.num == x.num && this.den == x.den) {
			return 0;
		}
		else if (this.num > x.num && this.den > x.den) {
			return 1;
		}
		else { 
			return -1;
		}
	}
    
    public static void main(String[] args) {
	Rational r = new Rational( 3, 7 );
	Rational s = new Rational();
	Rational t = new Rational( 5, 5 );

	Rational u = new Rational( 1, 2 );
	Rational v = new Rational( 2, 3 );
	Rational w = new Rational( 8, 12 );

	System.out.println("r: " + r );
	System.out.println("s: " +  s );
	System.out.println("t: " +  t );

	System.out.println( r + " represented as a floating pt num: "
			    + r.floatValue() );

	System.out.print( r + " + " + t + " = ");
	r.add(t);
	System.out.println(r);

	System.out.print( u + " - " + v + " = ");
	u.subtract(v);
	System.out.println(u);
	
	System.out.println(r);
	System.out.println("The GCD of this Rational: " + gcd(r.num, r.den));
	r.reduce();
	System.out.println("Simplified Form of r: " + r);
	System.out.println("Simplified Form of t: " + t);
	System.out.println("Simplified Form of u: " + u);
	System.out.println("Simplified Form of v: " + v);
	System.out.println("Comparison of u and v: " + u.compareTo(v));
    }
}
