package leetcode;
/*
 * 29. Divide Two Integers
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

	Return the quotient after dividing dividend by divisor.
	
	Example 1:
	
	Input: dividend = 10, divisor = 3
	Output: 3
	Example 2:
	
	Input: dividend = 7, divisor = -3
	Output: -2
	Note:
	
	Both dividend and divisor will be 32-bit signed integers.
	The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {/*Time: O(logN) 按2的幂直到*/
	public static int divide(int dividend, int divisor) {
		if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) // overflow case
            return Integer.MAX_VALUE;
        int res = 0;
        int sign = (dividend < 0)^(divisor < 0) ? -1 : 1; // bitwise XOR to get if both are negative or just one is negative
        long dvd = Math.abs((long)dividend); // must use (long) to do absolute value
        long dvs = Math.abs((long)divisor);

        while(dvs <= dvd){
            long temp = dvs, mul = 1;
            while(dvd >= temp << 1){
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            res += mul;
        }
        return sign == 1 ? res : -res;
    }
	public static void main(String[] args) {
		System.out.println(divide(7, 3)); // 2
		System.out.println(divide(10, 3)); // 3
		System.out.println(divide(23, 4)); // 5
	}
/*
 * dividend = quotient * divisor + remainder
 * quotient = binary form
 * 解题思路： 23 = 4 * 5 + 3 = 4 << 2(4 x4) + 4 + 3
 * 每一个数字（比如5） 可以写成2进制相加的形式binary form(0101), 余数4左移2位（4X4）+ 4 + 3
 * ，所以把除数left shift x2（相当于乘以2）得到16，仅次于23，然后23 - 16 = 7.
 * 直到达到仅次于被除数的大小，记录下左移次数，然后用被除数减去最大基数，更新被除数，直到被除数小于除数为止（此时的被除数即为余数）
 */
}
