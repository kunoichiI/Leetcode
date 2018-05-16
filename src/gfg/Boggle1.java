package gfg;
/*
 * ref: https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 * Boggle (Find all possible words in a board of characters) | Set 1
 * Similar to Leetcode 79. Word Search
	Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
	
	Example:
	
	Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
	       boggle[][]   = {{'G','I','Z'},
	                       {'U','E','K'},
	                       {'Q','S','E'}};
	      isWord(str): returns true if str is present in dictionary
	                   else false.
	
	Output:  Following words of dictionary are present
	         GEEKS
	         QUIZ
 */
public class Boggle1 {
	public static void findWords(String[] dict, char[][] boggle) {
		int m = boggle.length, n = boggle[0].length;
		boolean[][] visited = new boolean[m][n];
		StringBuilder sb = new StringBuilder();
		
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				findWordsHelper(boggle, dict, row, col, visited, sb);
			}
		}
	}
	
	private static void findWordsHelper(char[][] boggle, String[] dict, int i, int j, boolean[][] visited, StringBuilder sb) {
		visited[i][j] = true;
		sb.append(boggle[i][j]);
		
		if (isWord(sb.toString(), dict)) System.out.println(sb.toString());
		
		for (int row = i - 1; row <= i + 1; row++) {
			for (int col = j - 1; col <= j + 1; col++) {
				if (row >= 0 && row < boggle.length && col >= 0 && col < boggle[0].length && !visited[row][col])
					findWordsHelper(boggle, dict, row, col, visited, sb);
			}
		}
		
		visited[i][j] = false; // backtracking
		sb.deleteCharAt(sb.length() - 1);
	}
	
	private static boolean isWord(String str, String[] dict) {
		for (String word: dict) {
			if (str.equals(word)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		char boggle[][]   = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		String[] dict = {"GEEKS", "FOR", "QUIZ", "GO"};
		findWords(dict, boggle);
	}

}
