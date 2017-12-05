/* 
   Brian Lin 
   APCS1 pd8
   HW34 -- Arrays of Arrays
   2017-11-16
*/

public class TwoDimArray
{
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    {
	for (int r = 0; r < a.length; r++) { // In each row
	    System.out.println("\n");
	    for (int j = 0; j < a[r].length; j++) { // In each box in the row
		System.out.print(a[r][j] + "   "); 
	    }
	}
    }


    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a )
    {
	for (int[] k : a) { // In each row
	    System.out.println("\n");
	    for (int j : k) { // In each box in the row
		System.out.print(j + "   ");
	    }
	}
    }

    
    //postcond: returns sum of all items in 2D int array a
    public static int sum1( int[][] a )
    {
	int sum = 0; // Output
	for (int r = 0; r < a.length; r++) { // In each row
	    for (int j = 0; j < a[r].length; j++) { // In each box in the row
		sum += a[r][j];
	    }
	}
	return sum;
    }

  
    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {
	int sum = 0; // Output
	for (int r = 0; r < m.length; r++) { // In each row
	    sum += sumRow(r, m);
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
	int sum = 0; // Output
	for (int j = 0; j < a[r].length; j++) { // In each row
	    sum += a[r][j];
	}
	return sum;
    }
   
    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {
	int sum = 0; // Output
	for (int j : m[r]) { // In each row
	    sum += j; 
	}
	return sum;
    }

    
    public static void main( String [] args )
    {
	  int [][] m1 = new int[4][2];
	  int [][] m2 = { {2,4,6}, {3,5,7} };
	  int [][] m3 = { {2}, {4,6}, {1,3,5} };
	  System.out.println("=========== Test print1(m1) ==============");
	  print1(m1);
	  System.out.println("\n=========================================\n");

	  System.out.println("=========== Test print1(m2) ==============");
	  print1(m2);
	  System.out.println("\n=========================================\n");

	  System.out.println("=========== Test print1(m3) ==============");
	  print1(m3);
	  System.out.println("\n=========================================\n");

	  System.out.println("=========== Test print2(m1) ==============");
	  print2(m1);
	  System.out.println("\n=========================================\n");

	  System.out.println("=========== Test print2(m2) ==============");	  
	  print2(m2);
	  System.out.println("\n=========================================\n");
	  
	  System.out.println("=========== Test print2(m3) ==============");	  
	  print2(m3);
	  System.out.println("\n=========================================\n");
	  
	  System.out.print("testing sum1...\n");
	  System.out.println("sum m1 : " + sum1(m1)); // Should return 0
	  System.out.println("sum m2 : " + sum1(m2)); // Should return 27
	  System.out.println("sum m3 : " + sum1(m3)); // Should return 21
	  System.out.print("testing sum2...\n");
	  System.out.println("sum m1 : " + sum2(m1)); // Should return 0
	  System.out.println("sum m2 : " + sum2(m2)); // Should return 27
	  System.out.println("sum m3 : " + sum2(m3)); // Should return 21
    }

}//end class TwoDimArray
