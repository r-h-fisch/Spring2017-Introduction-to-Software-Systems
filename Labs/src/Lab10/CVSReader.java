package Lab10;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CVSReader {
	File story;
	Scanner scan;
	private ArrayList<String> terms= new ArrayList<String>();
	int totalrows = 0;
	int totalcol = 0;

	public CVSReader(String file) {
		story = new File(file);
		String nextline = "";

		try {// try and catch to get errors that might appear in the code
				// create new File object and pass to the scanner Scanner scan =
				// new
			scan = new Scanner(story); // Scanner(new File(file));
			while (scan.hasNextLine()) {
				nextline = scan.nextLine();
				totalcol = numberOfFields(nextline);
				totalrows++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// number of rows in the file
	public int numberOfRows() {
		return totalrows;
	}

	// number of fields in the file(colums)
	public int numberOfFields(String colum) {
		int totalfields = 0;
		String[] numofcolums = colum.split(",");
		/*
		 * for(int i=0; i< numofcolums.length; i++){//testing if the String has
		 * a double quotes around it if(numofcolums[i].startsWith("\"")&&
		 * numofcolums[i].endsWith("\"")){
		 * 
		 * } }
		 */
		addterms(numofcolums);
		totalfields = numofcolums.length;
		return totalfields;

	}

	
	//adds all the terms into the arraylist to calculate and use them
	//it is given the colum
	public void addterms(String[] colum){
		terms.add(colum[5]);
	}

	// calculates the max of the file's assignments (fields 2-6) for a specific
	// student
	public int maximum() {
		terms.remove(0);
		int max=0;
		for(int i=0; i< terms.size(); i++){
			if (Integer.parseInt(terms.get(i))> max){
				max=Integer.parseInt(terms.get(i));
			}
		}
		return max;
	}
	
	// calculates the min of the file's assignments (fields 2-6) for a specific
		// student
		public int minimmun() {
			terms.remove(0);
			int min=maximum();
			for (int i = 0; i < terms.size(); i++) {
				if(Integer.parseInt(terms.get(i))< min){
					min= Integer.parseInt(terms.get(i));
				}
			}
			return min;

		}
	// calculates the average of the students assignments (fields 2-6) depending
	// on the colum number given
	public double averageassign() {
		terms.remove(0);
		double average=0;
		for(int i=0; i< terms.size(); i++){
			average += Integer.parseInt(terms.get(i));
		}
		average/= 6;
		return average;
	}

	public String toString() {
		return "Rows:" + numberOfRows() + '\n' + "Fields: " + totalcol+
				//'\n'+ terms.toString()+ 
				'\n'+ "The average of Assignment for the students is: "//average of the colum
						+ averageassign()+
						'\n'+ "The maximum grade earned in Assignment 5 is: "//max of the colum
						+ maximum() +
						'\n'+ "The minimum grade earned in Assignment 5 is: "
						+ minimmun();
	}

	public static void main(String[] args) {

		CVSReader test = new CVSReader("sample.csv");
		System.out.println(test.toString());
	}

}