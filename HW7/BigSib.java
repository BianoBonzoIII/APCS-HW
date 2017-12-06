/* 
   Brian Lin 
   APCS1 pd8
   HW#07 -- On the Origins of a BigSib
   2017-09-26
*/

public class BigSib {
    private static String helloMsg;
    private static String tracyMsg;              
    private static String grizzMsg;
    private static String dotComMsg;

    public static String setHelloMsg(String newMsg) {
	helloMsg = newMsg +  " ";
	return helloMsg;
    }
    
    public static String greet(String word) {
	helloMsg += word;
	return helloMsg;
    }

    public BigSib(String word) {
        tracyMsg = setHelloMsg(word);
	grizzMsg = setHelloMsg(word);
	dotComMsg = setHelloMsg(word);
    }

    public static void main (String[] args) {
	BigSib richard = new BigSib("Word up");
	BigSib tracy = new BigSib("Salutations");
        BigSib grizz = new BigSib("Hey ya");
        BigSib dotCom = new BigSib("Sup");
	System.out.println(tracy);
    }
}
