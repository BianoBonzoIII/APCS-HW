/*
  Joan Chirinos
  APCS1 pd8
  HW24 -- Imetay Otay Ineshay
  2017-10-27
*/

//!!!!!!!SEND TO sam.ramos03@gmail.com and blin5@stuy.edu


/*

  To-do:
  1. Implement full sentence (with spaces and stuff) pig-ification
  2. Write better comments



  Notes:




  Expansions:
  1. Implemented punctuation preservation
  2. Implemented caps preservation
  3.
*/


/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

//importing scanner class from java.util
import java.util.Scanner;

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: idk tbh
    private static final String VOWELS = "aeiou";
    private static final String PUNCT = ".!?,";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	return w.indexOf(letter) != -1;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	letter = letter.toLowerCase();
	return hasA(VOWELS, letter);
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	int vowelCounter = 0;
	w = w.toLowerCase();
	for (int i = 0; i < w.length(); i++) {
	    if (isAVowel(w.substring(i, i + 1))) vowelCounter++;
	}
	return vowelCounter;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	return countVowels(w) > 0;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	String retStr = "";
	if (w != null) {
	    for (int i = 0; i < w.length(); i++) {
		String temp = w.substring(i, i + 1);
		if (isAVowel(temp)) retStr += temp;
	    }
	}
	return retStr;
    }

    //if w doesn't have a vowel, return "";
    //otherwise, iterate through the string's characters and if the character
    //is a vowel, return it
    public static String firstVowel(String w) {
	if (!(hasAVowel(w))) return "";
	for (int i = 0; i < w.length(); i++) {
	    if (isAVowel(w.substring(i, i + 1))) return w.substring(i, i + 1);
	}
	return "";
    }

    //returns whether or not the first char of String w is a vowel
    public static boolean beginsWithVowel(String w) {
	if (firstVowel(w) == "") return false;
	return (w.indexOf(firstVowel(w)) == 0);
    }


    //Returns the end punctuation of String w (!, ., and ?) in order
    public static String retPunctuation(String w) {
	String pRet = "";
	if (w.length() == 0) return pRet;
	if (w.length() == 1 && hasA(PUNCT, w)) return w;
	else if (w.length() == 1 && !(hasA(PUNCT, w))) return pRet;
	for (int i = w.length(); i >= 1; i--) {
	    if (hasA(PUNCT, w.substring(i - 1, i)))
		pRet = w.substring(i - 1, i) + pRet;
	    else i = -1;
	}
	return pRet;
    }

    //Removes the end punctuation of String w
    public static String rmPunctuation(String w) {
	int pLen = retPunctuation(w).length();
	return w.substring(0, w.length() - pLen);
    }

    //Returns the index of y + consonant
    public static int yConsIndex(String w) {
	for (int i = 0; i < w.length() - 1; i++) {
	    if (w.substring(i, i + 1).equals("y") && !(isAVowel(w.substring(i + 1, i + 2)))) {
	        return i;
	    }
	}
	return -1;
    }

    //One word translator
    /***========== RULES ==========
     * 1. If the word begins with a vowel, append "way"
     * 2. If the word begins with "qu", move to end and append "ay"
     * 3. If the word doesn't have a vowel or a "y" append "ay"
     * 4. If the word doesn't have a vowel and has a "y<consonant>" OR
     *    the "y<consonant>" comes before the first vowel, append every char
     *    up till the "y" (exclusive) to the rest of the word, then append
     *    "ay"
     * 5. If the vowel comes before the "y<consonant>", do the same as step 4
     *    except you go up till the vowel rather than the "y"
     *
     * NOTES:
     * - If w is capitalized, the end String will be capitalized
     * - Capitalization and punctuation in the middle of the word will
     *   be preserved
     * - End punctuation will be appended to the final word
     ***/
    
    public static String engToPigBase(String w) {
	if (w.equals(" ") || w.equals("")) {return "";}
	boolean upper = !(w.substring(0, 1).toLowerCase().equals(w.substring(0, 1)));
	if (upper) {
	    w = w.substring(0, 1).toLowerCase() + w.substring(1);
	}
	String full = "";
	String punct = retPunctuation(w);
	w = rmPunctuation(w);
	if (beginsWithVowel(w)) {full = w + "way" + punct;}
	else if (w.indexOf("qu") == 0) {full = w.substring(2) + "quay" + punct;}
	else if (!(hasAVowel(w)) && yConsIndex(w) == -1) {full = w + "ay" + punct;}
	else if ((!(hasAVowel(w)) && yConsIndex(w) > -1) || (hasAVowel(w) && yConsIndex(w) < w.indexOf(firstVowel(w)) && yConsIndex(w) != -1)) {
	    String start = w.substring(0, yConsIndex(w));
	    String end = w.substring(yConsIndex(w));
	    full =  end + start + "ay" + punct;
	}
	else {
	    String start = w.substring(0, w.indexOf(firstVowel(w)));
	    String end = w.substring(w.indexOf(firstVowel(w)));
	    full = end + start + "ay" + punct;
	}
	
	if (!(upper))
	    return full.substring(0, 1).toLowerCase() + full.substring(1);
	else {
	    return full.substring(0, 1).toUpperCase() + full.substring(1);
	}
    }

    public static String engToPig(String w) {
	if (w.equals(retPunctuation(w))) return w;
	String retStr = "";
	String word = "";
	for (int i = 0; i < w.length(); i++) {
	    if (!(w.substring(i, i + 1).equals(" "))) {
		word += w.substring(i, i + 1);
	    }
	    else {
		retStr += engToPigBase(word) + " ";
		word = "";
	    }
	}
	retStr += engToPigBase(word);
	return retStr;
    }
    
    //main method
    public static void main( String[] args ) 
    {


	//This main method is a basic test of the other methods
	/*
	
	sop("========================================");
	sop("Testing hasA: Should return true, true, false");
	sop(hasA("hello", "e")); //true
	sop(hasA("henlo", "l")); //true
	sop(hasA("help me pls", "z")); //false
	sop("\n");

	sop("========================================");
	sop("Testing isAVowel: Should return true, true, false, false");
	sop(isAVowel("e"));
	sop(isAVowel("a"));
	sop(isAVowel("t"));
	sop(isAVowel("y"));
	sop("\n");

	sop("========================================");
	sop("Testing countVowels: should return 1, 2, 16, 0");
	sop(countVowels("a")); //1
	sop(countVowels("ego")); //2
	sop(countVowels("elephants are pretty cool, but turtles are cooler xD")); //16
	sop(countVowels("Sly lynx: fly by my crwth.....,,,,,,,!!!????@#$%^&*():;{}][1234567890<>/")); //0
	sop("\n");

	sop("========================================");
	sop("Testing hasAVowel: should return true, true, false, false");
	sop(hasAVowel("ears"));
	sop(hasAVowel("elephant toes xD"));
	sop(hasAVowel("rhythms"));
	sop(hasAVowel("!"));
	sop("\n");
	
	sop("========================================");
	sop("Testing allVowels: should return aeouieiaao, io, iooaoao, and \"\"");
	sop(allVowels("why are you like this a-aron")); //aeouieiaao
	sop(allVowels("hi mr brown!!!")); //io
	sop(allVowels("this dont got any of da 2nd vowl xDDD")); //iooaoao
	sop(allVowels("2 + 2 = 4, - 1 = 3, qwk mths")); //<empty string>

	sop("========================================");
	sop("Testing firstVowel: should return a, e, \"\"");
	sop(firstVowel("stagnate"));
	sop(firstVowel("steep"));
	sop(firstVowel("rhythms xD"));
	sop("\n");
	
	sop("========================================");
	sop("Testing retPunctuation: should return \"\", \"!!\", and \".?\"");
	sop(retPunctuation("Henlo"));
	sop(retPunctuation("henloooo!!"));
	sop(retPunctuation("anyboodyHome.?"));

	sop("========================================");
	sop("Testing rmPunctuation: should return Henlo, henloooo, and ohNoes");
	sop(rmPunctuation("Henlo"));
	sop(rmPunctuation("henloooo!!"));
	sop(rmPunctuation("ohNoes!"));

	sop("========================================");
	sop("Testing engToPig: should return ethay, Onway, ythmrhay, enlo-senpaihay!!!!, and Orkpls_way?");
	sop(engToPig("the"));
	sop(engToPig("Won"));
	sop(engToPig("rhythm"));
	sop(engToPig("henlo-senpai!!!!"));
	sop(engToPig("Pls_work?"));
	sop(engToPig("This should word. Look, it does!"));

*/

	//This section is used to translate multi-sentence bodies of text,
	//like HuckleBerry Finn. It adds a new line once it's printed >=
	//30 characters, though this can be easily edited

	/*
	Scanner sc = new Scanner(System.in);
	int charCounter = 0;
	while (sc.hasNext()) {
	    String word = sc.next();
	    if (charCounter < 30) {
		System.out.print(engToPig(word) + " ");
		charCounter += word.length();
	    }
	    else {
		System.out.print(engToPig(word) + "\n");
		charCounter = 0;
	    }
	}
	*/

	//This section serves to print out each pig-latin-ified word
	//individually

	
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    sop(engToPig(sc.next()));
	}



    }//end main()


    //SOP methods

    public static void sop(String x) {
	System.out.println(x);
    }
    public static void sop(int x) {
	System.out.println(x);
    }
    public static void sop(double x) {
	System.out.println(x);
    }
    public static void sop(boolean x) {
	System.out.println(x);
    }
}//end class Pig
