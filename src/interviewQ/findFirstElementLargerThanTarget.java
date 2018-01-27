package interviewQ;

// LinkedIn question: find the first element in a sorted array that is larger than target number
public class findFirstElementLargerThanTarget {
	public static int findElement(int[] arr, int target) {
		// edge case, if arr == null
		if (arr == null)
			return -1; // cannot find such element, 
		// failed to consider edge case will cause runtime exception!!
		// use an auxiliary array which length is arr.length+1 and contains only 0 and 1, 
		// if arr[i] > target, array[i] = 1, else array[i] = 0
		int[] array = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > target)
				array[i] = 1;
			else 
				array[i] = 0;
		}
		//Arrays.stream(array).forEach(System.out::println);
		int lo = 0, hi = arr.length, tar = 1;
		while (lo != hi) {
			int mid = lo + (hi - lo) / 2;
			if (array[mid] < tar) 
				lo = mid + 1;
			else 
				hi = mid;
		}
		// after the while loop lo will be equal to hi
		if (lo > arr.length - 1)
			return -1; // the original array doesn't have the value that just greater than target
		else
			return arr[lo];
	}
	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 7, 8, 12, 16};
		int[] arr1 = {3};
		int[] arr2 = null;
		
		System.out.println("The element is: " + findElement(arr, 16)); // => -1
		System.out.println("The element is: " + findElement(arr, 9));  // => 12
		System.out.println("The element is: " + findElement(arr, 1));  // => 2
		System.out.println("The element is: " + findElement(arr, 8));  // => 12
		System.out.println("The element is: " + findElement(arr, 4));  // => 5
		System.out.println("The element is: " + findElement(arr, 100)); // => -1
		System.out.println("-------only one element works fine too!-------");
		System.out.println("The element is: " + findElement(arr1, 100)); // => -1
		System.out.println("The element is: " + findElement(arr1, 2)); // => 3
		System.out.println("------null case--------");
		System.out.println("The element is: " + findElement(arr2, 100)); // => -1
	}

}
