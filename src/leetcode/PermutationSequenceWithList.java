package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * 60. Permutation Sequence
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

	By listing and labeling all of the permutations in order, 
	we get the following sequence for n = 3:
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
	
	Note:
	
	Given n will be between 1 and 9 inclusive.
	Given k will be between 1 and n! inclusive.
	Example 1:
	
	Input: n = 3, k = 3
	Output: "213"
	Example 2:
	
	Input: n = 4, k = 9
	Output: "2314"
 */
public class PermutationSequenceWithList {
	/*
	 * time complexity: O(n), space: O(n)
	 */
	public static String getPermutation(int n, int k) {
        k--;
        
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        
        StringBuilder res = new StringBuilder();
        int times = n - 1;
        while (times >= 0) {
            int indexInList = k / factorial;
            res.append(numList.get(indexInList));
            numList.remove(indexInList);
            
            k %= factorial; // new k for next turn
            if (times != 0)
                factorial /= times; // new (n - 1)
            times--;
        }
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
