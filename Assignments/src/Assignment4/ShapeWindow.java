package Assignment4;

////////////////////////////////////////////////////////////////////////////////////
//
//C212 Spring 17
//
//Homework 4 Template
//Rebecca Fisch
//
///////////////////////////////////////////////////////////////////////////////////

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

/*
 * Main application for random shape generator app
 */
public class ShapeWindow extends JFrame {

	JPanel shapeDriver;
	

	public ShapeWindow() {
		// setting up the frame
		setTitle("Random Shapes");
		setVisible(true);
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//establishing key listener  
		ShapeDriver sd = new ShapeDriver();
		add(sd);
		addKeyListener(sd);
	}

	public static void main(String[] args) {
		// run main application
		JFrame shapeWindow = new ShapeWindow();
		
	}
}
