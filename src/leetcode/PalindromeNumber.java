package leetcode;

import java.util.Arrays;

// 9. Palindrome Number
// Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x < 0) return false; // negative number is not palindrome!
		
		int div = 1; // record how many zeros after leftmost value
		while (x / div >= 10) { // 10/1 = 10; 100/1 > 10, 100/10 = 10, 100/100 < 10
			div *= 10;
		}
		
		while (x != 0) {
			int left = x / div; // 1331 / 1000 = 1
			int right = x % 10; // 1331 % 10 = 1
			
			if (left != right) return false;
			
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(-9)); // false
		System.out.println(isPalindrome(1331)); // true
		System.out.println(isPalindrome(0)); // true
		
		int[][] arr = new int[2][2];
		arr[0][0] = 99;
		arr[0][1] = 100;
		arr[1][0] = 1;
		arr[1][1] = 2;
		
		System.out.println(Arrays.deepToString(arr)); // [[99,100], [1,2]]
	}

}
