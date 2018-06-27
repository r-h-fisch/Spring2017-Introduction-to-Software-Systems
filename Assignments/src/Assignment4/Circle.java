package Assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Assignment4.Shape;

public  class Circle extends Shape{
	int radius;
	double area;
	double per;
	
	public Circle(Color fillColor, Color borderColor, int x, int y, int rad){
		super(fillColor, borderColor, x, y);
		radius= rad;
	}
	
	public Circle(Color fillColor, int x, int y, int rad){
		super(fillColor, x, y);
		radius=rad;
	}
	
	public Circle(int x, int y, int rad){
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
	public void draw(Graphics g){
		g.setColor(getBorderColor());
		g.drawOval(getX(), getY(), radius, radius);
		g.setColor(getFillColor());
		g.fillOval(getX(), getY(), radius, radius);
	}
}
