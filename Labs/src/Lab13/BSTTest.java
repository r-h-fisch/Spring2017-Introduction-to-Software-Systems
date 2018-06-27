package Lab13;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class BSTTest {

	@Test
	public void testFailure() throws Exception {
		  
	}
	
	@Test
	public void walk() {
		//test1
		BST<Integer, Character> test = new BST<Integer, Character>();
		test.put('a', 1);
		test.put('d', 2);
		test.put('c', 3); 
		test.put('b', 4);
		//"a d c b "
		
		//test2
		BST<Integer, Character> test2 = new BST<Integer, Character>();
		
		assertEquals(test.walk(),"a d c b ");
		assertEquals(test2.walk(),"Empty tree");
		
	}
	
	

}
