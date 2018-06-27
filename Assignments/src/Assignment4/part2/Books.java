package Assignment4.part2;

import java.util.ArrayList;

public class Books extends Library {
	protected ArrayList<Books> history= new ArrayList<Books>();
	private String t;
	private String a;
	private boolean s;
	/**
	 * This is a constructor method and calls the super class.
	 * 
	 * @param String title is the title of the book
	 * @param String author is the author of the book
	 * @param boolean status is if the book is checked out or not (true checked in false checked out)
	 */
	public Books(String title, String author, boolean status){
		super(title, author, status);
		t= title;
		a= author;
		s= status;
	}
	/**
	 * Constructor 2: intializes the array list of collection in the Books class 
	 * by calling the super class;
	 * 
	 * @param collection of books 
	 */
	public Books(ArrayList<Books> collection){
		super(collection);
	}
	/**
	 * This method will add a Books to the arraylist collection in library. 
	 * 
	 * @param Books b is the book passesd that is to be added into the arraylist
	 */
	public void addBook(Books b){
		collection.add(b);
	}
	
	/**
	 * This method will remove a Books to the arraylist collection in library.
	 * 
	 * @param Books nope is the book passesd that is to be removed from the arraylist
	 */
	public void removeBook(Books nope){
		collection.remove(nope);
	}
	
	/**
	 * This method will return the current book title
	 * 
	 * @param The book looking for
	 * @return the title of the book
	 */
	public String booktitle(Books l){
		return l.t;
	}
	
	/**
	 * This method will return the current book author
	 * @param The book looking for
	 * @return the author of the book
	 */
	public String bookauthor(Books l){
		return l.a;
	}
	
	/**
	 * This method will return the current status of weather the book is in 
	 * the library or checked out
	 * @param The book looking for
	 * @return a boolean status of the book
	 */
	public boolean bookstatus(Books l){
		return l.s;
	}

	/**
	 * This method will return the current book title
	 * 
	 * @return the title of the book
	 */
	public String toString(){
		return t;
	}
	
}
