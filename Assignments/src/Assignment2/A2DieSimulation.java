package Assignment2;
import java.util.Scanner;
// instance fields 

public class A2DieSimulation{
private A2Die die; 
private A2Counter one; 
private A2Counter two; 
private A2Counter three; 
private A2Counter four; 
private A2Counter five; 
private A2Counter six;

public A2DieSimulation(){ // initialize all the instance fields public String run()
	die = new A2Die();
	one = new A2Counter("one");
	two = new A2Counter("two");
	three = new A2Counter("three");
	four= new A2Counter("four");
	five= new A2Counter("five");
	six= new A2Counter("six");
}

public String run(){
	Scanner scan = new Scanner(System.in);
	String out="";
	System.out.println("How many times would you like to roll the die?");
	int times = scan.nextInt();
	int outcomes;
	for(int i=0; i<times; i++){
		outcomes = die.roll();
		switch(outcomes){
		case 1:
			one.increment();
			break;
		case 2:
			two.increment();
			break;
		case 3:
			three.increment();
			break;
		case 4: 
			four.increment();
			break;
		case 5:
			five.increment();
			break;
		case 6:
			six.increment();
			break;
		}
	}
	out += one.toString()+ '\n'+two.toString()+ '\n'+ three.toString()+ '\n'+ four.toString()+'\n'+ five.toString()+'\n'+ six.toString();
	return out;
}
public static void main(String[] args){
	A2DieSimulation diesim = new A2DieSimulation();
	System.out.println(diesim.run());
	
	
}
}