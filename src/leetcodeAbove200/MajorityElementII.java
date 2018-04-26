package leetcodeAbove200;

import java.util.ArrayList;
import java.util.List;

/*
 * 229. Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
        	if (num == candidate1) {
        		count1++;
        	} else if (num == candidate2) {
        		count2++;
        	} else if (count1 == 0) {
        		candidate1 = num;
        		count1++;
        	} else if (count2 == 0) {
        		candidate2 = num;
        		count2++;
        	} else {
        		count1--;
        		count2--;
        	}
        }
        count1 = count2 = 0;
        for (int num : nums) {
        	if (num == candidate1) count1++;
        	else if (num == candidate2) count2++;
        }
        int majority = nums.length / 3;
        if (count1 > majority) result.add(candidate1);
        if (count2 > majority) result.add(candidate2);
        return result;
    }
	/*
	 * 这道题规定了O（n）time和O（1） space，所以只能使用Moore Voting Algorithm
	 * 由于一个数组最多有2个majority element 次数多于 n / 3， 因为3个会引起悖论。 3个的话整个数组应该大于 3* n / 3 （n）
	 * 所以用两个变量存candidates，然后再遍历一次数组，看这两个candidates是否大于n / 3 次，如果大于则加入res list
	 */
}
