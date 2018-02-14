package leetcodeAbove400;

import java.util.Arrays;

//443. String Compression
//Given an array of characters, compress it in-place.
//
//The length after compression must always be smaller than or equal to the original array.
//
//Every element of the array should be a character (not int) of length 1.
//
//After you are done modifying the input array in-place, return the new length of the array.
//
//
//Follow up:
//Could you solve it using only O(1) extra space?
//
//
//Example 1:
//Input:
//["a","a","b","b","c","c","c"]
//
//Output:
//Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//
//Explanation:
//"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
//Example 2:
//Input:
//["a"]
//
//Output:
//Return 1, and the first 1 characters of the input array should be: ["a"]
//
//Explanation:
//Nothing is replaced.
//Example 3:
//Input:
//["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//
//Output:
//Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
//
//Explanation:
//Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
//Notice each digit has it's own entry in the array.
//Note:
//All characters have an ASCII value in [35, 126].
//1 <= len(chars) <= 1000.
public class StringCompression { // O(N) time, O(1) space 这里对pointer的运用非常有启发！！
	public static int compress(char[] chars) {
		int i = 0, write = 0;
		for (int read = 0; read < chars.length; read++) {
			if (read == chars.length - 1 || chars[read + 1] != chars[read]) { /* 以每一个group为处理单元
				i是起始index， read是loop index， write是记录写入的index
				要么已经到了数列末尾，要么发生了字符变化*/
				chars[write++] = chars[read]; /* 先把字符写入 */
				if (i < read) { /* 字符重复次数大于1 */
					for (char a : ("" + (read - i + 1)).toCharArray()) { /* 这里把int 差值化为char array，高明！*/
						chars[write++] = a; /* 把字符重复次数写入原array， write每次进位*/
					}
				}
				i = read + 1; /* 把起始点移到下一个单元 */
			}
		}
		return write; /* 最终写入的index是input里的有效长度，比如 a,a ,a, b，b（长度为5） 变为 a 3 b 2(长度为4)*/
		
	}
	public static void main(String[] args) {
		char[] chars1 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b','b','b','b','b','b','b'};
		char[] chars2 = { 'b', 'c', 'b', 'b', 'c', 'c', 'a' };
		System.out.println("The length of chars1 becomes: " + compress(chars1));
		System.out.println("chars1 looks like: ");
		System.out.println(Arrays.toString(chars1));
		System.out.println("The length of chars2 becomes: " + compress(chars2));
		System.out.println("chars2 looks like: ");
		System.out.println(Arrays.toString(chars2));
	}

}
