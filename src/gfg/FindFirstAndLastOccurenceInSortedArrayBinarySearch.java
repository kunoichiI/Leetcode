package gfg;
// ref: https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
public class FindFirstAndLastOccurenceInSortedArrayBinarySearch {
	/* 
	 * Time complexity: O(logn), space: O(1)
	 */
	public static int first(int lo, int hi, int[] arr, int target) {
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target) {
                return mid;
            }
            else if (target > arr[mid]) {
                return first(mid + 1, hi, arr, target);
            }
            else {
                return first(lo, mid - 1, arr, target);
            }
        }
        return -1;
    }
    
    public static int last(int lo, int hi, int[] arr, int target) {
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target) {
                return mid;
            }
            else if (target < arr[mid]) {
                return last(lo, mid - 1, arr, target);
            }
            else 
                return last(mid + 1, hi, arr, target);
        }
        return -1;
    }
    
    public static void printFirstAndLast(int[] arr, int target) {
        // binary search solution
        int start = -1, end = -1;
        start = first(0, arr.length - 1, arr, target);
        end = last(0, arr.length - 1, arr, target);
        if (start == -1) 
            System.out.println(-1);
        else {
            System.out.println(start + " " + end);
        }
    }
}
/*
 * Binary Search, 要注意corner case和binary search recursion部分的参数传递。。 mid - 1 和 mid + 1 etc
 * */
