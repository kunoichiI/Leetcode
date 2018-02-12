package leetcodeAbove200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import gfg.Graph;

//269. Given a sorted dictionary of an alien language, find order of characters
//Examples:
//
//Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
//Output: Order of characters is 'b', 'd', 'a', 'c'
//Note that words are sorted and in the given language "baa" 
//comes before "abcd", therefore 'b' is before 'a' in output.
//Similarly we can find other orders.
//
//Input:  words[] = {"caa", "aaa", "aab"}
//Output: Order of characters is 'c', 'a', 'b'
public class AlienDictionary {
	private Graph graph;
	public List<Character> characterOrder(String[] words) {
		List<Character> res = new LinkedList<>();
		// corner case
		if (words == null || words.length == 0)
			return res;
		// calculate how many unique characters in words
		boolean[] chars = new boolean[256];
		for (int k = 0; k < words.length; k++) {
			String word = words[k];
			for (char c : word.toCharArray()) {
				if (chars[c - 'a'] == false)
					chars[c - 'a'] = true;
			}
		}
		int cnt = 0;
		for (boolean b : chars) {
			if (b)
				cnt++;
		}
		graph = new Graph(cnt);
		// gather edges based on words, find the first mismatching character of one pair words
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j))
					System.out.println("word1 char: " + (word1.charAt(j) - 'a'));
					System.out.println("word2 char: " + (word2.charAt(j) - 'a'));
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
			}
		}
		//System.out.println("graph is: " + graph);
		System.out.println("graph vertice number is: " + graph.getVertices());
		//System.out.println("graph adjacent list is: " + graph.getAdjList());
		Arrays.stream(graph.getAdjList())
			  .forEach(System.out::println);
		res = graph.topologialSort();
		return res;
	}
	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		// test cases
		String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
		List<Character> l1 = ad.characterOrder(words1);
		System.out.println("l1 is: " + l1);
	}

}