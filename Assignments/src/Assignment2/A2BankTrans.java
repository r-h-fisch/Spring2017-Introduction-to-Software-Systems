package Assignment2;
////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 17
//  Assignment 2 Bank Transaction 
//  
//  Due: 2/14/17 11:59 PM
//
//  Author  Rebecca Fisch (rhfisch)
//  Last Edited: 2/9/17
//               
//////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class A2BankTrans {
	private double savings = 0.0;
	private double checking = 0.0;
	private Scanner scan = new Scanner(System.in);
	private boolean run = true;

	public void accountamount() {// user enters account amount
		System.out
				.println("What is your current balance in your savings account?");
		savings = scan.nextDouble();// stores savings value
		while (savings < 0) {
			System.out.println("Invalid amount enter another amount");
			savings = scan.nextDouble();
		}
		System.out
				.println("What is your current balance in your checking account?");
		checking = scan.nextDouble();// stores checking value
		while (checking < 0) {
			System.out.println("Invalid amount enter another amount");
			checking = scan.nextDouble();
		}
	}

	public void runaccount() {// method that keeps the program running unless
								// the user enters exit
		accountamount();
		while (run) {
			System.out.println("Savings balance: $" + savings + " Checking balance: $" + checking);
			transaction();
		}
	}

	public int chooseaccount() {// user is choosing an account which is then
									// passed back to the transaction method
		System.out
				.println("Which account would you like to select? 0:savings 1:checking");
		int at = scan.nextInt();
		int num = 0;
		if (at == 0) {
			num = 0;
		} else if (at == 1) {
			num = 0;
		} else {
			System.out.println("Please enter a valid number: ");
			scan.nextLine();
			at = scan.nextInt();
		}
		return num;
	}

	public void transaction() {// the bank menu and options
		System.out.println("Select a type of transaction: " + '\n'
				+ "1: Withdrawal" + '\n' + "2: Deposit" + '\n' + "3: Balance"
				+ '\n' + "4: Exit");
		int transaction = scan.nextInt();
		switch (transaction) {
		case 1:
			withdrawl(chooseaccount());
			break;
		case 2:
			deposit(chooseaccount());
			break;
		case 3:
			System.out.println(chooseaccount());
			break;
		case 4:
			run = false;
			break;

		default:
			System.out.println("Please enter one of the provided numbers");
		}

	}

	public void withdrawl(int account) {// case 1
		System.out.println("How much would you like to withdrawl?");
		double wd = scan.nextDouble();
		if (account == 0) {
			savings -= wd;
		} else {
			checking -= wd;
		}
	}

	public void deposit(int account) {// case2
		System.out.println("How much would you like to deposit?");
		double dep = scan.nextDouble();
		if (account == 0) {
			savings += dep;
		} else {
			checking += dep;
		}
	}

	public static void main(String[] args) {// main method
		A2BankTrans account = new A2BankTrans();
		account.runaccount();
	}

}
