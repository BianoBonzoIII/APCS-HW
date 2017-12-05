/*
  Team Basement Dwellers: Brian, George, Kendrick
  APCS1 - pd8
  2017-11-15
*/
public class Passer{
    
    public static void main(String[] args){
	int yum = 10;
	System.out.println("=================================================");
	System.out.println("Current: " + yum + "\n");
	System.out.println("Run Method: " + alterInt(yum) + "\n");
	System.out.println("After: " + yum + "\n");
        System.out.println("=================================================");
	String foo = "hi";
	System.out.println("Current: " + foo + "\n");
	System.out.println("Run Method: " + alterStr(foo) + "\n");
	System.out.println("After: " + foo + "\n");
	
    }

    public static int alterInt(int x) {//makes a separate int equal to the input modified by an operation
	int a = x % 2;
	return a;
    }
    public static String alterStr(String x) {//makes a separate String that is the original Sting concatentated w/ another String
	String a = x + "ya";
	return a;
    }
}
