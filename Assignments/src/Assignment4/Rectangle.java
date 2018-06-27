package Assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Assignment4.Shape;
public class Rectangle extends Shape{
	int height;
	int width;
	double area;
	double permin;
	
	public Rectangle(Color fillColor, Color borderColor, int x, int y, int h, int w){
		super(fillColor, borderColor, x, y);
		height=h;
		width=w;
	}
	
	public Rectangle(Color fillColor,int x, int y, int h, int w){
		super(fillColor, x, y);
		height=h;
		width=w;
	}
	
	public Rectangle(int x, int y, int h, int w){
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
	public void draw(Graphics g){
		g.setColor(getBorderColor());
		g.drawRect(getX(), getY(), height, width);
		g.setColor(getFillColor());
		g.fillRect(getX(), getY(), height, width);
	}

	
}

