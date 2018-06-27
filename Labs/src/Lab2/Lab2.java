////////////////////////////////////////////////////////////////////////////////////
//
//  H212 Fall 16

//  Lab 2 
//  
//  Released:  8/26/16
//  Due:       9/4/16 11:59 PM
//
//  @Author  Rebecca Fisch and rhfisch
//  Last Edited: Jan, 19
//
//
//  Directions:  Implement the following methods 
//               
//               
//////////////////////////////////////////////////////////////////////////////////
package Lab2;
// Note:  Do not need to explicitly import classes from java.lang but wanted to make it explicit 
// Goal - understand using Static classes - i.e. the Math class was not designed to be Instantiated (make objects) 
// It is a class that provides functionality and will be used to complete one of the methods
import java.lang.Math;

public class Lab2 {
    
    // computes volume of a sphere when given a radius
    public static double volumeOfSphere(int radius) {
      //TODO
    	double vol= (4*Math.PI*Math.pow(radius, 3))/3;
    	return vol;
    }
    
    // computes circumference of a circle
    public static double circumference(int radius) {
      //TODO
    	double cir= 2*Math.PI*radius;
    	return cir;
    }
    
    // returns a String, in the following format "SquareArea: *, Perimeter: *, Diagonal: *" where * refers to square of 
    // the rectanglar area, perimeter, and the diagonal of the square respectively 
    // (use Pythagorean Theorem)
    public static String square(int len) {
      //TODO
    	double per= len*4;
    	double area= len*len;
    	double dia= Math.sqrt(Math.pow(len, 2)+Math.pow(len, 2));
    	return "SquareArea: "+ area + " Perimeter: "+ per+ " Diagonal: "+dia;
    
    }
    
    // reads a number between 1,000 and 999,999 and prints it with a \ separating the thousands
    // hint use modulus (%) to save part of the number, then concatenate back together as a String
    public static String addBackSlash(int num) {
      //TODO
    	int tens=num%10;
    	int hun= (num%100)/10;
    	int thous=(num%1000)/100;
    	int tthous=(num%10000)/1000;
    	int hthous=(num%100000)/10000;
    	int mil=(num%1000000)/100000;
    	return mil+hthous+tthous+ "\\" +thous +hun+tens;
    	/*String snum= Integer.toString(num);
    	int numlength= snum.length();
    	String end= snum.substring(numlength-3, numlength);
    	String begin=snum.substring(0, numlength-3);
    	String backslash= begin+ "/"+ end;
    	return backslash;*/
    }
    
    // given angle in Degrees, convert to radians (hint look at Math class Java doc API)
    // and return a string of the Sin, Cos, and Tangent of the angle  
    public static String trigFunctions(double angle) {
    	double toradians= Math.toRadians(angle);
    	double sinr= Math.sin(toradians);
    	double cosr= Math.cos(toradians);
    	double tanr= Math.tan(toradians);
    return "Sin: "+sinr+" Cos: "+cosr+" Tan: "+tanr;
    }
    
    // test client 
    public static void main(String[] args) {
      //TODO: Modify to test all functions 
    	System.out.println("Volume:"+volumeOfSphere(12));
    	//3.141592653589793
    	System.out.println("Circumference:"+ circumference(1));
    	//6.283185307179586
    	System.out.println(square(4));
    	//SquareArea: 16.0 Perimeter: 16.0 Diagonal: 5.656854249492381
    	System.out.println(addBackSlash(1234));
    	//1\234
        System.out.println(trigFunctions(30));
       // Sin: 0.49999999999999994 Cos: 0.8660254037844387 Tan: 0.5773502691896257
        //
    }
}

///////////////////////////////////
//                               //
// ANSWER THE FOLLOWING QUESTIONS //
//                               //
///////////////////////////////////

/*
 * Questions 1-3 are on explicit and implicit casting of some numerical types  
 *
 * 1.  What happens if you multipy a double with a char? 
 * It multiplies the number the character is associated with by the double value.
 * 2.  What happens if a method has a paramater of type int, but you pass it a char?
 * It will print out the number associated with the char.
 * 3.  What happens if a mehtod has a paramater of type char, but you pass it an int? 
 * It will print a character that is associated with that int.
 * 4.  What are the 8 primitive data types in the Java language 
 * 		double, int, char, boolean, byte, short, float, long
 *
 * 5.  Consider the following code snippet.
 *     int i = 10;
 *     n = ++(i++);
 *     System.out.println(++(i++)) % 5;
 *     What are the values of i and n after the code is executed?
 *     i=14
 *     n=12
 *     What are the final value printed?
 *     The final value will be 3.
 */

