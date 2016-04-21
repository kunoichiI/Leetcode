package leetcode;

public class UglyNumber {

	/*
	 *  Ugly numbers are positive numbers whose prime factors only include 2, 3, 5;
	 */
	public boolean isUgly(int num) {
		if (num == 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		if (num % 2 == 0) {
			return isUgly(num / 2);
		}else if (num % 3 == 0) {
			return isUgly(num / 3);
		}else if (num % 5 == 0) {
			return isUgly(num / 5);
		}
		return false;
	}
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		UglyNumber un = new UglyNumber();
		boolean y = un.isUgly(x);
		if (y == true) {
			System.out.print("This number" + " " + x + "  " + "is an ugly number.");
		}else {
			System.out.print("This number" + " " + x +  " " + "is not an ugly number.");
		}
	}

}
