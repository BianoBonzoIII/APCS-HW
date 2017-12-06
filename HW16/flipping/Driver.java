/* 
   Brian Lin 
   APCS1 pd08
   HW16 -- Get it While You Can 
   2017-10-14
*/

public class Driver
{
    public static void main( String[] args )
    {
      
	Coin mine = new Coin();
    
	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );

	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);
    
	// x = headsCtr = 10 heads, y = matchCtr = 15 matches
	// ======== Variables for Printing Information ==================
	int headsCtr = 0;
	int xFlipCtr = 0;
	int yFlipCtr = 0;
	int bigFlipCtr = 0;
	int yMatchCtr = 0;
	long bigMatchCtr = 0;
	int yoursHeadsCtr = 0;
	int wayneHeadsCtr = 0;
	// ==============================================================

	// The while loop to calculate the flips it takes to reach x
	while (headsCtr < 10) {
	    yours.flip();
	    wayne.flip();
	    if (yours.getUpFace() == "heads" && wayne.getUpFace() == "heads")  {
		headsCtr++;
		headsCtr++;
		xFlipCtr++;
		xFlipCtr++;
		yoursHeadsCtr++;
		wayneHeadsCtr++;
	    } else if (yours.getUpFace() != "heads" && wayne.getUpFace() == "heads") {
		headsCtr++;
		xFlipCtr++;
		xFlipCtr++;
		wayneHeadsCtr++;
	    } else if (yours.getUpFace() == "heads" && wayne.getUpFace() != "heads") {
		headsCtr++;
		xFlipCtr++;
		xFlipCtr++;
		yoursHeadsCtr++;
	    } else if ((yours.getUpFace() != "heads" && wayne.getUpFace() != "heads")) {
		xFlipCtr++;
		xFlipCtr++;
	    }
	}
	// ===============================================================

    

	// The while loop to calculate the flips it takes to reach y
	while (yMatchCtr < 15) {
	    yours.flip();
	    wayne.flip();
	    if (yours.getUpFace() == wayne.getUpFace())  {
		yMatchCtr++;
		yFlipCtr++;
		yFlipCtr++;
	    } else {
		yFlipCtr++;
		yFlipCtr++;
	    }
	}
	// ===============================================================

	// The while loop to calculate 13000+ matches and divisible by 2001
        
	    while (bigMatchCtr < 14007) {
		yours.flip();
		wayne.flip();
		if (yours.getUpFace() == wayne.getUpFace())  {
		    bigMatchCtr++;
		    bigFlipCtr++;
		    bigFlipCtr++;
		} else {
		    bigFlipCtr++;
		    bigFlipCtr++;
		}
	    }	
	
    
    // =============Information Print Statements==============

    System.out.println("\nx = 10 heads           y = 15 matches");
    System.out.println("\n============= X Heads ==============");
    System.out.print("There were ");
    System.out.print(xFlipCtr);
    System.out.println(" flips until x was reached! Yay!");
    System.out.print("yours landed on heads: ");
    System.out.print(yoursHeadsCtr);
    System.out.println(" times! Yay!");
    System.out.print("wayne landed on heads: ");
    System.out.print(wayneHeadsCtr);
    System.out.println(" times! Yay!");
    System.out.println("====================================");

    System.out.println("\n============= Y Matches ============");
    System.out.print("There were ");
    System.out.print(yFlipCtr);
    System.out.println(" flips until y was reached! Yay!");
    System.out.println("======================================");

    System.out.println("\n=========13000+ Matches/2001========");
    System.out.print("It took ");
    System.out.print(bigFlipCtr);
    System.out.println(" flips to reach 13000 matches and be divisble by my year of birth");
    System.out.println("======================================");
    
    // =======================================================
 
    }

}
