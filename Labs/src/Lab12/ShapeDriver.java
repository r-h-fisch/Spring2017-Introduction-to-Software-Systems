package Lab12;

import javax.swing.JPanel;
import javax.swing.Timer;

import Lab9.Circle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Rectangle;

public class ShapeDriver extends JPanel implements ActionListener, KeyListener {
	private Timer timer;
	public final int FRAME_WIDTH = 600;
	public final int FRAME_HEIGHT = 600;
	private ArrayList<Shape> shapelist = new ArrayList<Shape>();
	private Random random;

	public ShapeDriver() {
		super();
		setBackground(Color.PINK);
		random = new Random();
		// the second argument to the Timer Constructor takes an ActionListener
		// the this key word informs the JVM to look inside this class for
		// the actionPerformed method that must be overridden when
		// ActionListener is implemented
		// Every tick of the clock will now run the actionPerformed method
		this.addKeyListener(this);
		this.setFocusable(true);

		timer = new Timer(1000 / 60, this);
		timer.addActionListener(this);
		timer.start();
	}

	// Method that must be implemented since the
	// class implements ActionListener
	
	public void actionPerformed(ActionEvent e) {
		Color swap;
		// checks if the circle hits any boundary
		for (int i = 0; i < shapelist.size(); i++) {
			Shape shape1 = shapelist.get(i);
			System.out.println(shape1.getRect().getCenterX() + (shape1.getRect().width)/2);
			if (shape1.getRect().getCenterX() + (shape1.getRect().width)/2 >= FRAME_WIDTH || shape1.getRect().getCenterX() -(shape1.getRect().width)/2 <= 0)
			{
				shape1.dx *= -1;
				System.out.println("rec");
			}
			else if(shape1.getRect().getCenterY() + (shape1.getRect().height)/2 >= FRAME_HEIGHT || shape1.getRect().getCenterY() -(shape1.getRect().height)/2 <= 0)
			{
				shape1.dy *= -1;
				System.out.println("here");
			}
			
			
			// check if circle hits another circle
			// bounce circles off each other and swap colors
			for (int j = 0; j < shapelist.size(); j++) {
				Shape shape2 = shapelist.get(j);
				if (shape1.getRect().intersects(shape2.getRect())) {
					
					if (!(shape1.getRect()).equals(shape2.getRect())) {
						shape1.dx = shape1.dx * -1;
						shape1.dy = shape1.dy * -1;
						shape2.dx = shape2.dx * -1;
						shape2.dy = shape2.dy * -1;
						
						swap = shape1.getFillColor();
						shape1.setFillColor(shape2.getFillColor());
						shape2.setFillColor(swap);
					}
				}
			}
			shapelist.get(i).moveLoc(shape1.dx, shape1.dy);
		}	
		// call repaint
		repaint();
	}


	// Panel constants

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// call super class paintComponent method
		// background will not be colored otherwise

		// for loop runs through the arraylist and draws each shape from the
		// arraylist
		for (Shape s : shapelist) {
			s.draw(g);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int x = random.nextInt(600);
		int y = random.nextInt(600);
		int height = random.nextInt(100);
		int width = random.nextInt(100);
		int radius = random.nextInt(30);
		Color rancolor = new Color(random.nextInt(256), random.nextInt(256),
				random.nextInt(256));
		// constructing the shapes using the random variables initialized above
		Shape circle = new Cir(rancolor, x, y, radius);
		Shape rec = new Rec(rancolor, 300, 300, height, width);
		Shape square = new Square(rancolor, x, y, height);

		// if statements to detect which key was pressed: c, s, or r and adds
		// the shape to the arraylist
		if (e.getKeyCode() == KeyEvent.VK_C) {
			shapelist.add(circle);
			// System.out.println("C");//code to check if program registered the
			// key press
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			shapelist.add(rec);
			// System.out.println("R");
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			shapelist.add(square);
			// System.out.println("S");
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
	//public static void main(String[] args) {
		//JPanel shapeDriver = new ShapeDriver();
//	}

}
