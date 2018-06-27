package Assignment1;
////////////////////////////////////////////////////////////////////////////////////
//
//  H212 Spring 17
//  Homework 1 
//  
//  Due: 9/11/16 11:59 PM
//
//  Author  Rebecca Fisch rhfisch
//  Last Edited: 1/23/17
//               
//////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class A1PrintingAsterisks {
	public static int user() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer number of lines to print that is greater than 6:");
		int userInput = input.nextInt();
		if (userInput < 7) {
			System.out
					.println("This is too small of a number, please enter a number greater than 6");
		} else {
			return userInput;
		}
		return 0;

	}
	/*
	 * This method repeats the asterisks the amount of times the user inputs that is greater than 6
	 */
	public static void PrintingAsterisks(int userInput) {
		if (userInput > 0) {
			int x = 0;
			String stars = "*************************";
			while (x < userInput) {
				stars = "\t" + stars;
				System.out.println(stars);
				x++;
			}
		}
	}

	// test class
	public static void main(String[] args) {
		PrintingAsterisks(user());
		System.out.println("The test case:");
		PrintingAsterisks(7);

	}
}
