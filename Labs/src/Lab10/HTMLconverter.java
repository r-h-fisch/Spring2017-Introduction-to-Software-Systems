package Lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HTMLconverter {

	public HTMLconverter(File myfile) {

		try {// try and catch to get errors that might appear in the code
				// create new File object and pass to the scanner Scanner scan =
				// new
			PrintWriter printWriter = new PrintWriter("C:\\Users\\rebeccafisch\\Developer\\workspace\\Labs\\myfile.html");
			write_header(printWriter);
			Scanner scan = new Scanner(myfile);
			while (scan.hasNextLine()) {
				printWriter.print(scan.nextLine());
				printWriter.print("<br>");
			}
			// converts the text into the body of the HTML code
			
			// writing the footer in the HTML page
			write_footer(printWriter);
			printWriter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// writes that head of the html pages and puts the head title as the first 5
	// Strings given
	public void write_header(PrintWriter w) {
		w.print("<html>" + "<title>" + "This is my java HTML converter, Rebecca" +
				"</title>" + "<body>");
	}

	// writes that footer of the html pages
	public void write_footer(PrintWriter w) {
		w.print("</body>" + "</html>");
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("file.txt");
		HTMLconverter test = new HTMLconverter(file);
		System.out.println(test.toString());
	}
}
