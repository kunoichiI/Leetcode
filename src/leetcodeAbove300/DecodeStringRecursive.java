package leetcodeAbove300;
//394. Decode String
//Given an encoded string, return it's decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//Examples:
//
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
public class DecodeStringRecursive { // THis solution received Time Limit Exceed .!!!
	public static String decodeString(String s) {
		int i = 0;
        return decode(s, i);
    }
	
	private static String decode(String s, int i) {
        String res = "";
        int n = s.length();
        while (i < n && s.charAt(i) != ']') {
            char c = s.charAt(i);
            if (c < '0' || c > '9') { // Alphabet
                res += c;
                i++;
            } else {
                int cnt = 0;
                while (i < n && c >= '0' && c <= '9') { // Numeric
                    cnt = cnt * 10 + c - '0';
                    i++;
                }
                i++; // skip '['
                String str = decode(s, i);
                i++; // skip ']'
                while (cnt-- > 0) {
                    res += str;
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("3[a2[c]]"));
	}

}
