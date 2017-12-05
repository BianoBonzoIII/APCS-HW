/* 
Brian Lin 
APCS1 pd8
HW#06 -- On BigSib Individuality and the Elimination of Radio Fuzz
2017-09-25
*/

public class BigSib {
private static String helloMsg;

public static String setHelloMsg(String newMsg) {
helloMsg = newMsg + " ";
return helloMsg;
    }
    
public static String greet(String word) {
helloMsg += word;
helloMsg += "\nSalutations Dr. Spaceman";
helloMsg += "\nHey ya Kong Fooety";
helloMsg += "\nSup mom";
return helloMsg; 
}

public static void main (String[] args) {
    }
}
