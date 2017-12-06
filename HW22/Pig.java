/*
  Brian Lin
  APCS1 pd8
  HW22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
  2017-10-24
*/

public class Pig  {
    
    private static final String VOWELS = "aeiou";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    
    public static boolean hasA( String w, String letter ) {
	if ((w != null) && (letter.length() == 1)) {
	    if (w.indexOf(letter) == -1) {
		return false;
	    }
	    return true;
	}
	return true; 
    }//end hasA()
    

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
	if (letter.length() == 1) {
	    if (VOWELS.indexOf(letter) != -1) {
		return true;
	    }
	    return false;
	}
	return false;
    }

    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    
    public static int countVowels( String w ) {
	if (w == null) {
	    return 0;
	}
	int output = 0;
	for (int index = 0; index <= w.length(); index++) {
	    if (index + 1 > w.length()) {
		return output;
	    }
	    else if (isAVowel(w.substring(index, index + 1))) {
		++output;
	    }
	    output += 0;
	}
	return output; 
    }
    

    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/

    public static boolean hasAVowel( String w )  {
	if (w == null) {
	    return false;
	}
	boolean output = false;
	for (int index = 0; index <= VOWELS.length(); index++) {
	    if (index + 1 > VOWELS.length()) {
		return output;
	    }
	    output =  hasA(w, VOWELS.substring(index, index + 1));
	    return output;
	}
	return output;
    }

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/

    public static String allVowels( String w ) {
	if (w == null) {
	    return "None";
	}
	String output = "";
	for (int index = 0; index <= w.length(); index++) {
	    if (index + 1 > w.length()) {
		return output;
	    }
	    if (hasAVowel(w) != true) {
		return "None";
	    }
	    String letter = w.substring(index, index + 1);
	    if (isAVowel(letter)) {
		output += letter;
	    }
	}
	return output;
    }


    public static void main( String[] args ) {
	System.out.println("============ hasA Test Cases =====================");
	System.out.println(hasA("cat", "a")); //Should return true
	System.out.println(hasA("doge", "a")); //Should return false
	System.out.println(hasA("HeyaHeyaHeyi", "i")); //Should return true
	System.out.println("=================================================\n");
    
	System.out.println("============ isAVowel Test Cases =================");
	System.out.println(isAVowel("e")); //Should return true
	System.out.println(isAVowel("y")); //Should return false
	System.out.println(isAVowel("omg")); //Should return false
	System.out.println("=================================================\n");
    
	System.out.println("============ countVowels Test Cases ==============");
	System.out.println(countVowels("cowboy")); //Should return 2
	System.out.println(countVowels("Lelouch")); //Should return 3
	System.out.println(countVowels("Fly")); //Should return 0
	System.out.println("=================================================\n");
    
	System.out.println("============ hasAVowel Test Cases ==============");
	System.out.println(hasAVowel("armstrong")); //Should return true
	System.out.println(hasAVowel("ultraman")); //Should return true
	System.out.println(hasAVowel("gypsy")); //Should return false
	System.out.println("=================================================\n");

	System.out.println("============ allVowels Test Cases ==============");
	System.out.println(allVowels("armstrong")); //Should return ao
	System.out.println(allVowels("ultraman")); //Should return uaa
	System.out.println(allVowels("gypsy")); //Should return None
	System.out.println("=================================================\n");
    }//end main()

}//end class Pig
