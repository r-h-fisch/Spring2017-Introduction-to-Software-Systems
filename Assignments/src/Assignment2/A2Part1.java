package Assignment2;
////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 17
//  Assignment 2 Part 1 
//  
//  Due: 2/14/17 11:59 PM
//
//  Author  Rebecca Fisch (rhfisch)
//  Last Edited: 2/9/17
//               
//////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class A2Part1 {
	public static boolean isPalindrome(String s) {
		int length = s.length();
		int x = 0;
		String begin = s.substring(x, x + 1);
		String end = s.substring(length - 1, length);
		boolean result = false;
		for (int i = 0; i <= length / 2; i++) {
			if (begin.equals(end)) {
				x++;
				length--;
				result = true;

			} else
				result = false;
		}
		return result;
	}

	public static boolean isSorted(String s) {
		int end = s.length() - 1;
		int x = 0;
		boolean result = false;
		char first = s.charAt(x);
		char second = s.charAt(x + 1);
		for (int i = 0; i < end; i++) {
			if (first < second) {
				x++;
				result = true;
			} else
				result = false;
		}
		return result;
	}

	public static void border(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == (n - 1)) {
					System.out.print("* ");
				} else if (j == 0 || j == (n - 1)) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}

			}
			System.out.println("");

		}
	}

	public static void T(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					System.out.print("* ");
				} else if (j == (n-1)) {
					System.out.print("* ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {// add test cases

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word I will say if it is a palindrome");
		String word = input.next();
		if (isPalindrome(word) == true) {
			System.out.println("The word is a palindrome");
		} else
			System.out.println("The word is not a palindrome");

		Scanner second = new Scanner(System.in);
		System.out.println("Enter a String and I will say if it is  alphabetical order:");
		String str = second.next();
		if (isSorted(str) == true) {
			System.out.println("The word is in alphabetical order");
		} else
			System.out.println("The word is not in alphabetical order");
		border(4);
		border(7);
		border(11);
		T(4);
		T(7);
		T(11);
	}
}
