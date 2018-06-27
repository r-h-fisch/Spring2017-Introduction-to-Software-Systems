package Lab8;

import java.awt.Color;
public class Rectangle extends Shape{
	double height;
	double width;
	double area;
	double permin;
	
	public Rectangle(Color fillColor, Color borderColor, int x, int y, double h, double w){
		super(fillColor, borderColor, x, y);
		height=h;
		width=w;
	}
	
	public Rectangle(Color fillColor,int x, int y, double h, double w){
		super(fillColor, x, y);
		height=h;
		width=w;
	}
	
	public Rectangle(int x, int y, double h, double w){
		super(x, y);
		height=h;
		width=w;
	}
	
	public double getArea(){
		area= height*width;
		return area;
	}
	
	public double getPerimeter(){
		permin= 2*height+ 2*width;
		return permin;
		
	}
	public String toString(){
		return "The shape has a height of "+ height +", a width of "+ width+ ", and an area of "+ getArea() + ", and a permimeter of "+ getPerimeter();
	}
}

