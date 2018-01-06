package leetcode;

// 76 Question
//Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
//Notice
//If there is no such window in source that covers all characters in target, return the empty string "".
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
//Clarification
//Should the characters in minimum window has the same order in target?
//Not necessary.
//Example
//For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
//Challenge
//Can you do it in time complexity O(n) ?

public class MinWindowSubstring {
	public static String minWindow(String source, String target) {
		if (source == null || source.length() == 0 || target == null || target.length() == 0) {
			return "";
		}
		
		int sourceHash[] = new int[256];
		int targetHash[] = new int[256];
		int ans = source.length() + 1;
		String minStr = "";
		
		initTargetHash(targetHash, target);
		
		int i = 0; 
		int j = 0;
		
		for (i = 0; i < source.length(); i++) {
			while (j < source.length() && !isValid(sourceHash, targetHash)) {
				sourceHash[source.charAt(j)]++;
				if (j < source.length()) {
					j++;
				} else {
					break;
				} 
				
				
			}
			if (isValid(sourceHash, targetHash)) {
				if (ans > j - i) {
					ans = j - i;
					minStr = source.substring(i, j);
				}
			}
			sourceHash[source.charAt(i)]--;
			
		}
		return minStr;
	}
	
	public static boolean isValid(int[] sourceHash, int[] targetHash) {
		for (int i = 0; i < sourceHash.length; i++) {
			if (targetHash[i] > sourceHash[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void initTargetHash(int[] targetHash, String target) {
		for (int i = 0; i < target.length(); i++) {
			targetHash[target.charAt(i)]++;
		}
	}
	
	public static void main(String[] args) {
		String source = "ADOBECODEBANC";
		String target = "ABC";
		System.out.print(minWindow(source, target));

	}

}
