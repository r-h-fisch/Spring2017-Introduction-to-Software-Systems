package TestLab9;


import java.awt.Color;  
import java.awt.Point;
import java.awt.Graphics;
import java.util.Random;

abstract class Shape extends ShapeDriver {     
 private Color fillColor;     
 private Color borderColor;     
 private Boolean isFilled;     
 private Point location;
 int dy;
 int dx;
 int direction;//-1
 
 // the three constructors initialize the instance fields     
 public Shape(Color fillColor,Color borderColor, int x, int y) {
  location= new Point(x,y);
  this.fillColor= fillColor;
  this.borderColor= borderColor;
  dx=1;
  dy=1;
  direction =-1;
 }    
 
 // set borderColor to Black since not provided     
 public Shape(Color fillColor, int x, int y) {
  location= new Point(x,y);
  this.fillColor = fillColor;
  borderColor= Color.black;
  direction =-1;
  dx=1;
  dy=1;
  
 }    
 // set fillColor to white and border color to black     
 public Shape(int x, int y) {
  location= new Point(x,y);
  borderColor= Color.BLACK;
  fillColor= Color.white;
  direction =-1;
  dx=1;
  dy=1;
 } 
 
 public void setFillColor(Color c) {
	 fillColor= c;
 }     
 
 public Color getFillColor() {
  return fillColor;
 }  
 
 public void setBorderColor(Color c) { } 
 
 public Color getBorderColor() {
  return borderColor;
 }     
 
 public Point getLocation() {
  return location;
  
 } 
 
 // Note:  subclasses of Shape do not inherent private members so we need methods the subclasses     
 // can use to get the x and y values from the private Point instance field     
 public int getX() {
  return location.x;
 }    
 public int getY() {
  return location.y;
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
void moveLoc(int dx, int dy) {
 location.translate(dx, dy);
} 


abstract void draw(Graphics g);
//abstract method to get Radius
abstract int getRad();
abstract double getArea();     
abstract double getPerimeter(); 

public static void main(String[] args) {
 Shape test1= new Circle( Color.red, Color.blue, 10, 12, 3);
 System.out.println(test1);
 
}

}
