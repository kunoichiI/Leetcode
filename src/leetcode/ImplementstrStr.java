package leetcode;

//28. Implement strStr()  
//Implement strStr().
//
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


// needle is a string containing the sequence of characters to match, haystack is a string to be scanned
public class ImplementstrStr {
	// Naive solution O(m*n)
	public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(strStr("abcdefg", "aefg"));
	}
	// Knuth-Morris-Pratt(KMP) Pattern Matching for substring search
	
//	public int strStr(String haystack, String needle) {
//        if(haystack==null || needle==null)    
//            return 0;
//
//	    int h = haystack.length();
//	    int n = needle.length();
//
//	    if (n > h)
//		    return -1;
//	    if (n == 0)
//		    return 0;
//
//	    int[] next = getNext(needle);
//	    int i = 0;
//
//	    while (i <= h - n) {
//		    int success = 1;
//		    for (int j = 0; j < n; j++) {
//			    if (needle.charAt(0) != haystack.charAt(i)) {
//				    success = 0;
//				    i++;
//				    break;
//			    } else if (needle.charAt(j) != haystack.charAt(i + j)) {
//				    success = 0;
//				    i = i + j - next[j - 1];
//				    break;
//			    }
//		    }
//		    if (success == 1)
//			    return i;
//	    }
//
//	    return -1;
//    }
//
//    //calculate KMP array
//    public int[] getNext(String needle) {
//	    int[] next = new int[needle.length()];
//	    next[0] = 0;
//
//	    for (int i = 1; i < needle.length(); i++) {
//		    int index = next[i - 1];
//		    while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
//			    index = next[index - 1];
//		    }
//
//		    if (needle.charAt(index) == needle.charAt(i)) {
//			    next[i] = next[i - 1] + 1;
//		    } else {
//			    next[i] = 0;
//		    }
//	    }
//
//	    return next;
//    }
}
