package Assignment4;
import Assignment4.Shape;
////////////////////////////////////////////////////////////////////////////////////
//
//H212 Fall 16
//
//Homework 4 Template
//@Author  
//
///////////////////////////////////////////////////////////////////////////////////




//These are the imports I used 
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

import Assignment4.Shape;
/*
 * Driver program for randam shape generator app
 */
public class ShapeDriver extends JPanel implements KeyListener {

	// Panel constants
	public final int FRAME_WIDTH = 600;
	public final int FRAME_HEIGHT = 600;
	private ArrayList<Shape> shapelist= new ArrayList<Shape>();
	private Random random;

	public ShapeDriver() {
		super();
		setBackground(Color.PINK);
		random= new Random();
	
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// call super class paintComponent method
		// background will not be colored otherwise
		
		//for loop runs through the arraylist and draws each shape from the arraylist
		for(Shape s: shapelist){
			s.draw(g);
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int x = random.nextInt(600);
		int y = random.nextInt(600);
		int height= random.nextInt(100);
		int width= random.nextInt(100);
		int radius= random.nextInt(100);
		Color rancolor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		//constructing the shapes using the random variables initialized above
		Shape circle= new Circle(rancolor, x, y, radius);
		Shape rec= new Rectangle(rancolor, x, y, height, width);
		Shape square= new Square(rancolor, x, y, height);
		
		//if statements to detect which key was pressed: c, s, or r and adds the shape to the arraylist
		if (e.getKeyCode() == KeyEvent.VK_C) {
			shapelist.add(circle);
			//System.out.println("C");//code to check if program registered the key press
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			shapelist.add(rec);
			//System.out.println("R");
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			shapelist.add(square);
			//System.out.println("S");
		}
			repaint();
		
			
	}

	// do not neet to do anything with this method from KeyListener
	// but must have since this class implements KeyListiner
	@Override
	public void keyReleased(KeyEvent e) {
	}

	// do not neet to do anything with this method from KeyListener
	// but must have since this class implements KeyListiner
	@Override
	public void keyTyped(KeyEvent e) {
	}

	// test client
	public static void main(String[] args) {
		JPanel shapeDriver = new ShapeDriver();
	}
}