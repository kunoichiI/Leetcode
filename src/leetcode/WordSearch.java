package leetcode;
/*
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.
	
	For example,
	Given board =
	
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.

 */
public class WordSearch { // O(MN) time, O(MN) space
	public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                    if (find(board, i, j, word, 0, visited))
                        return true;
            }
        }
        return false;
    }
    
    private static boolean find(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        if (idx == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx) || visited[i][j])
            return false;
        visited[i][j] = true;
        
        if (find(board, i + 1, j, word, idx + 1, visited) || find(board, i - 1, j, word, idx + 1, visited) || find(board, i, j + 1, word, idx + 1, visited) || find(board, i, j - 1, word, idx + 1, visited)) return true;
        
        visited[i][j] = false; // backtracking
        return false;
    }
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		System.out.println(exist(board, "ABCCED")); // true
		System.out.println(exist(board, "SEE")); // true
		System.out.println(exist(board, "see")); // false
		System.out.println(exist(board, "ABCB")); // false
	}
	
	/*
	 * 解题思路： 和Number of Islands很像的题目，不同的是这回我们要匹配每一个String的字符，如果不同则访问其他的
	 * neighbor，DFS + visited 二维数组，记得要backtracking，因为每次遍历后，下回可能还会需要到某些字符。如果不
	 * backtrack就会出错，因为有些字符没法再次访问！
	 */

}
