/*
  Brian Lin
  APCS1 pd8
  HW23 -- Etterbay Odingcay Oughthray Ollaborationcay ...Ippyay.
  2017-10-25
*/

// =============================================================================
/* TO-DO LIST:
   1. Incorporate capitalization into the engToPig() method
      How: Use String.toLowerCase() and String.toUpperCase() but ensure the word 
           preserves its original capitalization. Possibly write a bunch of small
           helper functions for this
   2. Include special consonants like "th", "qu", "ph", "gn", "kn", "wr"
      How: Use final and write a string listing all of these. The index will be 
           in multiples of 2
   3. Preserve Grammar such as commas and question/exclamation marks
      How: Use hasNext() and next() in order to print each word in a sentence
           and isolate the word with the pronunciation
 */
// =============================================================================

public class Pig  {
    
    private static final String VOWELS = "aeiou";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    
    public static boolean hasA( String w, String letter ) {
	return w.indexOf(letter) != -1;
    }//end hasA()
    

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
        return hasA(VOWELS, letter);
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
	int letteramt = countVowels(w);
	if (letteramt > 0) {
	    return true;
	}
	return false;
    }

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    
    public static String allVowels( String w ) {
	String retStr = "";
	if (w != null) {
	    for (int index = 0; index <= w.length(); index++) {
		if (index + 1 > w.length()) {
		    return retStr; 
		} 
		String temp = w.substring(index, index + 1);
		if (isAVowel(temp)) retStr += temp;
	    }
	}
	return retStr;
    }
  
    //pre: w != null
    //post: firstVowel("") --> ""
    //      firstVowel("zzz") --> ""
    //      firstVowel("meatball") --> "e"
    public static String firstVowel(String w) {
	if (hasAVowel(w)) {
	    if (w.length() == 1 && isAVowel(w)) { 
		return w;
	    }
	    String vowels = allVowels(w);
	    return vowels.substring(0,1);
	}
	return "";
    }
 
    //pre: w != null and w.length() > 0
    //post: beginsWithVowel("apple")  --> true
    //      beginsWithVowel("strong") --> false
    public static boolean beginsWithVowel(String w) {
	if (hasAVowel(w)) {
	    String letter = w.substring(0,1);
	    return isAVowel(letter);
	}
	return false;
    }

    //pre: w.length() > 0
    //post: engToPig("apple")  --> "appleway"
    //      engToPig("strong") --> "ongstray"
    //      engToPig("java")   --> "avajay"
    public static String engToPig(String w) {
	if (beginsWithVowel(w)) {
	    return w + "way";
	}
	int index = w.indexOf(firstVowel(w));
	String consonant = w.substring(0, index);
	String ending = w.substring(index);
	return ending + consonant + "ay";
    }

    public static void main(String[] args) {
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

	System.out.println("============ firstVowel Test Cases ==============");
	System.out.println(firstVowel("")); //Should return ""
	System.out.println(firstVowel("yyy")); //Should return ""
	System.out.println(firstVowel("a")); //Should return "a"
	System.out.println(firstVowel("miss")); //Should return "i"
	System.out.println("=================================================\n");

	System.out.println("============ beginsWithVowel Test Cases ==============");
	System.out.println(beginsWithVowel("orange")); //Should return true
	System.out.println(beginsWithVowel("curly")); //Should return false
	System.out.println(beginsWithVowel("wry")); //Should return false
	System.out.println(beginsWithVowel("a")); //Should return true
	System.out.println("=================================================\n");

	System.out.println("============ engToPig Test Cases ==============");
	System.out.println(engToPig("grapefruit")); //Should return apefruitgray
	System.out.println(engToPig("kink")); //Should return inkkay 
	System.out.println(engToPig("awesome")); //Should return awesomeway
	System.out.println(engToPig("a")); //Should return away
	System.out.println("=================================================\n");
    }//end main()

}//end class Pig
