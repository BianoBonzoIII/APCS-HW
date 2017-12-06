public class StatsDriver {
    
    public static void main(String[] args) {

	System.out.println("=======Test Cases for Mean======\n");
  
	// Should return 5
	System.out.println(Stats.mean(4, 6));
	
	// Should return 14.5
	System.out.println(Stats.mean(7.0, 22.0));

	// Should return -1
	System.out.println(Stats.mean(-5, 6, -3));

	// Should return -4.5
	System.out.println(Stats.mean(-5.0, -10.0, 1.5));
	
	System.out.println("\n================================\n");
	
	System.out.println("=======Test Cases for Max======\n");
	// Should return 3
	System.out.println(Stats.max(1, 3));
	
	// Should return 3.2
	System.out.println(Stats.max(3.1, 3.2));

	// Should return 1
	System.out.println(Stats.max(1, 1, -1));
	
	// Should return -0.1
	System.out.println(Stats.max(-1, -3, -0.1));

	System.out.println("\n================================\n");

	System.out.println("=======Test Cases for geoMean=====\n");
	
	// Should return 6
	System.out.println(Stats.geoMean(18 , 2));

	// Should return 1
	System.out.println(Stats.geoMean(1, 2, 1));
	
	// Should return root 10
	System.out.println(Stats.geoMean(2.0, 5.0));

	// Should return root 12
	System.out.println(Stats.geoMean(4.0, 0.5, 6.0));

	System.out.println("\n================================\n");

    }
}
