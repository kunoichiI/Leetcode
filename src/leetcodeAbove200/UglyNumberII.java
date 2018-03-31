package leetcodeAbove200;

public class UglyNumberII {

	public static int nthUglyNumber(int n) {
		int[] uglys = new int[n];
		uglys[0] = 1;
		
		int i2 = 0, i3 = 0, i5 = 0;
		int counter = 1;
		while (counter < n) {
			int min = Math.min(Math.min(uglys[i2] * 2, uglys[i3] * 3), uglys[i5] * 5);
			if (min == uglys[i2] * 2) {
				i2++;
			} 
			if (min == uglys[i3] * 3) {
				i3++;
			}
			if (min == uglys[i5] * 5) {
				i5++;
			}
			uglys[counter] = min;
			counter++;
		}
		return uglys[counter - 1];
	}
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(34)); // 100
		System.out.println(nthUglyNumber(10)); // 12
	}

}
