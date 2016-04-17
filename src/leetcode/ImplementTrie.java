package leetcode;

import java.util.HashMap;



	
public class ImplementTrie {
//	public class Trie {
//		private TrieNode root;
//		public Trie() {
//			root = new TrieNode();
//		}
//	}
	
	// Insert a word into the trie
	public static void insert(String word, TrieNode root) {
		HashMap<Character, TrieNode> children = root.children;
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			}else {
				t = new TrieNode();
				children.put(c, t);
			}
			children = t.children;
			// set leaf node
			if (i == word.length() - 1) {
				t.isLeaf = true;
			}
		}
	}
	
	// search if the given word is in the trie
	public static boolean search(String word, TrieNode root) {
		TrieNode t = searchNode(word, root);
		if (t != null && t.isLeaf) {
			return true;
		}else {
			return false;
		}
	}
	
	public static TrieNode searchNode(String str, TrieNode root) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)){
				t = children.get(i);
				children = t.children;
			}else {
				return null; // trie not contains this string
			}
		}
		return t;
	}
	
	// if there is any word in the trie starts with given prefix
	public static boolean startWith(String prefix, TrieNode root) {
		if (searchNode(prefix, root) == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public static void outputTrie(TrieNode root, String path) {
		TrieNode t = root;
		if (t.isLeaf == false) {
			for (Character c: t.children.keySet()) {
				String childPath = path + "->" + c;
				outputTrie(t.children.get(c), childPath);
			}
		}else{
			System.out.println(path);
		}
	}
	public static void main(String[] args) {
		// create a trie here
		TrieNode root  = new TrieNode();
		TrieNode nodeT = new TrieNode('t');
		TrieNode nodeA = new TrieNode('a');
		TrieNode nodeI = new TrieNode('i');
		root.children.put('t',nodeT);
		root.children.put('a',nodeA);
		root.children.put('i', nodeI);
		
		TrieNode nodeO = new TrieNode('o');
		TrieNode nodeN = new TrieNode('n');
		nodeT.children.put('o', nodeO);
		nodeI.children.put('n',nodeN);
		nodeO.isLeaf = true;
		nodeN.isLeaf = true;
		nodeA.isLeaf = true;
		outputTrie(root, " ");
		ImplementTrie it = new ImplementTrie();
		
	

	}

}
