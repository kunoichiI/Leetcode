package gfg;
/*
 * A number n is power of 4 if following conditions are met:
 * 1) There is only one bit set in the binary representation of n(
 * or n is a power of 2)
 * 2) The count of zero bits before the (only) set bit is even.
 * 
 * For example: 16 (20000) is power of 4 because there is only one set
 * bit and count of 0s before the set bit is 4 which is even.
 */
public class PowerOf4 {
	public static boolean isPower4(int n) {
		/* check if there is only one set bit */
		int count = 0;
		if (n > 0 && !((n&(n-1)) > 0))  {
			/* count 0 bits before set bit */
			while (n > 1) {
				n >>= 1;
				count += 1;
			}
			return count % 2 == 0;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isPower4(16)); // true
		System.out.println(isPower4(32)); // false
		System.out.println(isPower4(9)); // false
	}
	/*
	 * 其他解法：
	 * 1. 对n以4为底，求对数 log4N
	 * 2. while （n！= 1） ， n不停除以4，如果n % 4 ！= 0，说明n不是4的指数
	 * n /= 4， 继续while循环内， 循环外返回1
	 *   static int isPowerOf4(int n) {
	 *   	if (n <= 0) return false;
	 *   	while (n != 1) {
	 *   		if (n %4 !=  0) return false;
	 *   		n /= 4;
	 *   	}
	 *   	return true;
	 *   }
	 */
}
