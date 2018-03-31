package leetcodeAbove200;
/*
 * 263. Ugly Number
 * 
 * Write a program to check whether a given number is an ugly number.

	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	
	Note:
	
	1 is typically treated as an ugly number.
	Input is within the 32-bit signed integer range.
 */
public class UglyNumber {
	public static boolean isUgly(int num) { // time complexity: O(logN)
		if (num == 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		while (num % 2 == 0) num /= 2;
		while (num % 3 == 0) num /= 3;
		while (num % 5 == 0) num /= 5;
		
		return num == 1;
	}
	public static void main(String[] args) {
		System.out.println(isUgly(16)); // true
		System.out.println(isUgly(11)); // false
		System.out.println(isUgly(555)); // false
	}

}
