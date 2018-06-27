////////////////////////////////////////////////////////////////////////////////////
//
//  H212 Spring 17
//  Lab 4
//  
//  Author  Rebecca Fisch rhfisch
//  Last Edited: 2/2/17
//               
//////////////////////////////////////////////////////////////////////////////////
package Lab4;
import java.util.Scanner;

public class Lab4PointAccumulator {
	A1Point[] points; // An array of type point

	public Lab4PointAccumulator() {
	} // constructor

	public String run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many points do you wish to store?");
		final int N;
		if (scan.hasNextInt()) {// checks to make sure input is an int
			N = scan.nextInt();
			points = new A1Point[N];// stores amount of slots in array
		} else {
			return "invalid input";
		}
		System.out.println("Type the points you wish to store: ");
		for (int i = 0; i < N; i++) {
			Scanner input = new Scanner(System.in);
			String userpoint = input.nextLine();
			String[] cord = userpoint.split(" ");// makes point into array of
													// strings
			int x = Integer.parseInt(cord[0]);
			int y = Integer.parseInt(cord[1]);// makes points into ints
			points[i] = new A1Point(x, y);
			// System.out.println(points[i].toString());
		}
		return "";
	}

	private String furthestorigin() {
		// finds point farthest from origin
		double d1 = 0.0;
		double max = 0.0;
		A1Point maxpoint = new A1Point(0, 0);
		A1Point origin = new A1Point(0, 0);
		for (int k = 0; k < points.length; k++) {
			d1 = origin.distanceTo(points[k]);
			if (max < d1) {
				max = d1;
				maxpoint = points[k];
			}
		}
		System.out.println("The point furthest from the origin is: "
				+ maxpoint.toString());
		return maxpoint.toString();
	}

	private String furthestappart() {// finds the point that is farthest apart
										// from each other
		double maxdis = 0.0;
		double d1 = 0.0;
		A1Point maxpoint1 = points[0];
		A1Point maxpoint2 = points[0];
		for (int j = 0; j < points.length; j++) {
			for (int i = 0; i < points.length - 1; i++) {
				d1 = points[j].distanceTo(points[i]);// uses distanceTo method
														// in the A1Point class
				if (maxdis < d1) {
					maxdis = d1;
					maxpoint1 = points[j];// assigns values to the highest
											// points
					maxpoint2 = points[i];
				}
			}

		}
		System.out.println("The points furthest appart are: "
				+ maxpoint1.toString() + " " + maxpoint2.toString());// prints
																		// out
																		// the
																		// answer
		return "";
	}

	public static void main(String[] args) {
		Lab4PointAccumulator test = new Lab4PointAccumulator();
		test.run();
		test.furthestorigin();
		test.furthestappart();
	}
}
