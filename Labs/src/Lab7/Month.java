package Lab7;

public class Month {

	private int monthint;
	private String monthString;
	private int days;
	private int year;
	
//constructors:
	public Month(int month) {
		monthint = month;
		days=2;
		year=2010;
	}

	public Month(String mon, int day, int yr) {
		monthString = mon;
		days = day;
		year = yr;

	}

	public Month() {
		monthint = 3;
		monthString = "Jan";
		days=2;
		year=2010;
		
	}

	// get and set methods for month:

	//the setMonth for a month that is a string and returns a int
	public void setMonthNum() {
		int month;
		if (monthString.equals("Jan")) {
			month = 1;
		} else if (monthString.equals("Feb")) {
			month = 2;
		} else if (monthString.equals("Mar")) {
			month = 3;
		} else if (monthString.equals("Apr")) {
			month = 4;
		} else if (monthString.equals("May")) {
			month = 5;
		} else if (monthString.equals("Jun")) {
			month = 6;
		} else if (monthString.equals("Jul")) {
			month = 7;
		} else if (monthString.equals("Aug")) {
			month = 8;
		} else if (monthString.equals("Sep")) {
			month = 9;
		} else if (monthString.equals("Oct")) {
			month = 10;
		} else if (monthString.equals("Nov")) {
			month = 11;
		} else if (monthString.equals("Dec")) {
			month = 12;
		} else {
			month = 0;
		}
		monthint=month;
	}
	//get method that returns the int of the month
	public int getMonthNum(){
		setMonthNum();
		return monthint;
	}
	//the setMonth for a month that is a int and returns a String
	public  void setMonthString() {
		String month = "";
		if (monthint == 1) {
			month = "Jan";
		} else if (monthint == 2) {
			month = "Feb";
		} else if (monthint == 3) {
			month = "Mar";
		} else if (monthint == 4) {
			month = "Apr";
		} else if (monthint == 5) {
			month = "May";
		} else if (monthint == 6) {
			month = "Jun";
		} else if (monthint == 7) {
			month = "Jul";
		} else if (monthint == 8) {
			month = "Aug";
		} else if (monthint == 9) {
			month = "Sep";
		} else if (monthint == 10) {
			month = "Oct";
		} else if (monthint == 11) {
			month = "Nov";
		} else if (monthint == 12) {
			month = "Dec";
		} else {
			month = "Error not a valid month";
		}
		monthString=month;
	}
	//get method that returns a string of the month
	public String getMonthString(){
		setMonthString();
		return monthString;
	}
	public static void main(String[] args) {
		//test cases for all constuructors 
		Month nextmonth = new Month("Jan", 23,2000);
		Month nextmonth2 = new Month();
		Month nextmonth3 = new Month(3);
		System.out.println("The first month is: " + nextmonth.getMonthNum());
		System.out.println("The string to repersent the third month is: "
				+ nextmonth2.getMonthString());
		System.out.println("The third month is: " + nextmonth3.getMonthString());
	}
	//answer to question is in the year class

}
