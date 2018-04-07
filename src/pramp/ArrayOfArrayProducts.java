package pramp;

import java.util.Arrays;

/*
 * Array of Array Products
	Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index
	(i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.
	
	Solve without using division and analyze your solution’s time and space complexities.
	
	Examples:
	
	input:  arr = [8, 10, 2]
	output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]
	
	input:  arr = [2, 7, 3, 4]
	output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]
	Constraints:
	
	[time limit] 5000ms
	
	[input] array.integer arr
	
	0 ≤ arr.length ≤ 20
	[output] array.integer


 */
public class ArrayOfArrayProducts {
	public static int[] arrayOfArrayProducts(int[] arr) {
		if (arr == null || arr.length <= 1) return new int[]{};
		
		int len = arr.length, product = 1;
		int[] helper = new int[len];
		for (int i = 0; i < len; i++) {
			helper[i] = product;
			product *= arr[i];
		}
		product = 1;
		for (int j = len - 1; j >= 0; j--) {
			helper[j] *= product;
			product *= arr[j];
		}
		return helper;
	}
	public static void main(String[] args) {
		int[] arr1 = {};
		int[] arr2 = { 1 };
		int[] arr3 = { 2, 2 };
		int[] arr4 = { 2, 7, 3, 4 };
		int[] arr5 = { 2, 3, 0, 982, 10 };
		int[] arr6 = { -3,17,430,-6,5,-12,-11,5 };

		System.out.println(Arrays.toString(arrayOfArrayProducts(arr1))); // []
		System.out.println(Arrays.toString(arrayOfArrayProducts(arr2))); // []
		System.out.println(Arrays.toString(arrayOfArrayProducts(arr3))); // [2, 2]
		System.out.println(Arrays.toString(arrayOfArrayProducts(arr4))); // [84, 24, 56, 42]
		System.out.println(Arrays.toString(arrayOfArrayProducts(arr5))); // [0, 0, 58920, 0, 0]
		System.out.println(Arrays.toString(arrayOfArrayProducts(arr6))); // [-144738000,25542000,1009800,-72369000,86842800,-36184500,-39474000,86842800]
	}
	
	/*
	 * 解题思路：如果可以使用除法，那么用一个很大的数字preprocess array，得到所有乘积之和，然后除去相应的array【index】
	 * 如果不能使用除法，则【2，7， 4， 2】 使用辅助数列【1， 2， 14， 28】， 从后往前变成【56， 16， 28， 56】
	 * 注意第一位和最后一位一开始的product都是1， 逐步product *= arr【i】
	 */

}
