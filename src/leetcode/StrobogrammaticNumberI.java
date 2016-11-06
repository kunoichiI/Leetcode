package leetcode;

import java.util.*;
// LC 246
//
// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
// For example, the numbers "69", "88", and "818" are all strobogrammatic.
public class StrobogrammaticNumberI {
	
	public static boolean isStrobogrammatic(String num) {
		final Map<Character, Character> map = new HashMap<Character, Character>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			put('1', '1');
			put('0', '0');
			put('8', '8');
			put('6', '9');
			put('9', '6');	
		}};
		
		int n = num.length();
		for (int l = 0, r = n - 1; l <= r; l++, r--) {
			if (map.get(num.charAt(l)) != num.charAt(r)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "69";
		String str_1 = "818";
		String str_2 = "134";
		System.out.println(isStrobogrammatic(str));
		System.out.println(isStrobogrammatic(str_1));
		System.out.println(isStrobogrammatic(str_2));
		
	}

}
