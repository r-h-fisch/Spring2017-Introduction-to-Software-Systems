package Assignment4.part2;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
	
	
	ArrayList<Books> collection= new ArrayList<Books>();
	ArrayList<Student> listofStudents= new ArrayList<Student>();
	private double fine = 14.0;
	private String title;
	private String author;
	private boolean status;
	
	
	/**
	 * Constructor 1 which carries the same amount of variables as the Books class
	 * 
	 * @param String title is the title of the book
	 * @param String author is the author of the book
	 * @param boolean status is if the book is checked out or not
	 **/
	public Library(String title, String author, boolean status){	
		this.title= title;
		this.author=author;
		this.status=status;
	}
	
	/**
	 * Constructor 2 which carries the same amount of variables as the Books class
	 * 
	 * @param ArrayList<Books> collection is the list of books in the library
	 *
	 */
	public Library(ArrayList<Books> collection){
		this.collection= collection;
	}

	/**
	 * This method returns a book's title by calling a method in the
	 * books class
	 * 
	 * @param Books a is the book's title we are looking for
	 * @return String the books title
	 */
	public String getTitle(Books a){
		return a.booktitle(a);
	}
	/**
	 * This method returns a book's author by calling a method in the
	 * books class
	 * 
	 * @param Books a is the book's author we are looking for
	 * @return String the books author
	 */
	public String getAuthor(Books a){
		return a.bookauthor(a);
	}
	

	/**
	 * This method sends the book to the bookstatus method in the Books class
	 * and does this by creating a new Book with the same title and author but 
	 * changing the books status
	 * @param Book a that we are searching for
	 * @param Student checking the book out
	 */
	/*public void checkout(Books a, Student b){
		search(a);
	}*/

/**
 *  * This method will add a Students to the arraylist listofStudents in CheckInOut 
 * 
 * @param Student a is the student passesd that is to be added into the arraylist
 */
	private void addStudent(Student a){
	listofStudents.add(a);
}

	/**
	 * This method will remove a Students to the arraylist listofStudents in CheckInOut 
	 * 	 
	 * @param Student grad is the student passesd that is to be removed from the arraylist
	 */
	private void removeStudent(Student grad){
		listofStudents.remove(grad);
}

	/**
	 * This method will determine if the book is in the library or not.
	 * It will work with the method search to first determine if the book is in 
	 * the library, then statusofBook determines if someone has checked it out or not.
	 * boolean inlib sent by the search class which determins if a book owned by the 
	 * library or not
	 * 
	 * @param Books a is the book that we are checking the status on
	 *
	 */
	void statusofBook(Books a){
		boolean instock =a.bookstatus(a);
		boolean inlib= search(a);
		if(!instock && inlib){
			System.out.println("The book is checked out");
		}
		else if(!instock && !inlib){
			System.out.println("The book is not stored in our library");
		}
		else if(instock && inlib){
			System.out.println("The book is avaiable to be checked out!");
		}
	}
	/**
	 * This method was made just for the checkin check out function since 
	 * the book has already been verified to be in the collection if 
	 * it is being passed to this method
	 * 
	 * @param Book c is the book passed by the student Class
	 */
	void checkinout(Books c){
		boolean instock =c.bookstatus(c);
		if(!instock){
			System.out.println("The book has been checked out");
		}
		else{
			System.out.println("The book has been returned");
		}
	}
	/**
	 * This method will read through the arraylist collection and 
	 * will say if the book owned by the library or not. 
	 * 
	 *  @param Books b is the Books we are searching for
	 */
	public boolean search(Books b){
		boolean status= false;
		for(Library a: collection){
			if(collection.contains(b)){
				status= true;
			}
			else {
				status= false; 
			}
		}
		return status;
		}
	
	/**
	 * This method returns the fine the student might have. If they have nothing
	 * overdue the method returns 0.0 
	 * 
	 * @param Student s which may or may not have an overdue book
	 * 
	 * @return a double x with the students overdue book fine
	 */
	public double getfine(Student s){
		double x=0.0;
		if(s.overdue){
			x=fine;
		}
		else {x=0.0;}
		return x;
	}
	/*
	 * main method to test and implement the code 
	 */

	public static void main(String[] args) {
		
		ArrayList<Books> testlib1= new ArrayList<Books>();
		Books a= new Books("Hamelt", "Shakespear", true);
		Books b= new Books("The Odyssey", "Homer", true);
		Books c= new Books("Harry Potter", "JK Rowling", false);
		testlib1.add(a);
		testlib1.add(b);
		testlib1.add(c);
		Books d= new Books("Big Java", "Pearsons", true);
		
		Library test1= new Library(testlib1);
		Books booktest1= new Books(testlib1);
		Library test2= new Library(testlib1);
		ArrayList<Student> teststu= new ArrayList<Student>();
		Student me = new Student("Rebecca", test2, false);
		Student turab = new Student("Turab", test1, true);
		Student sam = new Student("Sam", test1, true);
		teststu.add(me);
		teststu.add(turab);
		
		//testing search and status
		System.out.println("Searching for book in Library: "+ test1.getTitle(b) + " by " + test1.getAuthor(b));
		test1.statusofBook(b);
		System.out.println("Searching for book in Library: "+ test1.getTitle(c) + " by " + test1.getAuthor(c));
		test1.statusofBook(c);
		System.out.println("Searching for book in Library: "+ test1.getTitle(d) + " by " + test1.getAuthor(d));
		test1.statusofBook(d);
		
		//testing adding a book to the library
		System.out.println('\n'+ test1.getTitle(d)+ " will now be added to the Library: ");
		booktest1.addBook(d);
		System.out.print("Now we search the library for the book to see if it is there: ");
		System.out.println(test1.search(d));
		
		//testing removing a book from the library
		System.out.println('\n'+ test1.getTitle(a)+ " will now be removed from the Library: ");
		System.out.println("Searching for book in Library: "+ test1.getTitle(a) + " by " + test1.getAuthor(a));
		booktest1.removeBook(a);
		System.out.print("Now we search the library for the book to see if it is there: ");
		System.out.println(test1.search(a));
		
		//testing the check out the book
		System.out.println('\n'+ "Checking out: "+ test2.getTitle(b));
		me.checkout(b);

		
		//testing the check in a book
		System.out.println('\n'+ "Checking in: "+ test2.getTitle(b));
		me.checkin(b);
		
		//testing to view my checkout history
		System.out.print('\n'+ "My check out histroy: ");
		System.out.println(me.history.toString());
		
		//testing adding students
		System.out.println('\n'+ "Adding Students: "+ me.toString() + ", " +sam.toString()+ ", and "+turab.toString()+ " to Library's Students");
		test1.addStudent(me);
		test1.addStudent(sam);
		test1.addStudent(turab);
		System.out.println(test1.listofStudents.toString());
		
		//testing removing students
		System.out.println('\n'+ "Removing Student: "+ sam.toString());
		test1.removeStudent(sam);
		System.out.println(test1.listofStudents.toString());
				
		//checking if student has an overdue book fine
		System.out.println('\n'+ "How much does "+ turab.toString()+ " owe for overdue books?");
		System.out.print("$"+test1.getfine(turab));
		System.out.println('\n'+ "How much does "+ me.toString()+ " owe for overdue books?");
		System.out.print("$"+test1.getfine(me));
	}
	}

	

