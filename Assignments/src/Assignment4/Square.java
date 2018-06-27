package Assignment4;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Rectangle{
	double side;
	
	public Square(Color fillColor, Color borderColor, int x, int y, int h){
		super(fillColor, borderColor, x, y, h, h);
		side=h;
	}
	
	public Square(Color fillColor,int x, int y, int h){
		super(fillColor, x, y, h, h);
		side=h;
	}
	
	public Square(int x, int y, int h){
		super(x, y,h,h);
		side=h;
	}
	
	//relies on the Rectangle class for the rest of the methods
}

