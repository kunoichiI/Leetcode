package leetcodeAbove200;

import java.util.Arrays;

// 204. Count Primes 
// Count the number of prime numbers less than a non-negative number, n.
// The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n).

public class CountPrimes { 
	public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
        		//System.out.println("i is: " + i);
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
            		//System.out.println("j is: " + j);
                isPrime[j] = false;
            }
        }
        //System.out.println("prime array is like: " + Arrays.toString(isPrime));
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
	public static void main(String[] args) {
		System.out.println(countPrimes(9)); // 4
		System.out.println(countPrimes(1025)); // 172
	}
	
	/* Sieve of Erastothene
	 * Input: an integer n > 1.
 
		 Let A be an array of Boolean values, indexed by integers 2 to n,
		 initially all set to true.
		 
		 for i = 2, 3, 4, ..., not exceeding √n:
		   if A[i] is true:
		     for j = i^2, i^2+i, i^2+2i, i^2+3i, ..., not exceeding n:
		       A[j] := false.
		 
		 Output: all i such that A[i] is true.
	 */
}
