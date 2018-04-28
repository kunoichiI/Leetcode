package gfg;
// ref1: https://www.geeksforgeeks.org/reservoir-sampling/
// ref2: https://gregable.com/2007/10/reservoir-sampling.html
import java.util.Arrays;
import java.util.Random;

public class ReserviorSampling {
	/*
	 * A function to randomly select k items from stream[0, ..., n - 1]
	 * time: O(n), space: O(k)
	 */
	public static void selectKItems(int[] stream, int n, int k) {
		int i = 0; // index for elements in stream[]
		int[] reservoir = new int[k]; // output array, initialize it with first k elements in stream[]
		for (; i < k; i++) {
			reservoir[i] = stream[i];
		}
		Random random = new Random();
		// iterate from (k+1)th element to nth element in stream[]
		for (; i < n; i++) {
			// Pick a random index from 0 to i
			int j = random.nextInt(i + 1);
			// If the random picked index is smaller than k, then replace the element present at
			// the index with new element from the stream
			if (j < k) 
				reservoir[j] = stream[i];
		}
		System.out.println("Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
	}
	public static void main(String[] args) {
		int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 5;
        selectKItems(stream, n, k);
	}
	/*
	 * How does this work?
	 * 
	 * 
	 */
}
