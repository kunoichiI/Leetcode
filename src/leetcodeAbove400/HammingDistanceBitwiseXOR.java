package leetcodeAbove400;
//461. Hamming Distance
//The Hamming distance between two integers is the number of positions 
//at which the corresponding bits are different.
//Given two integers x and y, calculate the Hamming distance.
//
//Note:
//0 ≤ x, y < 231.
//
//Example:
//
//Input: x = 1, y = 4
//
//Output: 2
//
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are different.
public class HammingDistanceBitwiseXOR {
	public static int hammingDistance(int x, int y) {
        // Bit Manipulation
        // XOR
        int i = x ^ y;
        int count = 0;
        
        while (i != 0) {
            count++;
            i = (i - 1) & i;
        }
        return count;
    }
	public static void main(String[] args) {
		int i = 1, j = 4;
		System.out.println("Hamming Distance is: " + hammingDistance(i, j)); // 2
	}

		/*
		 * 解题思路：两个数不同binary数值（0 和1），可以通过异或（bitwise XOR）得到。 
		 * 然后每次用 这个数 - 1 && 这个数，每次count加1. 这样可以得到所有不同的位数。即hamming distance
		 */
}
