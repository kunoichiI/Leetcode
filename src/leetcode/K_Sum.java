package leetcode;

//LintCode
//
//Given n distinct positive integers, integer k (k <= n) and a number target.
//
//Find k numbers where sum is target. Calculate how many solutions there are?
//
//Example
//Given [1,2,3,4], k=2, target=5. There are 2 solutions:
//
//[1,4] and [2,3], return 2.

public class K_Sum {
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
	
	// f[i][j][t] 代表从i个数里面挑选出j个数，想加的和等于target
	public int  kSum(int A[], int k, int target) {
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = 0;
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] += f[i - 1][j][t];
                } // for t
            } // for j
        } // for i
        return f[n][k][target];
    }
}
