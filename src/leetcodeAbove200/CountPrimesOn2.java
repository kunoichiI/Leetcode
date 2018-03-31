package leetcodeAbove200;

import java.util.Arrays;

public class CountPrimesOn2 {
	public static int countPrime(int n) {
		if (n < 3)
			return 0;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				for (int j = i * 2; j < n; j += i) {
					primes[j] = false; // mark all p*2, p*3, ... to non prime
				}
			}
		}
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		System.out.println(countPrime(9)); // 4
		System.out.println(countPrime(1025)); // 172
	}
	/*
	 * 这个方法比优化Sieve of Erastothens要慢一些，因为i从2 一直循环到n - 1
	 * 而优化法使用的是i* i， j也是i^2 + i, i^2 + 2i,.... 
	 */
}
