package leetcode;

//69. Sqrt(x)  
//Difficulty: Medium
//Implement int sqrt(int x).
//
//Compute and return the square root of x.

public class Sqrt {
	// Any nonnegative number x's square root should be less than (x/2 + 1)
	public int mySqrt(int x) {
        long i = 0;
        long j = x / 2 + 1; // the square root of x must be less or equal than (x/2 + 1);
        
        while (i <= j) {
            long mid = i + (j - i)/ 2;
            long square = mid * mid;
            if (square == x) return (int)mid;
            else if (square < x)  i = mid +1;
            else j = mid -1;
        }
        
        return (int)j;
    }
}
