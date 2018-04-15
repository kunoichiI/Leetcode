package leetcode;

public class PlusOneSelf {
	public int[] plusOne(int[] digits) {
        // find the first element that is not 9
        int notNine = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) notNine = i;
        }
        if (notNine == -1) {
            // all numbers are nine
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            for (int j = 1; j < arr.length; j++)
                arr[j] = 0;
            return arr;
        }
        else {
            digits[notNine]++;
            for (int j = notNine + 1; j < digits.length; j++)
                digits[j] = 0;
            return digits;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 解题思路：寻找第一个不是9的位数，然后就方便啦
	 */
}
