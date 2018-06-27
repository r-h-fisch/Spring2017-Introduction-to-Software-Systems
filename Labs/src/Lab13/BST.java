package Lab13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	// inner Node class
	// note: an outer class has direct access to values in an inner class
	private class Node {
		private Key key;
		private Value value;
		private Node lChild; // left child
		private Node rChild; // right child

		// number of nodes at this subtree
		// the value of N for the root will be # of nodes in entire tree
		// the value of N for a leaf node would be 1
		public int N; // N=size of tree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.value = val;
			this.N = N;
		}
	}

		public int size() {
			int result=0;
			if (root == null){
				result= 0;
			}
			else{
				result= root.N;}
			return result;
		} // returns # of nodes in the tree

		// returns the value associated with they key
		// returns null if the key is not in the tree
		public Value get(Key key) {
			Node n = root;
			while (n != null) {
				int k = key.compareTo(n.key);

				if (k < 0) // key < n.key
					n = n.lChild;

				else if (k > 0) // key > n.key
					n = n.rChild;

				else
					// key == n.key
					return n.value;
			}
			return null;

		}

		public void put(Value val, Key key) {
			 root = helpput(root, key, val);
		}// inserts the key value pair into the tree
		
		//put method's helper function
		private Node helpput(Node x, Key key, Value val) {
	        if (x == null) return new Node(key, val, 1);
	        int k = key.compareTo(x.key);
	        if (k < 0) {
	        	x.lChild = helpput(x.lChild, key, val);
	        }
	        else if (k > 0){
	        	x.rChild = helpput(x.rChild, key, val);
	        }
	        else{
	        	x.value = val;
	        }
	        x.N =  size() + 1; //x.lChild.size() + x.rChild.size() 
	        return x;
	    }

	// performs an in order walk of the tree printing the values
	public String walk() {
		String result="";
		if(root == null){
	        result="Empty tree";}
	    else
	    {
	        Queue<Node> q= new LinkedList<Node>();
	        q.add(root);
	        while(q.peek() != null)
	        { Node temp = q.remove();
	           result += (get(temp.key)+ " ");
	        //System.out.print(get(temp.key)+ " ");
	            if(temp.lChild != null)
	                q.add(temp.lChild);
	            if(temp.rChild != null)
	                q.add(temp.rChild);
	        }
	    }
		return result;
	}

	// here are some of the test cases I performed
	public static void main(String[] args) {
		Random rand = new Random();
		BST<Integer, Character> tree = new BST<Integer, Character>();
		for (int i = 0; i < 25; i++) {
			int key = rand.nextInt(26) + 'a';
			char val = (char) key;
			tree.put(val, key);
		}
		// note: not all of these chars will end up being generated from the for
		// loop
		// some of these return values will be null
		System.out.println(tree.get((int) 'a'));
		System.out.println(tree.get((int) 'b'));
		System.out.println(tree.get((int) 'c'));
		System.out.println(tree.get((int) 'f'));
		System.out.println(tree.get((int) 'k'));
		System.out.println(tree.get((int) 'x'));
		BST<Integer, Character> test = new BST<Integer, Character>();
		test.put('a', 1);
		test.put('d', 2);
		test.put('c', 3); 
		test.put('b', 4);
		/*System.out.println(test.walk());
		BST<Integer, Character> test2 = new BST<Integer, Character>();
		System.out.println(test2.walk());*/
		
	}
	}
	
