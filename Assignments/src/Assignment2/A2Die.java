package Assignment2;
import java.util.Random;

public class A2Die {

	private Random rand;// instance field

	public A2Die() {
		// initialize a new Random object in the Constructor
		rand  = new Random();
	}

	public int roll() {

		return (rand.nextInt(6)+1);// returns a random number between [1,6]
	}
	// Look at the nextInt(int bound) method of Random

}
