package Assignment1;
////////////////////////////////////////////////////////////////////////////////////
//
//  H212 Fall 16
//  Homework 1
//
//  Due: 9/11/16 11:59 PM  
//
//  Author  Rebecca Fisch rhfisch
//  Last Edited: 1/21/17 
//
//
//  Directions:  provide code for unimplemented methods
//
//               ** The fractions do not need to be in a simplified form **
//               ** without being in simplified form it makes adding and subtracting easier **
//////////////////////////////////////////////////////////////////////////////////

public class A1Fraction {
	// Instance Fields declerations
	private int num;
	private int denom;

	// Constructror - method that initializes class
	// Paramaters
	// num - numerator of fraction
	// denom - denomenator of fraction
	public A1Fraction(int num, int denom) {
		// throw Exception if denominator is 0
		if (denom == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}

		this.num = num;
		this.denom = denom;
	}

	// @return value of numerator
	public int num() {
		return num;
	}

	// @return value of denomenator
	public int denom() {
		return denom;
	}

	// add 2 fractions
	public A1Fraction add(A1Fraction other) {
		int num1 = other.num();
		int denom1 = other.denom();
		int finalnum = 0;
		int finaldenom = 0;
		if (denom1 == denom) {
			finalnum = num1 + num;
			finaldenom = denom;
		} else {
			num = num * denom1;
			num1 = num1 * denom;
			denom = denom1 * denom;
			finalnum = num + num1;
			finaldenom = denom;
		}
		return new A1Fraction(finalnum, finaldenom);
	}

	// subtract two fractions
	public A1Fraction minus(A1Fraction other) {
		int num1 = other.num();
		int denom1 = other.denom();
		int finalnum = 0;
		int finaldenom = 0;
		if (denom1 == denom) {
			finalnum = num1 - num;
			finaldenom = denom;
		} else {
			num = num * denom1;
			num1 = num1 * denom;
			denom = denom1 * denom;
			finalnum = num - num1;
			finaldenom = denom;
		}
		return new A1Fraction(finalnum, finaldenom);
	}

	// multiply two fractions
	public A1Fraction multiply(A1Fraction other) {
		int num1 = other.num();
		int denom1 = other.denom();
		int finalnum = num1 * num;
		int finaldenom = denom1 * denom;
		return new A1Fraction(finalnum, finaldenom);
	}

	// divide two fractions
	public A1Fraction divide(A1Fraction other) {
		int num1 = other.num();
		int denom1 = other.denom();
		int finalnum = num * denom1;
		int finaldenom = denom * num1;
		return new A1Fraction(finalnum, finaldenom);
	}

	// returns decimal value of this fraction
	public double decimalVal() {
		double n = (double) num;
		double d = (double) denom;
		double decvalue = n / d;
		return decvalue;
	}

	// returns a string with numerator / denominator
	public String toString() {
		return num + "/" + denom;
	}

	// Test Client
	public static void main(String[] args) {
		// creating a Fraction object from Class Fraction
		// also known as in Instance
		A1Fraction f1 = new A1Fraction(5, 10);
		A1Fraction f2 = new A1Fraction(1, 3);

		System.out.println("add: " + f1.add(f2).toString());
		System.out.println("minus: " + f1.minus(f2).toString());
		System.out.println("multiply: " + f1.multiply(f2).toString());
		System.out.println("divide: " + f1.divide(f2).toString());
	}
}