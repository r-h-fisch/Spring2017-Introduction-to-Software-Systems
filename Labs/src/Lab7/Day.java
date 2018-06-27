package Lab7;

public abstract class Day{
	
	private int date;
	
	
	public static int DateLimit(int m){
		int limit=0;
		if (m==2){
		limit=28;
		}
		else if (m %2==0){
			limit=30;
		}
		else{
			limit=31;
		}
		return limit;
	}
	
	public int nextDay(int day){
		if(day< DateLimit(day)){
			day++;
		}
		else {
			day=1;
		}
		return day;
	}

}
