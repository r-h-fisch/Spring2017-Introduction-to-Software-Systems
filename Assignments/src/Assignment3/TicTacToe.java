package Assignment3;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		GameboardandPlayer test = new GameboardandPlayer();
		test.printBoard();
		System.out.println(PlayGame());
	}

	private static String PlayGame() {
		GameboardandPlayer game = new GameboardandPlayer();
		char player1 = 'O';
		char player2 = 'X';
		char currentplay = ' ';
		int count = 0;
		boolean continuegame = true;
		boolean play = false;
		int row = 0;
		int col = 0;
		String display = "";
		Scanner scan = new Scanner(System.in);

		while (continuegame) {
			if (count % 2 == 0) {
				currentplay = player1;
			} else {
				currentplay = player2;
			}

			count++;
			
			System.out.println("Player "
							+ currentplay
							+ ", input the cordinates(x,y) of your next move using a comma to seperate the numbers: ");
			String cordinates = "";
			cordinates = scan.nextLine();
			while(cordinates.length() > 3 || cordinates.length() < 1 ){
				System.out.println("Invalid input, try again:");
				cordinates = scan.nextLine();
			}
			if(cordinates.charAt(1) != ','){
				System.out.println("Invalid input, please seperate your numbers with a , :");
				cordinates = scan.nextLine();
			}
			if (cordinates.charAt(0)> 51 ||cordinates.charAt(0)< 49 || cordinates.charAt(2)>51 ||cordinates.charAt(2)<49 ) {
				System.out
						.println("Invalid input, please input a number from range 1 to 3:");
				cordinates = scan.nextLine();
			}
			row = getCordinateRow(cordinates);
			col = getCordinateCol(cordinates);

			
			play = game.makePlay(col, row, currentplay);
			game.printBoard();
			if (count >= 4) {
				continuegame=play;
			}
			if (count >= 9) {
				display = "It's a Tie!";
				continuegame = false;
			}
			else {
				display= "Player "+ currentplay + " Wins!";
			}

		}

		return display;
	}

	public static int getCordinateRow(String input) {
		String[] cord = input.split(",");
		int row = Integer.parseInt(cord[0]) - 1;
		return row;
	}

	public static int getCordinateCol(String input) {
		String[] cord = input.split(",");
		int col = Integer.parseInt(cord[1]) - 1;
		return col;
	}

}
