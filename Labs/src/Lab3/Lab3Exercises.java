////////////////////////////////////////////////////////////////////////////////////
//
//  H212 Spring 17
//  Lab 3 
//  
//  Due: 1/31/17 11:59 PM
//
//  Author  Rebecca Fisch rhfisch
//  Last Edited: 1/26/17
//               
//////////////////////////////////////////////////////////////////////////////////
package Lab3;
import java.util.Scanner;

public class Lab3Exercises {

	public static int fib() {
		Scanner input = new Scanner(System.in);
		System.out.println("1) Which int term of the Finonacci sequence do you wish to see?");
		int fibnum = input.nextInt();
		int x = 1;
		int num = 0;
		int fib0 = 0;
		int fib1 = 1;
		while (x < fibnum) {
			num = fib0 + fib1;
			fib0 = fib1;
			fib1 = num;
			x++;
		}
		return num;
	}

	public static String numbers() {
		Scanner input = new Scanner(System.in);
		System.out.println("2) Enter a number: ");
		int num = input.nextInt();
		int min = 100;
		int max = 0;
		int sum = num;
		while (input.hasNextInt()) {
			num = input.nextInt();
			sum = sum + num;
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		return "The min is: " + min + '\n' + "The max is: " + max + '\n'
				+ "The total is: " + sum;
	}

	public static String grade() {
		Scanner input = new Scanner(System.in);
		System.out.println("3) What is your number grade");
		double grade = input.nextDouble();
		String finalgrade = "";
		if (grade > 89.4) {
			finalgrade = "Your grade is an A";
		} else if (grade > 79.4 && grade <= 89.4) {
			finalgrade = "Your grade is a B";
		} else if (grade > 69.4 && grade <= 79.4) {
			finalgrade = "Your grade is a C";
		} else if (grade > 59.4 && grade <= 69.4) {
			finalgrade = "Your grade is a D";
		} else {
			finalgrade = "Your grade is a F";
		}

		return finalgrade;
	}

	public static String intToBinary(int n) {
		String binarylist = "";
		while (n > 0) {
			binarylist = binarylist + Integer.toString(n % 2);
			n = n / 2;
		}
		return " in binary is: "
				+ new StringBuilder(binarylist).reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(fib());
		System.out.println(numbers());
		System.out.println(grade());
		System.out.println(" 4) "+ 4+ intToBinary(4));
		System.out.println(156+ intToBinary(156));
	}
}
/*
 * Questions: 
 * i. Give the type and value for each of the following expressions:
 * 	1) (1 + 2.236)/2 = Double 1.618 
 * 	2) 1 + 2 + 3 + 4.0 = Double 10.0 
 * 	3) 4.1 >= 40 = Boolean False 
 * 	4) 1 + 2 + �3�= String "33" 
 * ii.Give the value printed by each
 * of the following code fragments: 
 * 	1)3.00009155413138 
 * 	2)999000 
 * 	3)10000
 */

