package leetcode;
import java.util.*;
//211. Add and Search Word - Data structure design 
//Design a data structure that supports the following two operations:
//
//void addWord(word)
//bool search(word)
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
//For example:
//
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true

public class AddAndSearchWord {
private TrieNode root;
    
    public AddAndSearchWord() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    public boolean find(String word, int index, TrieNode now) {
        if (index == word.length()) {
            return now.hasWord;
        }
        
        Character c = word.charAt(index);
        if ('.' == c) {
            for (TrieNode child: now.getAllChildren()) {
                if (find(word, index+1, child)) {
                    return true;
                }
            }
        }else {
            TrieNode child = now.children.get(c);
            if (child != null) {
                return find(word, index+1, child);
            }
        }
        return false;
    }
    
    
}

class TrieNode {
    // Initialize data structure here
    public HashMap<Character, TrieNode> children;
    public boolean hasWord;
    
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        hasWord = false;
    }
    
    List<TrieNode> getAllChildren() {
        return new ArrayList<TrieNode>(children.values());
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");



// Improve performance by using an array to store child nodes ( Array implementation of trie, no '.' version)
// class TrieNode {
//	TrieNode[] children;
//	boolean isLeaf;
//	public TrieNode() {
//		this.children = TrieNode[52];
//	}
//}

//public class Trie {
//	private TrieNode root;
//	
//	public Trie() {
//		this.root = new TrieNode();
//	}
//	
//	// Inserts a word into trie
//	public void insert(String word) {
//		TrieNode p = root;
//		for (int i = 0; i < word.length(); i++) {
//			char c = word.charAt(i);
//			int index = c - 'a';
//			if (root.children[index] == null) {
//				TrieNode temp = new TrieNode();
//				root.children[index] = temp;
//				root = temp;
//			} else {
//				root = root.children[index];
//			}
//		}
//		root.isLeaf = true; 
//	}
//	
//	// returns if the word is in the trie
//	public boolean search(String word) {
//		TrieNode p = searchNode(word);
//		if (p == null) {
//			return false;
//		}else {
//			if (p.isLeaf) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	// search a prefix in trie
//	public boolean startsWith(String prefix) {
//		TrieNode p = searchNode(prefix);
//		if (p == null) {
//			return false;
//		} else {
//			return true;
//		}
//		
//	}
//	
//	// helper
//	public TrieNode searchNode(String s) {
//		TrieNode p = root;
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			int index = c - 'a';
//			if (root.children[index] != null) {
//				root = root.children[index];
//			} else {
//				return null;
//			}
//		}
//		
//		if (p == root) {
//			return null;
//		}
//		return p;
//	}
// }
