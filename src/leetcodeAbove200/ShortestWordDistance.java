package leetcodeAbove200;
// 243 Shortest Word Distance
// Given a list of words and two words word1 and word2, 
// return the shortest distance between these two words in the list.
// For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
// Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
public class ShortestWordDistance { // O(n) time complexity, O(1) space complexity, two pointers solution
	public static int shortestDistance(String[] words, String word1, String word2) {
		int idx1 = -1, idx2 = -1, res = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				idx1 = i;
				if (idx2 != -1)
					res = Math.min(res, Math.abs(idx1 - idx2));
			} 
			if (words[i].equals(word2)) {
				idx2 = i;
				if (idx1 != -1)
					res = Math.min(res, Math.abs(idx1 - idx2));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println("The shotest distance is: " + shortestDistance(words, "coding", "practice"));
		System.out.println("The shotest distance is: " + shortestDistance(words, "makes", "coding"));
	}

}
