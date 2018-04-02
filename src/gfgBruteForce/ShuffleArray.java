package gfgBruteForce;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * A Brute Force of shuffling an array would be creating an temp array, then take an int 
 * out of temp, copy to arr[0], remove the int from temp. then repeat same process
 * copying random int from temp, to arr[1], arr[2], ... etc
 * time complexity is O(n ^ 2), space complexity if O(n)
 */
public class ShuffleArray {
	public static void randomize(int[] arr) {
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		//list.stream().forEach(System.out::println);
		
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			if (list.size() > 1) {
				int idx = random.nextInt(list.size() - 1);
				arr[i] = list.get(idx);
				list.remove(idx);
			}
			else {
				arr[i] = list.get(0);
			}
			
		}
		System.out.println("After shuffling: " + Arrays.toString(arr));
 	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		randomize(arr);
	}

}
