package Assignment2;

public class A2Counter {
	private final String NAME;
	private int count=0;
	public A2Counter(String id){
		NAME=id;
	}
	public void increment(){
		count++;
	}
	public int tally(){
		return count;
	}
	public String toString(){
		return NAME+ " was rolled: "+ count+ " times  ";
	}

}
