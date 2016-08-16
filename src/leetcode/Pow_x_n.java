package leetcode;

//50. Pow(x, n)  
//Difficulty: Medium
//Implement pow(x, n).

public class Pow_x_n {
	public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        }else {
            return power(x, n);
        }
        
    }
    
    public double power(double x, int n) {
        if (n == 0) return 1.0;
        
        double v = power(x, n / 2);
        
        if (n % 2 == 0) {
            return v * v;
        }else {
            return v * v * x;
        } 
    }
}
