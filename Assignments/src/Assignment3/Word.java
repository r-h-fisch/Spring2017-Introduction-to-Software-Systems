package Assignment3;

////////////////////////////////////////////////////////////////////////////////////
//
//H212 Spring 17
//Homework 3 
//
//Due: 9/24/16 11:59 PM
//
//Author  Rebecca Fisch rhfisch
//////////////////////////////////////////////////////////////////////////////////
/*
 * Once all the bugs are fixed the program should 
 * generate the following output for inputs "mississippi" and "Trending"
 * output:
 * First repeating char in mississippi is: i 
 * First repeating char in Trending is: n 
 */
public class Word {
	/*
	 * Constructs an analyzer for a given word.
	 * 
	 * @param aWord the word to be analyzed
	 */
	private String word;// better to define word before using it

	public Word(String _word) {
		word = _word;
	}

	/*
	 * Gets the first repeating character. For example, given "hello" as input
	 * the function returns "l". The function returns 0 if no characters are
	 * repeating
	 */
	public char firstRepeatCharacter() {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (find(ch, i))
				return ch;
		}
		return 0;
	}

	/*
	 * returns true if input character 'c' is equal to the char at position
	 * 'pos' else returns false
	 */

	private boolean find(char c, int pos)// error, char c will always be equal
											// to int pos
	{
		boolean returnvalue = true;
		if (word.charAt(pos + 1) == c
				|| (word.substring(pos + 1).indexOf(c) != -1)) {
			returnvalue = true;
		} else {
			returnvalue = false;

		}

		return returnvalue;
	}

	public static void main(String args[]) {
		// error, not the right way to test if words is working or assign
		// variables to words
		String[] words = { "mississippi", "Trending" };
		Word test1 = new Word(words[0]);
		Word test2 = new Word(words[1]);

		// find the first repeating char for the two words in the array
		char ch = test1.firstRepeatCharacter();
		System.out
				.println("First repeating char in " + words[0] + " is: " + ch); // error,
																				// only
																				// need
																				// words[x]
																				// to
																				// call
																				// a
																				// char

		char ch2 = test2.firstRepeatCharacter();
		System.out.println("First repeating char in " + words[1] + " is: "
				+ ch2);// error, same as above only need words[x] to call a char
	}
}