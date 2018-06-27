package Lab12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;


public class Cir extends Shape {
	int radius;
	//Point center;

	public Cir(Color fillColor, Color borderColor, int inx, int iny, int rad) {
		super(fillColor, borderColor, inx, iny);
		radius = rad;
		//center = new Point(x + rad, y + rad);
	}

	public Cir(Color fillColor, int inx, int iny, int rad) {
		super(fillColor, inx, iny);
		radius = rad;
		//center = new Point(x + rad, y + rad);
	}

	public Cir(int inx, int iny, int rad) {
		super(inx, iny);
		radius = rad;
		//center = new Point(x + rad, y + rad);
	
	}
	//overriding the getRect() method in the Shape class
	public Rectangle getRect() {
		return new Rectangle(x, y, radius*2, radius*2);
	}

	

	public void moveLoc(int dx, int dy) {
		super.moveLoc(dx, dy);
		//getRect().translate(dx, dy);

	}

	
	// finds the distance beteween the centers of 2 different Cirs
	
	public void draw(Graphics g) {
		g.setColor(getBorderColor());
		g.drawOval(getX(), getY(), radius * 2, radius * 2);
		g.setColor(getFillColor());
		g.fillOval(getX(), getY(), radius * 2, radius * 2);
	}
}
