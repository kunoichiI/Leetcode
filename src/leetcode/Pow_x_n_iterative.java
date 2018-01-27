package leetcode;

// Iterative solution of pow(x, n), time complexity: o(logn) space complexity: o(logn)
public class Pow_x_n_iterative {
	public static double myPow(double x, int n) {
		if (n < 0) {
			return 1 / pow(x, -n);
		}
		return pow(x, n);
	}
	
	private static double pow(double x, int n) {
		double res = 1.0;
		
		while (n > 0) {
			if (n % 2 != 0) { // If n is odd, multiply x with result
				res *= x;
			}
			// n is even
			n = n >> 1; // right shift is equal to n / 2
			x = x * x;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(myPow(2.00000, 10));
		System.out.println(myPow(2.00000, -10));
		System.out.println(myPow(2.00000, -40));

	}

}
