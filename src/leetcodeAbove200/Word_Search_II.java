package leetcodeAbove200;

import java.util.*;
//212. Word Search II 
//Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//For example,
//Given words = ["oath","pea","eat","rain"] and board =
//
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//Return ["eat","oath"].

public class Word_Search_II {
	/*
	 * Leetcode AC 66 ms, among top 55% java submissions
	 * time complexity: findWords method takes O(m * n), dfs method calls trie.search() method which takes O(keyOfString)
	 * so the total complexity would be O(m * n * keyOfString)
	 */
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<String>();
		if (board == null || board.length == 0 || words == null || words.length == 0) {
			return new ArrayList<String>();
		}

		Trie trie = new Trie();
		for (String s : words) {
			//System.out.println("s is: " + s);
			trie.insert(s);
			//System.out.println("t or f: " + trie.search(s));
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//System.out.println("Inside loops");
				dfs(result, board, "", i, j, trie, visited);
			}
		}

		return new ArrayList<String>(result);
	}

	private void dfs(Set<String> result, char[][] board, String str, int x, int y, Trie trie, boolean[][] visited) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
			return;
		}
		str += board[x][y];
		if (!trie.startsWith(str)) {
			return;
		}
		
		//System.out.println("trie is: " + trie.search("oath"));

		if (trie.search(str)) {
			result.add(str);
			//System.out.println("strs is: " + str);
		}

		visited[x][y] = true;
		
		dfs(result, board, str, x + 1, y, trie, visited);
		dfs(result, board, str, x - 1, y, trie, visited);
		dfs(result, board, str, x, y + 1, trie, visited);
		dfs(result, board, str, x, y - 1, trie, visited);
		
		visited[x][y] = false;
	}
	private class TrieNode {
	    TrieNode[] arr;
	    boolean isEnd;
	    
	    public TrieNode() {
	    		this.arr = new TrieNode[26];
	    }
	}
	
	private class Trie {
	    private TrieNode root;
	    
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    // Insert a word into a trie
	    public void insert(String word) {
		    	TrieNode p = root;
		    	for (int i = 0; i < word.length(); i++) {
		    		char c = word.charAt(i);
		    		int index = c - 'a';
		    		if (p.arr[index] == null) {
		    			TrieNode temp = new TrieNode();
		    			p.arr[index] = temp;
		    			p = temp;
		    		}else {
		    			p = p.arr[index];
		    		}
		    		if (i == word.length() - 1) 
		    			p.isEnd = true;
		    	}
	    }
	    
	    
	    
	    // Return if the word is in the trie
	    public boolean search(String word) {
		    	TrieNode p = searchNode(word);
		    	if (p == null) {
		    		return false;
		    	} 
		    	else {
		    		if (p.isEnd) {
		    			return true;
		    		}
		    		return false;
		    	}
	    }
	    
	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
		    	TrieNode p = searchNode(prefix);
		    	if (p == null) {
		    		return false;
		    	}else 
		    		return true;
	    }
	    
	    public TrieNode searchNode(String s) {
		    	TrieNode p = root;
		    	for (int i = 0; i < s.length(); i++) {
		    		char c = s.charAt(i);
		    		int index = c - 'a';
		    		if (p.arr[index] == null) {
		    			return null;
		    		}else {
		    			p = p.arr[index];
		    		}
		    	}
		    	if (p == root) {
		    		return null;
		    	}
		    	return p;
		}
	}
	
	public static void main(String[] args) {
		Word_Search_II wsi = new Word_Search_II();
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = { "oath","pea","eat","rain" };
		List<String> res = wsi.findWords(board, words);
		res.stream().forEach(s -> System.out.print(s + " ")); // ["oath", "eat"]
	}
}