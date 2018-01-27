package interviewQ;

// LinkedIn question: find the first element in a sorted array that is larger than target number
public class findFirstElementLargerThanTarget {
	public static int findElement(int[] arr, int target) {
		// edge case, if arr == null
		if (arr == null)
			return -1; // cannot find such element, 
		// failed to consider edge case will cause runtime exception!!
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2; // avoid large int overflow, consider we use (lo + hi) / 2.. what if lo + hi is greater than int limit
			if (arr[mid] <= target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		if (hi + 1 <= arr.length - 1)
			return arr[hi + 1];
		else 
			return -1; // cannot find this value
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
