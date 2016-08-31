package leetcode;
// Write a recursive and non-recursive program to generate all possible substrings of a string. 
public class GenerateAllSubstrings {
	// iterative way
//	public void substrings(String str) {
//		int len = str.length();
//		for (int i = 0; i < len; i++) {
//			for (int j = 1; j <= len - i; j++) {
//				String sub = str.substring(i, i+j);
//				System.out.println(sub);
//			}
//		}
//	}
	
	// recursive way
	public static void substrings(String str, int start, int end) {
		if (start == str.length() && end == str.length()) {
			return;
		}else {
			if (end == str.length()+1) {
				substrings(str, start+1, start+1);
			}else {
				System.out.println(str.substring(start, end));
				substrings(str, start, end+1);
			}
		}
	}
	public static void main(String[] args) {
		String str = "helloCruelWorld";
		substrings(str, 0, 1);

	}

}
