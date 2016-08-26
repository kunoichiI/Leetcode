package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//product of the array   给定一个array，返回里面元素乘积的所有可能值。 例如给定array:[1,2,3,4]   应该返回 [1, 2, 3, 4, 6, 8, 12, 24]

public class ProductOfArray {
	public List<Integer> product(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		dfs(nums, 0, 1, res, set);
		Collections.sort(res);
		boolean hasOne = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				hasOne = true;
			}
		}
		if (!hasOne) {
			res.remove(0);
		}
		return res;
	}
		  
	private void dfs(int[] nums, int start, int product, List<Integer> res, Set<Integer> set) {
		if (set.contains(product)) return;
		  	set.add(product);
		    res.add(product);
		        
		for (int i = start; i < nums.length; i++) {
		    product *= nums[i];
		    dfs(nums, i + 1, product, res, set);
		    product /= nums[i];
		}
	}
	
	public static void main(String[] args) {
		ProductOfArray s = new ProductOfArray();
		int[] array = {2, 3, 4, 5};
		List<Integer> list = s.product(array);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
