package Lab9;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class ShapeDriver extends JPanel implements ActionListener, KeyListener {
	private Timer timer;
	public final int FRAME_WIDTH = 600;
	public final int FRAME_HEIGHT = 600;
	private ArrayList<Shape> shapelist = new ArrayList<Shape>();
	private Random random;
	private Circle circle;

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

		timer = new Timer(1000/60, this);
		timer.addActionListener(this);
		timer.start();
	}

	// Method that must be implemented since the
	// class implements ActionListener
	public void actionPerformed(ActionEvent e) {
		Color swap;
		// checks if the circle hits any boundary
		for (int i = 0; i < shapelist.size(); i++) {
			Circle c = (Circle) shapelist.get(i);
			if (c.center.x + c.getRad() >= FRAME_WIDTH || c.center.x - c.getRad() <= 0)
			{
				c.dx *= -1;
			}
			else if(c.center.y + c.getRad() >= FRAME_HEIGHT
					|| c.center.y - c.getRad() <= 0 )
			{
				c.dy = c.dy* -1;
			}
			// check if circle hits another circle
			// bounce circles off each other and swap colors
			for (int j = 0; j < shapelist.size(); j++) {
				if (((Circle)shapelist.get(i)).distance((Circle)shapelist.get(j)) <= (shapelist.get(i).getRad() + shapelist.get(j).getRad())) {
					//System.out.println("outside");
					if (!((shapelist.get(i)).equals(shapelist.get(j)))) {
						//System.out.println("Here");
					//} else {
						//System.out.println("inside");
						shapelist.get(i).dx = shapelist.get(i).dx * -1;
						shapelist.get(i).dy = shapelist.get(i).dy * -1;
						shapelist.get(j).dx = shapelist.get(j).dx * -1;
						shapelist.get(j).dy = shapelist.get(j).dy * -1;
						
						//shapelist.get(j).direction = shapelist.get(j).direction* -1;
						swap = shapelist.get(i).getFillColor();
						shapelist.get(i).setFillColor(shapelist.get(j).getFillColor());
						shapelist.get(j).setFillColor(swap);
					}
				}
			}
			shapelist.get(i).moveLoc(c.dx, c.dy);
		}	
		// call repaint
		this.repaint();
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
		int radius = random.nextInt(15);
		Color rancolor = new Color(random.nextInt(256), random.nextInt(256),
				random.nextInt(256));
		// constructing the shapes using the random variables initialized above

		// if statements to detect which key was pressed: c, s, or r and adds
		// the shape to the arraylist
		if (e.getKeyCode() == KeyEvent.VK_C) {

			circle = new Circle(rancolor, x, y, radius);
			shapelist.add(circle);
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
