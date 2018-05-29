package leetcodeAbove100;

public class ReverseWordsInString {
	public static String reverseWords(String s) {
	if (s == null || s.length() == 0) return s;
	        
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        
        // reverse all characters
        while (i < j) {
            reverse(arr, i, j);
            i++;
            j--;
        }
        System.out.println(arr);
        StringBuilder sb = new StringBuilder();
        
        int startIdx = -1;
        
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == ' ') continue;
            
            if (startIdx == -1) startIdx = k;
            
            if (k + 1 == arr.length || arr[k + 1] == ' ') {
                // end of a word, start reversing here
                for (int a = startIdx, b = k; a < b; a++, b--) {
                    reverse(arr, a, b);
                }
                for (int a = startIdx; a <= k; a++) {
                    sb.append(arr[a]);
                }
                sb.append(' ');
                //System.out.println(sb.toString());
                startIdx = -1;
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
		
    }
    private static void reverse(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;    
    }
	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s)); // expected: "blue is sky the"
	}
}
