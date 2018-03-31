package mineSweeperGame;

import java.util.Arrays;

/*
 * MineSweeper, construct initialize a 10X10 board with 16 random distributed mines
 */
public class Game {
	private String[][] board;
	private String[][] display;
	public boolean isDone;
	public boolean isWin;
	
	private String unknown = " ? ";
	private String empty = "  ";
	private String mine = " * ";
	
	public Game(int row, int col) {
		board = new String[row][col];
		display = new String[row][col];
		
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ((i == 0 || i == board.length - 1) || (j == 0 || j == board.length - 1)) {
					display[i][j] = empty;
					board[i][j] = empty;
				}
				else {
					display[i][j] = unknown;
					board[i][j] = unknown;
				}	
			}
		}
	}
	
	public void generateMines(int num) {
		
	}
	
	public void printGame() {
		System.out.println(Arrays.toString(this.board));
	}
	
}
