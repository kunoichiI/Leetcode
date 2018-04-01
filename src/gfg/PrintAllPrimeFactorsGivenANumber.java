package gfg;

public class PrintAllPrimeFactorsGivenANumber {
	public static void printPrimes(int n) {
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}
		// after while loop, n is an odd number
		for (int i = 3; i * i <= n; i += 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n /= i;
			}
		}
		if (n > 2) {
			System.out.print(n + " ");
		}
		
	}
	public static void main(String[] args) {
		printPrimes(315); // 3 3 5 7
		System.out.println();
		printPrimes(12);
		System.out.println(); // 2 2 3
		printPrimes(1111);
	}
	
	/*
	 * 解题思路： 首先将n变成奇数（因为2 是最小的prime number）所以可以的话先输出2
	 * 然后对n进行从3 开始让所有的奇数 i*i小于等于n的 ，如果n 可以整除i （n % i == 0）
	 * 则输出i，并且while 里面逐步更新n
	 * 最后n如果大于2, 输出n。 （这一步为了防止n最后是1，不可以输出1！）
	 */

}
