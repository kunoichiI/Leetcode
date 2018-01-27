package leetcode;

//50. Pow(x, n)  
//Difficulty: Medium
//Implement pow(x, n).

/*
 * optimized recursive solution of pow(x, n), time complexity: o(logn), space complexity: o(logn)
 */
public class Pow_x_n { 
	public static double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        }else {
            return power(x, n);
        }
        
    }
    
    public static double power(double x, int n) {
        if (n == 0) return 1.0;
        
        double v = power(x, n / 2);
        
        if (n % 2 == 0) {
            return v * v;
        }else {
            return v * v * x;
        } 
    }
	
	/*
	 * This Solution will get StackOverFlow error on Leetcode because it's naive.
	 * because it's kinda like factorial function which runs o(n), so no need to pass an array to store
	 * But with Fibonacci function f(n) = f(n-1) + f(n-2), it will call repetive functions. 
	 * so to optimize it, use an array to store calculated values.
	 */
//	public static double myPow(double x, int n) {	
//		if (n < 0) {
//			double[] dp = new double[-n + 1];
//			return 1 / memoizationPow(x, -n, dp);
//		}
//		double[] dp = new double[n + 1];
//		return memoizationPow(x, n, dp);
//	}
//	
//	private static double memoizationPow(double x, int n, double[] dp) {
//		double y = 0.00000; // value to store in each dp[i], i from 0 to n
//		if (dp[n] > 0) {
//			return dp[n];
//		}
//		if (n == 0)
//			y = 1.00000;
//		else {
//			y = memoizationPow(x, n - 1, dp) * x;
//		}	
//		dp[n] = y;	
//		return y;
//	}
	
	public static void main(String[] args) {
		System.out.println(myPow(2.00000, 10));
		System.out.println(myPow(2.00000, -10));
		System.out.println(myPow(2.00000, -40));
	}
}
