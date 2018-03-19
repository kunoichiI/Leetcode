package leetcodeAbove200;

import java.util.List;

import gfg.Graph;

public class AlienDictionaryTopologicalSort {
	public static void printOrder(String[] words, int alpha) {
		Graph graph = new Graph(alpha);
		
		for (int i = 0; i < words.length - 1; i++) {
			// Take the current two words and find the first mismatching
			// character
			String word1 = words[i];
			String word2 = words[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j ++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}
		graph.topologialSort();
	}
	public static void main(String[] args) {
		String[] words = {"caa", "aaa", "aab"};
		printOrder(words, 3);
	}

}
