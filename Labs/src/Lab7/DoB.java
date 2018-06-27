package Lab7;

public class DoB extends Day {
	Month m;
	Year year;
	//constructor
	public DoB(){
		m= new Month();
		year= new Year();
	}
	//main method
	public static void main(String[] args) {
		Month nextmonth= new Month();
		Year year= new Year();
		String valid= "";
		int limit= DateLimit(6);
		if (year.validYear(1998)){
			valid="a valid";
		}
		else {
			valid="not a valid";
		}
		//print statements
		System.out.println("1998 is "+ valid +" year" );
		System.out.println("The amout of days in the 6th (June) month is: "+ limit);
	}
	
}
