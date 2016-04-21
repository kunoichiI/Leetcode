package leetcode;

public class UglyNumberII {

	public int nthUglyNumber(int n) {
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;
		
		int id2x = 0, id3x = 0, id5x = 0;
		int counter = 1;
		while (counter < n) {
			int min = minOf(uglyNumbers[id2x] * 2, uglyNumbers[id3x] * 3, uglyNumbers[id5x] * 5);
			if (min == uglyNumbers[id2x] * 2) {
				id2x++;
			} 
			if (min == uglyNumbers[id3x] * 3) {
				id3x++;
			}
			if (min == uglyNumbers[id5x] * 5) {
				id5x++;
			}
			uglyNumbers[counter] = min;
			counter++;
		}
		return uglyNumbers[counter - 1];
	}
	
	public int minOf(int i, int j, int k) {
		int temp = i < k? i:k;
		return temp < j? temp: j;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		UglyNumberII un2 = new UglyNumberII();
		System.out.print("The " + n + "th ugly number is: " + un2.nthUglyNumber(n) );

	}

}
