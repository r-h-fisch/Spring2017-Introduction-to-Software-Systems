package Assignment3;

////////////////////////////////////////////////////////////////////////////////////
//
//H212 Spring 17
//Homework 3 
//
//Due: 9/24/16 11:59 PM
//
//Author Rebecca Fisch rhfisch
//
//////////////////////////////////////////////////////////////////////////////////
/*
 * once all the bugs in the program are fixed the program should generate output similar to this:
 * Student0 91
 * Student8 83
 * Student17 79
 * Student3 76
 * Student5 76
 * Student12 75
 * Student4 74
 * Student7 72
 * Student11 71
 * Student6 62
 * Student1 59
 * Student2 54
 * Student13 45
 * Student18 41
 * Student16 38
 * Student9 36
 * Student10 24
 * Student15 18
 * Student14 6
 * Student19 1
 */
public class Student {

	public String username;
	public int score;

	public static Student[] students = new Student[20]; // error, never
														// initialized

	// Call the constructor to create a new student object
	public Student(String _username) {
		username = _username;
	}

	// sort students by score in descending order
	public static void sort() {

		// Stores number of switches
		int switches = 1;// error, there will always display one more switches
							// than happened
		while (switches > 0) {// error, there is an infinite loop
			 // because switches will always be
			// bigger than 0
			int compare = switches;
			for (int i = 0; i < students.length- 1; i++) {
				// if score of ith student is less than score of i+1th student
				// switch
				if (students[i].score < students[i + 1].score) {

					// swap students in array
					Student switchstudent = students[i];
					students[i] = students[i + 1];// error, the program was
													// making both values equal
													// to student[i+1], not
													// switching them
					students[i + 1] = switchstudent;
					// increment switches
					switches++;

				}
				
			}
			if (compare == switches) {
				switches=-1;

			}
		}
	}

	// Allocates the student array with a username and a randomly generated
	// score
	public static void allocateStudentArray() {

		String username = "Student";

		// for i less than length of student array
		for (int i = 0; i < students.length; i++) {

			// populate student array
			int score = (int) (Math.random() * 100);// generate a random number
													// between 0-100
			students[i] = new Student(username + i);// initialize with username

			// assign score
			students[i].score = score;

		}
	}

	public static void main(String args[]) {
		// Student[] stu =new Student[20];
		allocateStudentArray();
		sort();// print output
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].username + " " + students[i].score);// error,
																		// wrong
																		// things
																		// to
																		// call
																		// to
																		// output
		}

	}

}
