package Lab8;

import java.awt.Color;

public class Circle extends Shape{
	double radius;
	double area;
	double per;
	
	public Circle(Color fillColor, Color borderColor, int x, int y, double rad){
		super(fillColor, borderColor, x, y);
		radius= rad;
	}
	
	public Circle(Color fillColor,int x, int y, double rad){
		super(fillColor, x, y);
		radius=rad;
	}
	
	public Circle(int x, int y, double rad){
		super(x, y);
		radius=rad;
	}
	
	public double getArea(){
		area= Math.PI*(Math.pow(radius, 2));
		return area;
	}
	
	public double getPerimeter(){
		per= Math.PI*2*radius;
		return per;
		
	}
	public String toString(){
		return "The circle has a radius of "+ radius+ ", and an area of "+ getArea() + ", and a permimeter of "+ getPerimeter();
	}

}
