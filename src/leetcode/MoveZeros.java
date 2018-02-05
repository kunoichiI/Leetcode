package leetcode;

public class MoveZeros {

	public void moveZeros(int[] nums) { // this solution is even simpler!
		int count = 0; // to count non-zero elements in array
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[count++] = nums[i];
			}
		}
		
		while (count < nums.length) {
			nums[count++] = 0;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		MoveZeros mz = new MoveZeros();
		mz.moveZeros(arr);
		System.out.println("The output is:");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
