package leetcodeAbove200;
/*
 * 246 Strobogrammatic Number
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees 
 * (looked at upside down).

	Write a function to determine if a number is strobogrammatic. 
	The number is represented as a string.
	
	For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
	public static boolean isStrobo(String num) {
		/*
		 * valid numbers are : 0, 1, 6, 8 ,9. 
		 * Among them, 0, 1, 8 can map to itself, while 6 must be mapped to 9(vice versa)
		 * time: O(n), space: O(1)
		 */
		if (num == null || num.length() == 0) return true;
		
		int start = 0, end = num.length() - 1;
		while (start <= end) {
			char s = num.charAt(start);
			char e = num.charAt(end);
			if (s == e) {
				if (s != '1' && s != '0' && s != '8') return false;
			}
			else {
				if ((s != '6' || e != '9') && (s != '9' || e != '6')) return false;
			}
			start++;
			end--;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isStrobo("69")); // true
		System.out.println(isStrobo("16")); // false
		System.out.println(isStrobo("818")); // true
	}
}
