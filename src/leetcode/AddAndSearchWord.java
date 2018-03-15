package leetcode;
import java.util.*;
/* 211. Add and Search Word - Data structure design 
	Design a data structure that supports the following two operations:
	
	void addWord(word)
	bool search(word)
	search(word) can search a literal word or a regular expression string containing 
	only letters a-z or .. A . means it can represent any one letter.
	
	For example:
	
	addWord("bad")
	addWord("dad")
	addWord("mad")
	search("pad") -> false
	search("bad") -> true
	search(".ad") -> true
	search("b..") -> true 
*/

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

