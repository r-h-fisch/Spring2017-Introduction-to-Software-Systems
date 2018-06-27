package Assignment3;

import java.util.Scanner;

public class ZIPcodetobar {
	public String zip0;
	public String zip1;
	public String zip2;
	public String zip3;
	public String zip4;
	public String zip5;
	public String zip6;
	public String zip7;
	public String zip8;
	public String zip9;
	public static String zip = "";

	public ZIPcodetobar() {
		zip0 = "||:::";
		zip1 = ":::||";
		zip2 = "::|:|";
		zip3 = "::||:";
		zip4 = ":|::|";
		zip5 = ":|:|:";
		zip6 = ":||::";
		zip7 = "|:::|";
		zip8 = "|::|:";
		zip9 = "|:|::";

	}

	public void getzip() {
		Scanner scan = new Scanner(System.in);
		zip = scan.next();
		while (zip.length() != 5) {
			System.out.println("Invalid input, enter another zipcode");
			zip = scan.next();
			if (Integer.parseInt(zip) < 1001 || Integer.parseInt(zip) > 99950) {
				System.out.println("Invalid input, enter another zipcode");
				zip = scan.next();
			} else {
				zip = scan.next();
			}
		}
	}

	public int sumzip() {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += Integer.parseInt(zip.substring(i, i + 1));
		}
		return sum;

	}

	public String remainder() {
		int r = 0;
		String remain = "";
		r = 10 - (sumzip() % 10);
		remain = barcodeassign(r);
		return remain;
	}

	public String fullzip() {
		System.out.println("Please enter the zip code:");
		getzip();
		String finalbar = "";
		String nums = "";
		for (int i = 0; i < 5; i++) {
			nums += barcodeassign(Integer.parseInt(zip.substring(i, i + 1)));
		}
		finalbar = "|" + nums + remainder() + "|";
		return finalbar;
	}

	public String barcodeassign(int x) {
		String barstring = "";
		switch (x) {
		case 0:
			barstring = zip0;
			break;
		case 1:
			barstring = zip1;
			break;
		case 2:
			barstring = zip2;
			break;
		case 3:
			barstring = zip3;
			break;
		case 4:
			barstring = zip4;
			break;
		case 5:
			barstring = zip5;
			break;
		case 6:
			barstring = zip6;
			break;
		case 7:
			barstring = zip7;
			break;
		case 8:
			barstring = zip8;
			break;
		case 9:
			barstring = zip9;
			break;

		}
		return barstring;

	}

	public String getbar() {
		System.out.println("Enter the barcode and I will tell you the zipcode:");
		Scanner scan2 = new Scanner(System.in);
		String input = scan2.next();
		while (input.length() != 32) {
			System.out.println("Invalid input length please enter another barcode");
			input = scan2.next();
		}
		for (int i = 0; i < 32; i++) {
			if (input.charAt(i) == '|' || input.charAt(i) == ':') {
			} else {
				System.out
						.println("Invalid input please enter another barcode");
				input = scan2.next();
				break;
			}
		}
		return (input.substring(1, 26));
	}
	//|::|:|||:::|::|::|:|::|::|:::|||
	public String breakstring() {
		String middle = getbar();
		int endnum = 0;
		String zipcode = "";
		for (int i = 0; i < middle.length(); i += 5) {
			endnum = numassign(middle.substring(i, i + 5));
			zipcode += endnum;

		}
		return zipcode;
	}

	public int numassign(String bar) {
		int num = 0;
		if (bar.equals("||:::")) {
			return num = 0;
		}
		if (bar.charAt(0) == '|') {
			num += 7;
		}
		if (bar.charAt(1) == '|') {
			num += 4;
		}
		if (bar.charAt(2) == '|') {
			num += 2;
		}
		if (bar.charAt(3) == '|') {
			num += 1;
		}
		return num;
	}

	public static void main(String[] args) {
		ZIPcodetobar test = new ZIPcodetobar();
		//System.out.println(test.fullzip());
		System.out.println(test.breakstring());
	}

}
