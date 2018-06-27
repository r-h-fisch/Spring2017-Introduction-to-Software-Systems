package Lab6;
public class Lab6Frequency {
	private String word="";
	private int freq=1;
	
	public Lab6Frequency(String word){
		this.word = word;
	}
	
	public void setWord(String w) {
		word = w;
	}
	
	public String getWord() {
		return word; 
	}
	
	public void setFreq(){
		freq++;
	}
	
	public int getFreq(){
		return freq;
	}

}
