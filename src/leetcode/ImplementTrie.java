package leetcode;

// Leetcode 208
// See improved version of implementing trie -- to word_search_II.java
import java.util.HashMap;

class Node {  //TrieNode
	char c; 
	HashMap<Character, Node> children = new HashMap<>();
	boolean isLeaf;
	
	public Node() {}
	
	public Node(char c) {
		this.c = c;
	}
}

	
public class ImplementTrie {
	
	
	// Insert a word into the trie
	public static void insert(String word, Node root) {
		HashMap<Character, Node> children = root.children;
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node t;
			if (children.containsKey(c)) {
				t = children.get(c);
			}else {
				t = new Node();
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
	public static boolean search(String word, Node root) {
		Node t = searchNode(word, root);
		if (t != null && t.isLeaf) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Node searchNode(String str, Node root) {
		HashMap<Character, Node> children = root.children;
		Node t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)){
				t = children.get(c);
				//System.out.print(children.entrySet());
				
				children = t.children;
			}else {
				return null; // trie not contains this string
			}
		}
		return t;
	}
	
	// if there is any word in the trie starts with given prefix
	public static boolean startWith(String prefix, Node root) {
		if (searchNode(prefix, root) == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public static void outputTrie(Node root, String path) {
		Node t = root;
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
		Node root  = new Node();
		Node nodeT = new Node('t');
		Node nodeA = new Node('a');
		Node nodeI = new Node('i');
		root.children.put('t',nodeT);
		root.children.put('a',nodeA);
		root.children.put('i', nodeI);
		
		Node nodeO = new Node('o');
		Node nodeN = new Node('n');
		nodeT.children.put('o', nodeO);
		nodeI.children.put('n',nodeN);
		nodeO.isLeaf = true;
		nodeN.isLeaf = true;
		nodeA.isLeaf = true;
		insert("here", root);
		outputTrie(root, " ");
		System.out.print(startWith("he", root));
	}

}
