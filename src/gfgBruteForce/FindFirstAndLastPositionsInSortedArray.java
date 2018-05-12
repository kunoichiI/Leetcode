package gfgBruteForce;
/*
 * Find first and last positions of an element in a sorted array
	Given a sorted array with possibly duplicate elements, the task is 
	to find indexes of first and last occurrences of an element x in the given array.
	
	Examples:
	
	Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}    
	        x = 5
	Output : First Occurrence = 2
	         Last Occurrence = 5
	
	Input : arr[] = {1, 3, 5, 5, 5, 5 ,7, 123 ,125 }    
	        x = 7
	Output : First Occurrence = 6
	         Last Occurrence = 6
 */
public class FindFirstAndLastPositionsInSortedArray {
	/*
	 * Time complexity: O(n), space: O(1)
	 */
	public static void printFirstAndLast(int[] arr, int target) {
        // naive solution
        int start = -1, end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target) continue;
            if (start == -1) {
                start = i;
            }
            end = i;
        }
        if (start != -1)
            System.out.println(start + " " + end);
        else
            System.out.println(-1);
    }
}
/*
 * Naive approach: 
 *  1. Run a for loop and for i = 0 to n-1
	2. Take first = -1 and last = -1 
	3. When we find element first time then we update first = i 
	4. We always update last=i whenever we find the element.
	5. We print first and last. 
*/
