package gfg;
import java.util.*;
/*
 * To shuffle an array of n elements(indices 0, ..., n- 1)
 *   	for (i from n - 1 down to 1 do)
 *   		j = random integer with 0 <= j <= i
 *   		swap a[j] with a[i]
 */
public class ShuffleArray {
	public void shuffle(int[] arr) {
		Random random = new Random();
		
		int len = arr.length;
		for (int i = len - 1; i > 0; i--) {
			swap(arr, i, random.nextInt(i));
		}
	}
	
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		ShuffleArray sa = new ShuffleArray();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		sa.shuffle(arr);
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * 解题思路：用random instance随机生成0 ～ i之间的index，然后与现有i index进行swap，
	 * 这样每一次生成的新数列，概率都是相等的。
	 * GeeksforGeeks: https://www.geeksforgeeks.org/?p=25111
	 */
}
