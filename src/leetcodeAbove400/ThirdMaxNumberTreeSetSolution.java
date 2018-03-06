package leetcodeAbove400;

import java.util.TreeSet;

//414. Third Maximum Number
//Given a non-empty array of integers, return the third maximum number in this array. 
//If it does not exist, return the maximum number. The time complexity must be in O(n).
//
//Example 1:
//Input: [3, 2, 1]
//
//Output: 1
//
//Explanation: The third maximum is 1.
//Example 2:
//Input: [1, 2]
//
//Output: 2
//
//Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
//Example 3:
//Input: [2, 2, 3, 1]
//
//Output: 1
//Explanation: Note that the third maximum here means the third maximum distinct number.
//Both numbers with value 2 are both considered as second maximum.
public class ThirdMaxNumberTreeSetSolution {
	public static int thirdMax(int[] nums) {
        // nums length is at least 3
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        if (set.size() < 3) return set.pollLast();
        set.pollLast();
        set.pollLast();
        return set.pollLast();
    }
	public static void main(String[] args) {
		int[] arr1 = { 3, 2, 1 };
		int[] arr2 = { 2, 1 };
		int[] arr3 = { 2, 2 , 3, 1 };
		
		System.out.println(thirdMax(arr1)); // 1
		System.out.println(thirdMax(arr2)); // 2 , size < 3 so return maximum instead
		System.out.println(thirdMax(arr3)); // 1, do not consider dup
		
	}

}
