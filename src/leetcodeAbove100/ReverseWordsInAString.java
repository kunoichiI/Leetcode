package leetcodeAbove100;
//151. Reverse Words in a String
//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
public class ReverseWordsInAString {
	public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
       // split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}

}
