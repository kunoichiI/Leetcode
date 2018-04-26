package leetcodeAbove300;
/*
 * 342. Power of Four
 *  Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
	/*
	 * 不难发现所有4的指数，化为二进制都是1 000000。。。
	 * 所以num & （num - 1） == 0
	 * 神奇的是 （num - 1） % 3 能被3 整除。。。
	 */
}
