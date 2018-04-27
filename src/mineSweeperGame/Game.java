package mineSweeperGame;

import java.util.Arrays;
import java.util.Random;

/*
 * MineSweeper, construct initialize a 10X10 board with 16 random distributed mines
 */
public class Game {
	private int width;
	private int height;
	private int numOfMines;
	
	private char[][] field;
	private char[][] display;
	
	private boolean isDone = false;
	private boolean isWin = false;
	
	public Game(int width, int height, int num) {
		System.out.println("Generating the mine field..");
		this.width = width;
		this.height = height;
		this.numOfMines = num;
		
		field = new char[width][height];
		display = new char[width][height];
		
		System.out.println("Clearing mine field..");
		clearMineField();
		placeMines();
		
		update();
		
	}
	
	private void update() {
		System.out.println("After initializing...");
		drawMineField(display);
		System.out.println();
		drawMineField(field);
	}
	
	private void placeMines() {
		int minesPlaced = 0;
		Random random = new Random();
		while (minesPlaced < numOfMines) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			if (field[x][y] != '*') {
				field[x][y] = '*';
				minesPlaced++;
			}
		}
	}
	
	private void drawMineField(char[][] board) {
		for (int x = 0; x < width; x++) {
			System.out.println(Arrays.toString(board[x]));
		}
		System.out.println("");
	}
	
	private void clearMineField() {
		// set each square to a space character
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				field[x][y] = '?';
				display[x][y] = '?';
			}
		}
	}
	
	public void detect() {
		for (int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if (field[x][y] == ' ') {
					int num = minesNear(x, y);
					display[x][y] =(char) (num + 48); // '0' Ascii value is 48
				}
			}
		}
	}
	
	public int minesNear(int x, int y) {
		// return how many mines nearby
		int num = 0;
		num += mineAt(x - 1, y); // W
		num += mineAt(x + 1, y); // E
		num += mineAt(x - 1, y - 1); // NW
		num += mineAt(x + 1, y + 1); // SE
		num += mineAt(x, y - 1); // N
		num += mineAt(x, y + 1); // S
		num += mineAt(x - 1, y + 1); // NE
		num += mineAt(x + 1, y - 1); // SW
		return num;
	}
	
	public int mineAt(int x, int y) {
		if (x >= 0 && x < width && y >= 0 && y < height && field[x][y] == '*')
			return 1;
		else 
			return 0;
	}
	
	public void turn(int x, int y) {
		// get user's coordinates and asjust the board display
		if (field[x][y] == '?') { // the tile hasn't been revealed
			isDone = false;
			display[x][y] = ' ';
			field[x][y] = ' ';
		} 
		else if (field[x][y] == '*') { // a mine being revealed, play loses
			isDone = true;
			isWin = false;
			System.out.println("You lose!");
		}
		else if (field[x][y] == ' ' && display[x][y] == ' ') {
			isDone = false;
			System.out.println("This tile's been cleared before!");
		}
	}
	
	public void isVictory() {
		// determines if a player wins or not by counting how many tiles left to clear
		int tiles = 0;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (field[x][y] == '?') {
					tiles++;
				}
			}
		}
		if (tiles != 0) {
			isWin = false;
		}
		else {
			isWin = true;
			isDone = true;
		}
	}
	
	public void onEnd() {
		// print display after each round
		drawMineField(display);
	}
	
	public boolean getDone() {
		return this.isDone;
	}
	
	public boolean getWin() {
		return this.isWin;
	}
}
