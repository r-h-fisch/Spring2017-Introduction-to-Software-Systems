package Assignment3;

////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 17
//  Homework 3 
//  
//  Due: 9/24/16 11:59 PM
//
//  Author  Rebecca Fisch rhfisch 
//               
//////////////////////////////////////////////////////////////////////////////////
/*
 * Converts a string to lowercase,
 * and displays the string's length
 * as well as a count of letters
 */

/*The program should produce the following outupt once all the bugs are fixed.
 * Output:
 * In all lowercase, the sentence is: "debugging is fun!!!" 
 * The number of CHARACTERS in the string is: 19 
 * The number of LETTERS is: 14
 */
public class LowerCaseString {
	public static void main(String[] args) {

		String str = "Debugging is FUN!!!";// input string that needs to be
											// converted to lowercase

		int numLetters = 0;

		// converts string to lower case and counts number of letters
		int stringLength = str.length(); // changed from length to the length
											// method length() because that is
											// the proper way to get a string
											// length so the error displayed was
											// length cannot be resolved or is
											// not a field
		System.out.print("In all lowercase, the sentence is: \"");

		for (int i = 0; i < stringLength; i++)// used int stringLength to
												// replace length because length
												// was not a variable so the for
												// loop could not be resolved
		{
			char ch = Character.toLowerCase(str.charAt(i));// changed from
															// length to
															// location i
															// because charAt
															// needs and int and
															// there was not
															// variable
															// declaired as
															// length so the
															// function could
															// not be resolved

			System.out.print(ch);
			if (Character.isLetter(ch))// isLetter needed a character arguement
										// to pass the method so the error was
										// that method isLetter(char) in the
										// type Character is not applicable for
										// the arguments ()
				numLetters++;
		}

		// printing number of letters and characters
		System.out.println("\"");
		System.out.println("The number of CHARACTERS in the string is: "
				+ stringLength);
		System.out.println("The number of LETTERS is: " + numLetters);// changed
																		// output
																		// from
																		// stringLength
																		// to
																		// numLetters;
																		// the
																		// error
																		// was
																		// that
																		// it
																		// was
																		// not
																		// outputing
																		// the
																		// desired
																		// string
	}
}