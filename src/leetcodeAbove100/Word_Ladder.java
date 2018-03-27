package leetcodeAbove100;
//127. Word Ladder  
//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the word list
//For example,
//
//Given:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder { // time complexity: O(n * 26*l), l is the length of word, n is the size of wordList 
	// space complexity: O(n)
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
	    for (String word : wordList) dict.add(word);
	    
	    if (!dict.contains(endWord)) return 0;
	    
	    Queue<String> q = new ArrayDeque<>(); // ArrayDeque is faster than stack when used as a stack, and faster
	    // than a queue using a linkedList
	    q.offer(beginWord);
	    
	    int l = beginWord.length();
	    int steps = 0;
	    
	    while (!q.isEmpty()) {
	      ++steps;
	      for (int s = q.size(); s > 0; --s) {
	        String w = q.poll();        
	        char[] chs = w.toCharArray();
	        for (int i = 0; i < l; ++i) {
	          char ch = chs[i];
	          for (char c = 'a'; c <= 'z'; ++c) {
	            if (c == ch) continue;
	            chs[i] = c;
	            String t = new String(chs);         
	            if (t.equals(endWord)) return steps + 1;            
	            if (!dict.contains(t)) continue;            
	            dict.remove(t);            
	            q.offer(t);
	          }
	          chs[i] = ch;
	        }
	      }
	    }
	    return 0;
    }
	
	public static void main(String[] args) {
		Word_Ladder wl = new Word_Ladder();
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		//wordList.add("cog");
		System.out.print(wl.ladderLength(beginWord, endWord, wordList));
	}

}
