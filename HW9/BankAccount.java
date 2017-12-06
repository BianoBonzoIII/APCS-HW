/*
Team Success/Team 5
APCS1 pd08
HW9 -- CMYM
2017-10-02
*/

public class BankAccount {

    /* Below is the default constructor that takes no arguments. 
       A password must be manually added with the setPass method. 
       Another setName method call must be made to change the AcctHolder name, 
       which wil be set to an empty string at creation. 
    */
    public BankAccount() {
	AcctHolder = "";
	Passwd = "";
	ID = "0366";
	AcctNum = "231494998";
	AcctBal = 0.00;
    }

    /* Below is the convenience constructor that takes 5 inputs as listed below,
       and it will set each respective value to the input value. 
    */
    public BankAccount(String AcctName,String Pass,String Pinn,String AcctNumm,double AcctBall){
	AcctHolder = AcctName;
	Passwd = Pass;
	ID = Pinn;
	AcctNum = AcctNumm;
	AcctBal = AcctBall;
    }

    
    // Below are the 5 core variables in use in this BankAccount class.

    //This is a public string that will hold the name of the account holder
    public String AcctHolder;

    //This is a private string that holds the password.
    private String Passwd;

    //This is a private string that stores the 4 digit pin number.
    private String ID;

    //This is a public string that holds the account number.
    public String AcctNum;

    //This is a private floating point number that holds the account balance.
    private double AcctBal;


    //This is the variable that stores AcctInfo
    private static String info;

    
    /* Below are the methods available for use. 
       ALL METHODS REQUIRE A CORRECT PASSWORD AS THE 
       FIRST INPUT PARAMETER IN ORDER FOR CHANGE TO BE SUCCESSFUL.
     */

    
    /* The method below sets an attribute with String name to 
       the desired value with String. 
 
    public void setAttri(String pass,String StrName,String StrVal) {
	if (pass == Passwd) {
	    StrName = StrVal;
	} else if (pass != Passwd) {
	    System.out.println("You have entered the wrong password.");
	}
    }
    */

    //The method below is for changing the account password.
    private void setPass(String StrVal) {
	    Passwd = StrVal;
	    System.out.println("Password change successful. Your new password is: " + Passwd + "\n"); 
	    output = info;
    }

    //The method below is for changing the account number.
    private void setNum(String StrVal) {
	AcctNum = StrVal;
        System.out.println("Account number change successful. Your new account number is: " + AcctNum + "\n");
	output = info;
    }


    //The method below is for changing the account pin.
    private void setID(String StrVal) {
	    ID = StrVal;
	    System.out.println("Pin change successful. Your new pin number is: " + ID + "\n");
	    output = info;
    }

    //The method below is for changing the the account holder's name.
    private void setName(String StrVal) {
	    AcctHolder= StrVal;
	    System.out.println("Name change successful. Your new account name is: " + AcctHolder + "\n");
	    output = info;
    }
    
    // The method below prints all account info.
    private String acctInfo() {
	    info = "Name: " + AcctHolder + "\n" + "Password: " + Passwd + "\n" + "Pin: " + ID
		+ "\n" + "Account Number: " +  AcctNum + "\n" + "Account Balance: $" +  AcctBal;
	    return info;
    }

    //The method below adds to the balance String dep amount.
    private void acctDep(double dep) {
	AcctBal += dep;
	System.out.println("Account deposit successful. Your balance is now: $" + AcctBal + "\n");
	output = info;
    }

    //The method below withdraws from the account balance min amount.
    private void acctWith(double min) {
	    AcctBal -= min;
	    System.out.println("Account withdrawal successful. Your balance is now: $" + AcctBal + "\n");
	    output = info;
    }
    public static String output;
    public static void main(String[] args) {
	BankAccount test = new BankAccount("Aaron","123456","0987","2314949990",500);
	test.acctDep(500);
	info = test.acctInfo();
	System.out.println(info);
    }

}
