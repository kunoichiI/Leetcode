package leetcode;

//37. Sudoku Solver  
//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//Empty cells are indicated by the character '.'.
//
//You may assume that there will be only one unique solution.

public class Sudoku_Solver {
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) { // Try 1 through 9 in this cell
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c) {
        // check column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) 
                return false;
        }
        
        // check row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) 
                return false;
        }
        
        // check sub matrix 3*3
        for (int row = (i/3) * 3; row < (i/3)*3 + 3; row++) {
            for (int col = (j / 3) *3; col < (j/ 3) *3 + 3; col++) {
                if (board[row][col] == c)
                    return false;
            }
        }
        return true;
    }
}
