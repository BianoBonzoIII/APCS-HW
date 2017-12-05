// Team Brownies / Team 5
// APCS1 pd8
// HW10 -- Mo Money Mo Problems
// 2017-10-03 

public class BankAccount
{
  //instance variables
  private static String name;
  private static String passwd;
  private static int pin;
  private static int acctNum;
  private static double balance;


  //mutators
  public static String setName( String newName )
  {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public static String setPasswd( String newPasswd )
  {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public static int setPin( int newPin )
  {
      if (newPin < 1000 || newPin > 9998) {
	  System.out.print("Your PIN number was out of range.");
	  System.out.println("Your PIN number has been set to 9999");
	  pin = 9999;
	  return pin;
      } else {
    int oldPin = pin;
    pin = newPin;
      }
    return newPin;
  }
  public static int setAcctNum( int newAcctNum )
  {
      if (newAcctNum <= 100000000 || newAcctNum >= 999999998) {
	  System.out.print("Your account number was out of range.");
	  System.out.println("Your account number has been set to 999999999");
	  acctNum = 999999999;
	  return acctNum;
      } else {
    int oldAcctNum = acctNum;
    acctNum = newAcctNum;
      }
    return newAcctNum;
  }

  public static double setBalance( double newBalance )
  {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }

  public static boolean deposit( double depositAmount ) {
    balance = balance + depositAmount;
    return true;
  }

  public static boolean withdraw( double withdrawAmount ) {
      if (balance - withdrawAmount < 0) {
	  System.out.println("Error: withdrawAmount exceeds the balance");
	  return false;
	      } 
    balance = balance - withdrawAmount;
    return true;
  }

    public boolean authenticate(int newAcctNum, String newPasswd ) {
	if (newAcctNum != acctNum || newPasswd != passwd) {
	    return false;
	}
	return true;
    }
  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
      setName("Brad Pitt");
      System.out.println(name);
      setPasswd("Thor");
      System.out.println(passwd);
      setPin(6789);
      System.out.println(pin);
      setAcctNum(123456789);
      System.out.println(acctNum);
      setBalance(5000000.00);
      System.out.println(balance);
      deposit(25.00);
      System.out.println(balance);
      withdraw(20.00);
      System.out.println(balance);
      setPin(10000);
      System.out.println(pin);
      setAcctNum(1234567890);
      System.out.println(acctNum);
      withdraw(99999999.00);
  }

}

/* Print statements in terminal look like this:
Brad Pitt
Thor
6789
123456789
5000000.0
5000025.0
5000005.0
Your PIN number was out of range.Your PIN number has been set to 9999
9999
Your account number was out of range.Your account number has been set to 999999999
999999999
Error: withdrawAmount exceeds the balance
*/
