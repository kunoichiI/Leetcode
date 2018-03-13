package leetcodeAbove200;

import java.util.ArrayList;
import java.util.List;

// use TrieNode[] array to carry all children nodes
public class AddAndSearchWord {
	 private WordNode root;
	    /** Initialize your data structure here. */
	    public AddAndSearchWord() {
	        root = new WordNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        if (word == null || word.length() == 0) return;
	        WordNode pre = root;
	        for (int i = 0; i < word.length(); i++) {
	            int index = word.charAt(i) - 'a';
	            if (pre.children == null)
	                pre.children = new WordNode[26];
	            if (pre.children[index] == null)
	                pre.children[index] = new WordNode(word.charAt(i));
	            pre = pre.children[index];
	        }
	        pre.hasWord = true; // set the leaf node 'hasWord' to true
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return find(word, 0, root);
	    }
	    
	    private boolean find(String word, int start, WordNode cur) {
	        if (start == word.length())
	            return cur.hasWord;
	        
	        char c = word.charAt(start);
	        if (c == '.') {
	            for (WordNode node : cur.getAllChildren()) {
	                if (find(word, start + 1, node))
	                    return true;
	            }
	        }
	        else {
	        		if (cur.children == null) {
	        			return false;
	        		}
	            WordNode child = cur.children[c - 'a'];
	            if (child != null)
	                return find(word, start + 1, child);
	        }
	        return false;
	    }
	public static void main(String[] args) {
		AddAndSearchWord dictionary = new AddAndSearchWord();
		System.out.println(dictionary.search("a")); // false
		dictionary.addWord("bad");
		dictionary.addWord("mad");
		dictionary.addWord("dad");
		System.out.println(dictionary.search("pad")); // false
		System.out.println(dictionary.search(".ad")); // true
		System.out.println(dictionary.search("b..")); // true
	}

}
/* rename TrieNode ... can always change name later*/
class WordNode {
	char c;
    WordNode[] children;
    boolean hasWord;
    WordNode() { }
    WordNode(char c) {
        this.c = c;
        children = new WordNode[26];
        hasWord = false;
    }
    
    List<WordNode> getAllChildren() {
        List<WordNode> list = new ArrayList<>();
        for (WordNode node : children) {
            if (node != null)
                list.add(node);
        }
        return list;
    }
}
