package leetcodeAbove200;

public class ImplementTrieWithArray {
	private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrieWithArray() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode pre = root;
        for (int i = 0; i < word.length(); i++) {
            if (pre.children == null)
                pre.children = new TrieNode[26];
            int index = word.charAt(i) - 'a';
            if (pre.children[index] == null)
                pre.children[index] = new TrieNode(word.charAt(i));
            
            pre = pre.children[index];
            if (i == word.length() - 1)
                pre.isLeaf = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (!startsWith(word)) {
        		return false;
        }    
        else {
            TrieNode pre = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
//                if (i == word.length() - 1) {
//                		System.out.println("pre is: " + pre.c);
//                		System.out.println("pre children are: " + pre.children[index].c);
//                }
                if (i == word.length() - 1 && pre.children[index].isLeaf == false) {
                    return false;
                }
                pre = pre.children[index];
            }
            return true;
        }   
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        TrieNode pre = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (pre.children == null || pre.children[index] == null)
                return false;
            pre = pre.children[index];
        }
        return true;
    }
    
	public static void main(String[] args) {
		ImplementTrieWithArray trie = new ImplementTrieWithArray();
		trie.insert("hello");
		System.out.println(trie.search("hello")); // true
		System.out.println(trie.startsWith("hello")); // true
		System.out.println(trie.startsWith("hell")); // true
		System.out.println(trie.search("hell")); // false
		System.out.println(trie.search("he")); // false
		System.out.println(trie.search("apple")); // false
		
		trie.insert("a");
		System.out.println(trie.search("a")); // true
		System.out.println(trie.startsWith("a")); // true
	}

}

class TrieNode {
    char c;
    boolean isLeaf;
    TrieNode[] children; // can use map too!
    TrieNode() { }
    TrieNode(char c) {
        this.c = c;
    }
}
