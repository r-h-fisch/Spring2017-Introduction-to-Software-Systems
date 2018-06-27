package Assignment3;
import java.util.Scanner;

public class GameboardandPlayer {

	public char[][] board = new char[3][3];

	public GameboardandPlayer() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
	}
	public int getrowamount() {
		return board.length;
	}

	public int getcolamount() {
		return board[0].length;
	}

	public void printBoard() {

		for (int row = 0; row < getrowamount(); row++) {
			for (int col = 0; col < getcolamount(); col++) {

				
				System.out.print(" " + getCellContents(row, col));
				if (col < getcolamount() - 1) {
					System.out.print(" |");
				}
			}
			if (row < getrowamount() - 1) {
				System.out.println();
				System.out.println("------------");
			}
		}
		System.out.println();
	}

	public boolean makePlay(int row, int col, char player) {
		TicTacToe ttt= new TicTacToe();
		String newcord="";
		while (getCell(row, col) != ' ') {
				
				System.out.print("There is already a character in this spot. Enter another cordinate: ");
				Scanner input = new Scanner(System.in);
				newcord=input.nextLine();
				col=ttt.getCordinateRow(newcord);
				row=ttt.getCordinateCol(newcord);//this is switched because i mixed up the cordinates and did not want to change every instance where they appeared
			} 
		return place(row, col, player);
	}

	

	private int getRow(int cell) {
		return cell / 10;
	}

	private int getCol(int cell) {
		return cell % 10;
	}

	public boolean place(int row, int col, char player) {
		board[row][col] = player;
		return Winner(row, col, player);
	}

	public char getCell(int row, int col) {
		return board[row][col];
	}

	public char getCellContents(int row, int col) {
		return board[row][col];
	}

	private boolean checkLeftD(char symbol) {
		return (board[0][0] == symbol) && (board[0][0] == board[1][1])
				&& board[1][1] == board[2][2];
	}

	private boolean checkRightD(char symbol) {
		return (board[0][2] == symbol) && (board[0][2] == board[1][1])
				&& (board[1][1] == board[2][0]);
	}

	public boolean Winner(int r, int c, char player) {
		int row = getRow(r);
		int col = getCol(c);
		int index;
		boolean playmore= true;
		
		if (checkRightD(player) || checkLeftD(player)) {
			 playmore= false;
		}
		for (index = 0; index < getcolamount(); index++) {
			if (board[row][index] != player) {
				break;
			}
		}
		if (index == 3){
			 playmore= false;}
		
		for (index = 0; index < getrowamount(); index++) {
			if (board[index][col] != player) {
				break;
			}
		}
			if (index == 3){
				 playmore= false;}
		
			return playmore;
		}
	}



