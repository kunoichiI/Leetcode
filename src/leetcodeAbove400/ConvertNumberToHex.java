package leetcodeAbove400;
//405. Convert a Number to Hexadecimal
//Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
//
//Note:
//
//All letters in hexadecimal (a-f) must be in lowercase.
//The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
//The given number is guaranteed to fit within the range of a 32-bit signed integer.
//You must not use any method provided by the library which converts/formats the number to hex directly.
//Example 1:
//
//Input:
//26
//
//Output:
//"1a"
//Example 2:
//
//Input:
//-1
//
//Output:
//"ffffffff"
public class ConvertNumberToHex {
	public static String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            sb.append(map[num & 15]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		System.out.println(toHex(26));  // "1a"
		System.out.println(toHex(-1)); // "ffffffff" (use Two complement)
	}
	/*
	 * 解题思路：直接将num当做二进制的数字去处理，然后每4位映射一次就好,然后逻辑位移就好，Hex是16进制，也就是2^ 4
	 * 对于2^n 位运算，直接使用二进制位移，十分方便。这道题的Brute Force是用modulo不断除，挺麻烦的。。尤其对于负数，
	 * 要使用Two complement，有可能导致溢出。
	 */
}
