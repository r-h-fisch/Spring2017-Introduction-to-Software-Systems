package Lab7;

public class Year {
	
	public boolean validYear(int year){
		if (String.valueOf(year).length() != 4){
			return false;
		}
		else{
			return true;
		}
	}

}
/*Can you re-write all classes as abstract data type (ADT)?
 * Yes, it is possible to re-write all the classes as abstract data types.
 */
