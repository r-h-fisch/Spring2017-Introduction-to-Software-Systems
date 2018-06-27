package Lab12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.geom.*;


public class Rec extends Shape{
	int height;
	int width;
	int x;
	int y;

	
	public Rec(Color fillColor, Color borderColor, int inx, int iny, int h, int w){
		super(fillColor, borderColor, inx, iny);
		height=h;
		width=w;
		this.x=inx;
		this.y=iny;
	}
	
	public Rec(Color fillColor,int inx, int iny, int h, int w){
		super(fillColor, inx, iny);
		height=h;
		width=w;
		this.x=inx;
		this.y=iny;
	}
	
	public Rec(int inx, int iny, int h, int w){
		super(inx, iny);
		height=h;
		width=w;
		this.x=inx;
		this.y=iny;
	}
	//overriding the getRect() method in the Shape class
	public Rectangle getRect(){
		return new Rectangle(x, y, this.width, this.height);
	}
	
	public void moveLoc(int dx, int dy) {
		super.moveLoc(dx, dy);
		//getRect().translate(dx, dy);

	}
	
	public void draw(Graphics g){
		g.setColor(getBorderColor());
		g.drawRect(getX(), getY(), width, height);
		g.setColor(getFillColor());
		g.fillRect(getX(), getY(), width, height);
	}
}

