package leetcode;
import java.util.*;

public class ShuffleArray {
	private static Random random;
	
	public void shuffle(int[] arr) {
		if (random == null) random = new Random();
		int len = arr.length;
		for (int i = len; i > 1; i--) {
			swap(arr, i - 1, random.nextInt(i));
		}
	}
	
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
