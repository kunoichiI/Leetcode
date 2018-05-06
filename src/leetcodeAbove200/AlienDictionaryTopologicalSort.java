package leetcodeAbove200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionaryTopologicalSort {
	public static String orderOfCharacters(String[] words) {
		if (words == null || words.length == 0) return "";
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		// Put all characters in degree 0
		for (String word: words) {
			for (char c: word.toCharArray()) {
				degree.put(c, 0);
			}
		}
		//System.out.println("hellllo");
		// compare each word and its previous word character-by-character
		// if they're different, since c1 is before c2, so put c2 to c1's next set, c2's indegree + 1
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i + 1];
			// using the shorter one
			int length = Math.min(cur.length(), next.length());
			for (int j = 0; j < length; j++) {
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2) {
					Set<Character> set = map.getOrDefault(c1, new HashSet<>());
					if(!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2) + 1);
					}
					break;
				}
				
			}
		}
		
		System.out.println(map);
		System.out.println(degree);
		
		// Topological sort via BFS
		Queue<Character> q = new LinkedList<>();
		// put all 0 - indegree into queue
		for (char c: degree.keySet()) {
			if (degree.get(c) == 0) q.add(c);
		}
		
		while (!q.isEmpty()) {
			char c = q.poll();
			sb.append(c);
			if (map.containsKey(c)) {
				for (char c2: map.get(c)) {
					// all next char's indegree subtract 1
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0) q.add(c2);
				}
			}
		}
		
		if (sb.length() != degree.size()) return "";
		return sb.toString();
	}
	
	// Driver program to test above functions
    public static void main(String[] args)
    {
        String[] words = {"caa", "aaa", "aab"};
        System.out.println(orderOfCharacters(words)); // "cab"
        
        String[] words1 = { "wrt", "wrf","er","ett", "rftt" };
        System.out.println(orderOfCharacters(words1)); // "wertf"
    }

}