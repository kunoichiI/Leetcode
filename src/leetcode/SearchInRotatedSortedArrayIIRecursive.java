package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

// 81 Search rotated sorted array, allow duplicates
public class SearchInRotatedSortedArrayIIRecursive {
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
            return false;
        return binarySearch(nums, 0, nums.length - 1, target); 
	}
	
	private static boolean binarySearch(int[] arr, int left, int right, int target) { 
		 if (left > right) {
	            return false;
		}
        int mid = left + (right - left) / 2;
        if (arr[mid] == target)
            return true;
         
        if (arr[left] < arr[mid]) { // left side of array is sorted
            if (arr[left] <= target && arr[mid] >= target) {
                return binarySearch(arr, left, mid - 1, target);
            } else {
                return binarySearch(arr, mid + 1, right, target);
            }
        }
        else if (arr[left] > arr[mid]) { // right side of array is sorted
            if (arr[right] >= target && arr[mid] <= target) {
                return binarySearch(arr, mid + 1, right, target);
            } else {
                return binarySearch(arr, left, mid - 1, target);
            }
        }
        else if (arr[left] == arr[mid]) { // left side of array is repeated values
            if (arr[mid] != arr[right]) {
                return binarySearch(arr, mid + 1, right, target); // if right is not repeated values, search right part of array
            } else { // search both halves
                boolean leftRes = binarySearch(arr, left, mid - 1, target);
                if (leftRes == false) {
                    return binarySearch(arr, mid + 1, right, target);
                } else {
                    return leftRes;
                }
            }
        }
        return false;
	}
	public static void main(String[] args) {
		// test cases
		int[] arr1 = {1, 3, 1, 1, 1}; 
	    System.out.println(search(arr1, 3)); // => true
	    
	    int[] arr2 = { 1, 4, 5, 0, 0, 0};
	    System.out.println(search(arr2, 10)); // => false
	    
	    ArrayList<Integer> list = new ArrayList<>();
	    list.add(1);
	    list.add(2);
	    System.out.println("The type is : " + list.toArray(new Integer[0]).getClass()); // => convert arraylist to array... runtime type integer. cannot convert to int!!
	    System.out.println("The type is : " + Arrays.asList(arr1).getClass()); // => convert array to ArrayList
	}

}
