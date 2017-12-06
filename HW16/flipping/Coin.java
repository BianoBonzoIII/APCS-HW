/*
   Brian Lin 
   APCS1 pd08
   HW15 -- Wayne's World 
   2017-10-11
 */

    public class Coin
{

    private double value;
    private String upFace, name;
    private int flipCtr, headsCtr, tailsCtr;
    private double bias = .5;

    public Coin()
    { 
	reset( "heads", 0.5 );
    }

    public Coin( String newName )
    { 
	this();
	name = newName;
	assignValue(newName);
    }

    public Coin( String newName, String nowFace )
    { 
	this(newName);
	upFace = nowFace;
    }

    public String getUpFace() { 
	return upFace;
    }

    public int getFlipCtr() { 
	return flipCtr;
    }

    public double getValue() { 
	return value;
    }

    public int getHeadsCtr() { 
	return headsCtr;
    }

    public int getTailsCtr() { 
	return tailsCtr;
    }
    // ----------------------------

    private double assignValue( String s )
    { 
	if ( name.equals("penny") ) {
	    value = 0.01;
	}
	else if ( name.equals("nickel") ) {
	    value = 0.05;
	}
	else if ( name.equals("dime") ) {
	    value = 0.1;
	}
	else if ( name.equals("quarter") ) {
	    value = 0.25;
	}
	else if ( name.equals("half dollar") ) {
	    value = 0.5;
	}
	else if ( name.equals("dollar") ) {
	    value = 1;
	}
	return value;
    }

    public void reset( String newFace, double newBias )
    { 
	flipCtr = 0;
	tailsCtr = 0;
	headsCtr = 0;
	upFace = newFace;
	bias = newBias;
    }
 
    public String flip()
    {
	double randDbl = Math.random();

	if ( randDbl < bias ) {
	    upFace = "heads";
	    headsCtr += 1;
	}
	else {
	    upFace = "tails";
	    tailsCtr += 1;
	}

	flipCtr += 1;

	return upFace;
    }

    public boolean equals( Coin other )
    { 
	return upFace.equals( other.upFace );
    }

    public String toString()
    {
	return "" + name + " -- " + upFace;
    }

    public static void main(String[] args) {
    }

}
