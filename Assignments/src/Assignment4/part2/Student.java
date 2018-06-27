package Assignment4.part2;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	ArrayList<Books> history= new ArrayList<Books>();
	Library checking;
	String name;
	boolean overdue;
	/**
	 * Constuctor 1 for the class which connects which the first constructor in CheckInOut.
	 * 
	 * @param String name for the students name
	 * @param Books checking passes the book the student is currently checking out
	 * 
	 **/
	public Student(String name, Library checking, boolean overdue){
		this.checking= checking;
		this.name= name;
		this.overdue=overdue;
	}
	/**
	 * Constructor 2
	 */
	public Student(){}
		
	/**
	 *This method sends the book to the bookstatus method in the Books class
	 * so that when searching the book it will show the books status as false because
	 * the book is no longer in the library and has been checked out
	 * 
	 * @param a is the Book the student is checking out that is to be added into the arraylist outoflib so 
	 * program can register the book is in the store but no longer able to be checked out
	 */
	public void checkout(Books a){
		if(checking.search(a)){
			history(a);
			Books out= new Books(a.getTitle(a),a.getAuthor(a), false);
			//checking.collection.add(out);
			out.checkinout(out);
		}
		else {
			System.out.println("Book is unable to be checked out");
		}
		}
	
	/**
	 * This method sends the book to the bookstatus method in the Books class
	 * so that when searching the book it will show the books status as true to
	 * mean it has been returned
	 * 
	 * @param b is the Book the student is returning that is to be added back into the library
	 */
	public void checkin(Books b){
		Books in= new Books(b.getTitle(b),b.getAuthor(b), true);
		b.bookstatus(new Books(b.getTitle(b),b.getAuthor(b), true));
		in.checkinout(in);
	}
	
	/**
	 * This method adds the Books to the students history arraylist
	 * 
	 * @param a is Book that the student has checked out that is being added to the Student's library.
	 */
	public void history(Books a){
		history.add(a);}
	
	/**
	 * This method return weather the student has an overdue book or not.
	 * @return String overdue (true is they do have an overdue book, false is they dont have an overdue book)
	 */
	public boolean overdue(){
		return overdue;}

	/**
	 * This method will return the name of the student
	 * 
	 * @return the name of the Student
	 */
	public String toString(){
		return name;
	}
	

}
