package Lab8;

import java.awt.Color;  
import java.awt.Point;

abstract class Shape {     
	private Color fillColor;     
	private Color borderColor;     
	private Boolean isFilled;     
	private Point Location;     
	
	// the three constructors initialize the instance fields     
	public Shape(Color fillColor,Color borderColor, int x, int y) { }    
	
	// set borderColor to Black since not provided     
	public Shape(Color fillColor, int x, int y) {
		borderColor= Color.black;
	}    
	// set fillColor to white and border color to black     
	public Shape(int x, int y) {
		borderColor= Color.BLACK;
		fillColor= Color.white;
	} 
	
	public void setFillColor(Color c) { }     
	
	public Color getFillColor() {
		return fillColor;
	}  
	
	public void setBorderColor(Color c) { } 
	
	public Color getBorderColor() {
		return borderColor;
	}     
	
	public Point getLocation() {
		return Location;
	} 
	
	// Note:  subclasses of Shape do not inherent private members so we need methods the subclasses     
	// can use to get the x and y values from the private Point instance field     
	public int getX() {
		return Location.x;
	}    
	public int getY() {
		return Location.y;
	}     
	// if fillColor is white returns true, else returns false     
	public boolean isFilled() { 
		if (fillColor!= null){
		return true;
		}
		else {
			return false;
		}
	}


// moves location by dx and dy    
private void moveLoc(int dx, int dy) {
}  


abstract double getArea();     
abstract double getPerimeter(); 

public static void main(String[] args) {
	Shape test1= new Circle( Color.red, Color.blue, 10, 12, 3);
	Shape test2= new Rectangle( Color.pink, Color.yellow, 10, 12, 3, 4);
	Shape test3= new Square( Color.cyan, Color.green, 10, 12, 5);
	System.out.println(test1);
	System.out.println(test2);
	System.out.println(test3);
	
}



}
