package gfg;

public class LongestSubstringWithKUniqueChars {
	public static String longestSubstringKUnique(String s, int k) {
		if (s == null || s.isEmpty()) return "";
		// get all unique counts in a char array
		int[] counts = new int[256];
		int count = 0;
		for (char c: s.toCharArray()) {
			if (counts[c - 'a'] == 0)
				count++;
			counts[c - 'a']++;
		}
		//System.out.println("count is: " +  count);
		if (k > count) {
			//System.out.println("hellllo");
			return ""; // k is greater than the number of all unique characters in the string
		}
		
		// maintain a sliding window
		int start = 0, end = 0;
		String res = "";
		int max_size = 1;
		counts = new int[256];
		counts[s.charAt(0) - 'a']++;
		
		for (int i = 1; i < s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
			end++;
			
			while (!isValid(counts, k)) {
				counts[s.charAt(start) - 'a']--;
				start++; // if not valid, removing from left side until it's valid
			}
			
			if (end - start + 1 > max_size) { // at each index, update max_size if possible
				res = s.substring(start, end + 1);
				max_size = end - start + 1;
			}
		}
		return res;
	}
	
	/*
	 * This method returns true if k >= val(all unique counts), return false if k < val
	 */
	private static boolean isValid(int[] count, int k) {
		int val = 0;
		for (int i : count) {
			if (i > 0)
				val++;
		}
		return k >= val;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstringKUnique("aabbcc", 1)); // aa
		System.out.println(longestSubstringKUnique("aabbcc", 2)); // aabb
		System.out.println(longestSubstringKUnique("aabbcc", 3)); // aabbcc
		System.out.println(longestSubstringKUnique("aabbcc", 4)); // ""
	}

}
