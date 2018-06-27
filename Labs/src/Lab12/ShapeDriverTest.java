package Lab12;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import java.util.Random;
public class ShapeDriverTest {

	@Test
	public void testFailure() throws Exception {
		  
	}
	/*@Test
	public void keyPressed(KeyEvent e){
		ArrayList<Shape> shapelist = new ArrayList<Shape>();
		Random random = null;
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
		assertEquals(e.getKeyCode() == KeyEvent.VK_C, shapelist.add(circle));
	}*/

}
