package leetcode;
import java.util.*;
//17. Letter Combinations of a Phone Number
//Given a digit string, return all possible letter combinations that the number could represent.

//A mapping of digit to letters (just like on the telephone buttons) is given below.
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class LetterCombinationPhone {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, res);
        return res;
    }
    
    private void helper(Map<Character, char[]> map, String digits, StringBuilder sb, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        for (char c: map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, digits, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
