package leetcode;

//36. Valid Sudoku  
//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
		return false;
        // check each column
        for (int i = 0; i < 9; i++) {
        	boolean[] m = new boolean[9];
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			if (m[(int) (board[i][j] - '1')]) {
        				return false;
        			}
				m[(int) (board[i][j] - '1')] = true;
        		}
        	}
        }
 
        //check each row
        for (int j = 0; j < 9; j++) {
        	boolean[] m = new boolean[9];
        	for (int i = 0; i < 9; i++) {
        		if (board[i][j] != '.') {
        			if (m[(int) (board[i][j] - '1')]) {
        				return false;
        			}
        			m[(int) (board[i][j] - '1')] = true;
        		}
        	}
        }
 
        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
        	boolean[] m = new boolean[9];
        	for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) { // 这个地方乘除都有讲究
        		for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
        			if (board[i][j] != '.') {
        				if (m[(int) (board[i][j] - '1')]) {
        					return false;
        				}
        				m[(int) (board[i][j] - '1')] = true;
        			}
        		}
        	}
        }
 
        return true;
    }
	/*
	 * 解题思路：在判断小方格是否valid时，k编号为0 ～ 8
	 * 要得到小方格中每一个index，则用k / 3 * 3 开始，纵坐标为 k % 3 * 3 开始
	 * 这个真的tricky
	 * 也可以用一个global hashset排除重复，每次check完后clear hashset，然后check下一轮
	 */
}
