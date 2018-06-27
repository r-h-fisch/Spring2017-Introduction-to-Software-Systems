package Lab9;

////////////////////////////////////////////////////////////////////////////////////
//
//C212 Spring 17
//
//Lab 9
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
		setTitle("Moving Circles");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shapeDriver = new ShapeDriver();
		add(shapeDriver);

		setVisible(true);
	}

	public static void main(String[] args) {
		// run main application
		JFrame shapeWindow = new ShapeWindow();

	}
}
