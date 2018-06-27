package Lab12;

import java.awt.Color;  
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

abstract class Shape extends ShapeDriver {     
	private Color fillColor;     
	private Color borderColor;     
	private Boolean isFilled;     
	int x;
	int y;
	int dx;
	int dy;
	
	
	// the three constructors initialize the instance fields     
	public Shape(Color fillColor,Color borderColor, int inx, int iny) {
		this.fillColor= fillColor;
		this.borderColor= borderColor;
		this.x=inx;
		this.y=iny;
		dx=1;
		dy=1;
		
	}    
	
	// set borderColor to Black since not provided     
	public Shape(Color fillColor, int inx, int iny) {
		this.fillColor = fillColor;
		borderColor= Color.black;
		x=inx;
		y=iny;
		dx=1;
		dy=1;
	}    
	// set fillColor to white and border color to black     
	public Shape(int inx, int iny) {
		borderColor= Color.BLACK;
		fillColor= Color.white;
		x=inx;
		y=iny;
		dx=1;
		dy=1;
	} 
	
	public void setFillColor(Color c) { }     
	
	public Color getFillColor() {
		return fillColor;
	}  
	
	public void setBorderColor(Color c) { } 
	
	public Color getBorderColor() {
		return borderColor;
	}     
	
	
	abstract Rectangle getRect();

	
	// Note:  subclasses of Shape do not inherent private members so we need methods the subclasses     
	// can use to get the x and y values from the private Point instance field     
	     
	// if fillColor is white returns true, else returns false     
	public boolean isFilled() { 
		if (fillColor!= null){
		return true;
		}
		else {
			return false;
		}
	}
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

// moves location by dx and dy    
void moveLoc(int dx, int dy) {
	//this.getRect().x= x+dx;
	//this.getRect().y= y+dy;
	//this.getRect().translate(x+(dx), y+ (dy));
	//this.getRect().y.setLocation(y+ (dy*-1));
	this.x=x+dx;
	this.y= y+dy;
	//this.getRect().translate((int) dx, (int) dy);
	
}  


public String toString(){
	return dx + " " + dy;
}

abstract void draw(Graphics g);


public static void main(String[] args) {
	Shape test1= new Cir( Color.red, Color.blue, 10, 12, 3);
	Shape test2= new Rec( Color.pink, Color.yellow, 10, 12, 3, 4);
	Shape test3= new Square( Color.cyan, Color.green, 10, 12, 5);
	System.out.println(test1);
	System.out.println(test2);
	System.out.println(test3);
	
}



}