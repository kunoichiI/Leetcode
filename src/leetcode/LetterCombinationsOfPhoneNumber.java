package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
// Iterative solution: Leetcode AC but not efficient
public class LetterCombinationsOfPhoneNumber {
	public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        
        // initialize map
        String[] map = initializeMap();
        res.add("");
        for (char c : digits.toCharArray()) {
            List<String> tmp1 = getList(c, map);
            System.out.println("tmp1 is: ");
            tmp1.forEach(s -> System.out.print(s + " "));
            System.out.println();
            List<String> tmp2 = new ArrayList<>();
            
            
        		for (int i = 0; i < res.size(); i++) {
        			StringBuilder sb = new StringBuilder(res.get(i));
        			for (int j = 0; j < tmp1.size(); j++) {
        				sb.append(tmp1.get(j));
        				tmp2.add(sb.toString());
        				sb.deleteCharAt(sb.length() - 1);
        			}
        		}
        		res = tmp2;
            
            
            System.out.println("tmp2 is: ");
            tmp2.forEach(s -> System.out.print(s + " "));
        }
        return res;
    }
    
    public static List<String> getList(char c, String[] map) {
        List<String> ans = new ArrayList<>();
        String mapping = map[c - '0'];
        for (char ch: mapping.toCharArray()) {
            ans.add(Character.toString(ch));
        }
        return ans;
    }
    
    public static String[] initializeMap() {
        String[] arr = new String[10];
        arr[0] = "";
        arr[1] = "";
        arr[2] = "abc";
        arr[3] = "def";
        arr[4] = "ghi";
        arr[5] = "jkl";
        arr[6] = "mno";
        arr[7] = "pqrs";
        arr[8] = "tuv";
        arr[9] = "wxyz";
        return arr;
    }
	public static void main(String[] args) {
		List<String> l = letterCombinations("34");
		l.forEach(s -> System.out.print(s + " "));
	}

}
