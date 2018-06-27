package Lab6;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Lab6FrequencyCounter {
	private ArrayList<String> newword = new ArrayList<String>();
	private ArrayList<Lab6Frequency> freq = new ArrayList<Lab6Frequency>();
	private int totalwords = 0;
	private int totallines = 0;
	private String story = "tinyTale.txt";

	public Lab6FrequencyCounter(String file) {
		File story = new File(file);
		String nextline = "";
		try {
			// create new File object and pass to the scanner Scanner scan = new
			Scanner scan = new Scanner(story); // Scanner(new File(file));
			while (scan.hasNextLine()) {
				nextline = scan.nextLine();
				String[] singleline = nextline.split(" ");
				for (String w : singleline) {
					totalwords++;
				}
				freqwords(singleline);
				totallines++;
			}

			// Gather all the data you need in the try block, and store in
			// instance // fields
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void distinctword(String[] wordsonline){ for (int i=0;
	 * i<(wordsonline.length);i++){ if(!newword.contains(wordsonline[i])){
	 * newword.add(wordsonline[i]); } } }
	 */

	public void freqwords(String[] wordsonline) {
		for (int i = 0; i < (wordsonline.length); i++) {
			if (!newword.contains(wordsonline[i])) {
				newword.add(wordsonline[i]);
				Lab6Frequency f = new Lab6Frequency(wordsonline[i]);
				freq.add(f);
			} else {

				freq.get(getIndex(wordsonline[i])).setFreq();
			}
		}
	}

	public int getIndex(String word) {
		int index = 0;
		while (index < freq.size()) {
			if (freq.get(index).getWord().equals(word)) {
				return index;
			} else {
				index++;
			}
		}
		return index;
	}

	public String outcomes() {
		String o = "";
		for (int i = 0; i < freq.size(); i++) {
			o += freq.get(i).getWord() + ": " + freq.get(i).getFreq() + '\n';
		}
		String outcome = "Total words:" + totalwords + " Total lines:"+ 
				totallines+'\n';
		return outcome + o;

	}

	public static void main(String[] args) {
		Lab6FrequencyCounter test = new Lab6FrequencyCounter("tinyTale.txt");
		System.out.println(test.outcomes());
	}

}
