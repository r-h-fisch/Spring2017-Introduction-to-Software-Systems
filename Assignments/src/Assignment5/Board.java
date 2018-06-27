package Assignment5;

/*************************************************************************
 * Name: Rebecca Fisch        
 * 
 * Homework 5:  N-puzzle problem  
 * 
 * Released:  10/21/16
 * 
 * Add as many private helper functions as you want
 *
 *************************************************************************/

import static java.lang.Math.*;

import java.util.Arrays;

public class Board {

	// 2-d array to represent puzzle
	private final int[][] board;

	private final int N; // Depth of array

	/*
	 * I, J are indices in the board where the blank square is located. Saving
	 * this will be helpful for neighbors method blank square is represented
	 * with the value 0
	 */
	private int I;
	private int J;

	// initialize NxN Puzzle Board
	/*
	 * TO-DO Copy blocks into board instance field Save i,j index where the
	 * blank square is
	 */
	public Board(int[][] blocks) {
		N = blocks.length;
		board = copy(blocks);
	}

	private int[][] copy(int[][] blocks) {
		int[][] newcopy = new int[N][N];
		int newi = 0;
		int newj = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				newcopy[r][c] = blocks[r][c];
				if (blocks[r][c] == 0) {
					newi = r;
					newj = c;
				}
			}
		}
		I = newi;
		J = newj;
		return newcopy;
	}

	// return board dimension
	public int dimension() {
		return N;
	}

	// return # of blocks out of position
	public int hamming() {
		int numOfDiffBlocks = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != c + r * N + 1) {
					numOfDiffBlocks++;
				}
			}
		}
		return --numOfDiffBlocks; // blank block will always be out of place
	}

	// helper function for manhattan()
	private int moves(int r, int c) {
		int goalc = board[r][c] % N;
		int goalr = board[r][c] / N;
		if (goalc == 0) {
			goalr -= 1;
			goalc = N - 1;
		} else {
			goalc -= 1;
		}
		return Math.abs(r - goalr) + Math.abs(c - goalc);
	}

	// return Manhattan distances between blocks and goal
	public int manhattan() {
		int dis = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != j + i * N + 1 && board[i][j] != 0) {
					dis += moves(i, j);
				}
			}
		}
		return dis;
	}

	// is this Board the goal board?
	public boolean isGoal() {
		return manhattan() == 0;
	}

	/*
	 * swaps any two numbers next to each other - itterate through the board,
	 * and swap first two numbers next to each other (not including the blank
	 * square) twin sends the coordinates of the swap to swap() where the
	 * swaping in the board happens
	 */
	public Board twin() {
		int[][] twin = copy(board);
		Board b = new Board(twin);
		for (int r = 0; r< twin.length; r++) {
			for (int c = 0; c < twin.length - 1; c++) {
				if ((twin[r][c]) != 0 && twin[r][c] != 0) {
					b = new Board(swap(twin, r, c, r, c + 1));
					//System.out.println(b.toString());
				}
			}
		}
		return b;
	}


	// helper function to twin() it swaps the blocks
	private int[][] swap(int[][] twin, int x, int y, int m, int n) {
		int s = twin[x][y];
		twin[x][y] = twin[m][n];
		twin[m][n] = s;
		// System.out.println(this.board.toString());
		return twin;
	}

	// Hint: if two boards have equal strings then they are equal
	@Override
	public boolean equals(Object other) {
		boolean result;
		if (other.toString().equals(this.toString())) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/*
	 * all neighboring boards – all the possible moves that can be made from
	 * the current board Can only swap numbers (blocks) with the blank square -
	 * From the index of the blank square, swap with all blocks above, below,
	 * left, and right (that are in bounds) - Create a new board for each of
	 * these and add them all to the stack
	 */
	public Stack<Board> neighbors() {
		Stack<Board> boards = new Stack<Board>();
		boolean blank = false;
		for (int i = 0; i < N && !blank; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					if (i > 0)
						neihelper(boards, i - 1, j, i, j);
					if (j > 0)
						neihelper(boards, i, j - 1, i, j);
					if (i < N - 1)
						neihelper(boards, i + 1, j, i, j);
					if (j < N - 1)
						neihelper(boards, i, j + 1, i, j);
					blank = true;
					break;
				}  
			}
		}
		return boards;
	}

	// neighbors helper function 
	private void neihelper(Stack<Board> s, int x, int y, int m, int n) {
		int[][] neighborblock = copy(board);
		swap(neighborblock, x, y, m, n);
		s.push(new Board(neighborblock));
	}

	// returns board as a string
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(N + "\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				str.append(String.format("%2d ", board[i][j]));
			}
			str.append("\n");
		}
		return str.toString();
	}

	// test client
	public static void main(String[] args) {
		int[][] b = { { 8, 1, 3 }, { 4, 0, 2 }, { 7, 6, 5 } };
		int[][] c = { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
		// int[][] board = {{1, 0}, {2, 3}};
		Board a = new Board(b);
		Board test2 = new Board(c);
		System.out.println("Dimention: " + a.dimension());
		System.out.println("Hamming result: " + a.hamming());
		System.out.println("Manhattan result: " + a.manhattan());
		System.out.println(test2.toString());
		// int[][] d = a.copy(b);
		// System.out.println(d.toString());
		//System.out.println(test2.twin());
		/*
		 * for (Board board: a.neighbors()) {
		 * System.out.println(board.toString()); }
		 */
	}
}