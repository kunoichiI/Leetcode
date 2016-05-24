package leetcode;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int length = digits.length;
        int[] array = new int[length+1];
        for (int i = length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }else {
                digits[i] = 0;
                continue;
            }
        }
        if (digits[0] == 0) {
            array[0] = 1;
            for (int j = 1; j < array.length; j++) {
                array[j] = 0;
            }
            return array;
        }else {
           return digits; 
        }
	}
	
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] digits = {9, 9, 9};
		int[] array = po.plusOne(digits);
		for (Integer i : array) {
			System.out.print(i  + " ");
		}
	}

}
