package leetcode;
import java.util.*;

public class CountPalindrome {
	public List<String> palindromes(String input) {

	     List<String> result = new ArrayList<>();

	     for (int i = 0; i < input.length(); i++) {
	         // expanding even length palindromes:
	         expandPalindromes(result,input,i,i+1);
	         // expanding odd length palindromes:
	         expandPalindromes(result,input,i,i);
	     } 
	     return result;
	  }

	  public void expandPalindromes(final List<String> result, String s, int i, int j) {
	      while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
	            result.add(s.substring(i,j+1));
	            i--; j++;
	      }
	  }
	public static void main(String[] args) {
		String s = "wowpurerocks";
		CountPalindrome cp = new CountPalindrome();
		List<String> res = cp.palindromes(s);
		for (String r: res) {
			System.out.print(r + " ");
		}

	}

}
