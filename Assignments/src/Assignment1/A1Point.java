package Assignment1;
////////////////////////////////////////////////////////////////////////////////////
//
//  H212 Fall 16
//  Homework 1 
//  
//  Due: 9/11/16 11:59 PM
//
//  Author  Rebecca Fisch rhfisch
//  Last Edited: 1/22/17
//
//
//  Directions:  Impletment toString method and distanceTo method 
//  Note:        Will need to change reutrn values - added so code initialy compiles 
//               
//////////////////////////////////////////////////////////////////////////////////


import java.lang.Math;

public class A1Point {
    
    private int x;
    private int y;
    
    // Constructor method 
    public A1Point(int x, int y) {
        // this.x is the x as an instance field 
        // x is just the x local as a paramter to this method 
        this.x = x; 
        this.y = y;
    }
    
    // return this points x value 
    public int x() {
     return this.x;   
    }
    
    // return this points y value 
    public int y() {
     return this.y;   
    }
    
    // return distance from this point to other point  
    public double distanceTo(A1Point other) {
    	double x1 = other.x();
		double y1 = other.y(); 
		double distance= Math.sqrt((Math.pow(x1-x, 2))+(Math.pow(y1-y,2)));
        return distance;
    }
    
    // returns the point as a String 
    public String toString() {
        return "(" + x+","+y +")";
    }
 
    // test client 
    public static void main(String[] args) {
        // Instantiating 3 Objects of type Point 
        // Type is a Point - Variable Name - Creating new Point with new keywork 
        A1Point center = new A1Point(0,0);
        A1Point p1 = new A1Point(5, 10);
        A1Point p2 = new A1Point(3, 7);
        // creating a variable d1 that is didstance from Point Center to Point p1
        // call objects or class methods with . operator
        // distanceTO takes a parameter of type Point, so we passed in p1
        Double d1 = center.distanceTo(p1);
        Double d2 = p1.distanceTo(p2);
        
        System.out.println("Distance from point1 to center: "+d1);
        System.out.println("Distance from point1 to point2: "+d2);

    }
}