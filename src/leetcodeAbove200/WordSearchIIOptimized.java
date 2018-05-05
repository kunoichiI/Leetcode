package leetcodeAbove200;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIIOptimized {
	/*
	 * Leetcode AC 25ms, time complexity: O(m * n), trie insertion has been put in findWords method
	 * so time improved a lot!
	 * space complexity: O(26 * keysOfString + NumOfWords) = O(N) linear space
	 */
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		
		TrieNode root = new TrieNode();
		for (String word: words) {
			TrieNode node = root;
			for (char c: word.toCharArray()) {
				int idx = c - 'a';
				if (node.children[idx] == null) 
					node.children[idx] = new TrieNode();
				node = node.children[idx];
			}
			node.word = word;
		}
		
		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
		return result;
	}
	
	private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
		char c = board[i][j];
		if (c == '#' || (node = node.children[c - 'a']) == null) return;
		
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		
		board[i][j] = '#';
		if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
		board[i][j] = c; // backtracking
	}
	
	private class TrieNode {
	    public String word = null;
	    public TrieNode[] children = new TrieNode[26];

	}
	public static void main(String[] args) {
		WordSearchIIOptimized ws = new WordSearchIIOptimized();
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = { "oath","pea","eat","rain" };
		List<String> res = ws.findWords(board, words);
		res.stream().forEach((s -> System.out.print(s + " "))); // ["oath", "eat"]
	}

}
