package TestLab9;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.*;

public class Circle extends Shape {
	int radius;
	double area;
	double per;
	Point center;  

	public Circle(Color fillColor, Color borderColor, int x, int y, int rad) {
		super(fillColor, borderColor, x, y);
		radius = rad;
		center = new Point(x + rad, y + rad);
	}

	public Circle(Color fillColor, int x, int y, int rad) {
		super(fillColor, x, y);
		radius = rad;
		center = new Point(x + rad, y + rad);
	}

	public Circle(int x, int y, int rad) {
		super(x, y);
		radius = rad;
		center = new Point(x + rad, y + rad);
	}

	public double getArea() {
		area = Math.PI * (Math.pow(radius, 2));
		return area;
	}

	public double getPerimeter() {
		per = Math.PI * 2 * radius;
		return per;

	}

	public int getRad() {
		return radius;
	}
	
	public void moveLoc(int dx, int dy)  {
		super.moveLoc(dx, dy);
		center.translate(dx, dy);
		
	}

	public String toString() {
		return "The circle has a radius of " + radius + ", and an area of "
				+ getArea() + ", and a permimeter of " + getPerimeter();
	}

	//finds the distance beteween the centers of 2 different circles
	public double distance(Circle a){
	 double dis= Math.sqrt((Math.pow(a.center.x - center.x,2))+ (Math.pow(a.center.y - this.center.y ,2)));
	 return dis;
	}
	
	public void draw(Graphics g) {
		g.setColor(getBorderColor());
		g.drawOval(getX(), getY(), radius * 2, radius * 2);
		g.setColor(getFillColor());
		g.fillOval(getX(), getY(), radius * 2, radius * 2);
	}
}
