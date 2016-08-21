package leetcode;

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
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<String>();
		if (board == null || board.length == 0 || words == null || words.length == 0) {
			return new ArrayList<String>();
		}

		Trie trie = new Trie();
		for (String s : words) {
			trie.insert(s);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
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

		if (trie.search(str)) {
			result.add(str);
		}

		visited[x][y] = true;
		
		dfs(result, board, str, x + 1, y, trie, visited);
		dfs(result, board, str, x - 1, y, trie, visited);
		dfs(result, board, str, x, y + 1, trie, visited);
		dfs(result, board, str, x, y - 1, trie, visited);
		
		visited[x][y] = false;
	}
}

class TriNode {
    public char c;
    public HashMap<Character, TriNode> children;
    public boolean isLeaf;
    
    public TriNode() {
        children = new HashMap<Character, TriNode>();
    }
}

class Trie {
    private TriNode root;
    public Trie() {
        root = new TriNode();
    }
    
    public void insert(String word) {
        HashMap<Character, TriNode> children = root.children;
        
        for (int i = 0; i < word.length(); i++) {
            TriNode t;
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                t = new TriNode();
                children.put(c, t);
            }else {
                t = children.get(c);
            }
            children = t.children;
            if (i == word.length() - 1) 
                t.isLeaf = true;
        }
    }
    
    public boolean search(String word) {
        TriNode t = searchNode(word);
        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }
    
    public TriNode searchNode(String str) {
        HashMap<Character, TriNode> children = root.children;
        TriNode t = null;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!children.containsKey(c)) {
                return null;
            }else {
                t = children.get(c);
                children = t.children;
            }
        }
        return t;
    }
    
    public boolean startsWith(String word) {
        if (searchNode(word) == null) 
            return false;
        else 
            return true;
    }
}