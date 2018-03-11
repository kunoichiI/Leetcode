package etc;
/*
 * Given a positive number N, print a pascal triangle, the last level is the number of N
 *          n = 3
 *          *
 *         ***
 *        *****
 *  
 */
public class PrintTriangleGivenN {
	public static void printTriangle(int n) {
		for (int i = 1; i <= 2 * n - 1; i += 2) { // every level is 2 more * than the previous level
			printSequence(" ", (2 * n - 1 - i) / 2);
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			printSequence(" ", (2 * n - 1 - i) / 2);
			System.out.println();
		}
	}
	
	public static void printSequence(String s, int num) {
		for (int i = 0; i < num; i++)
			System.out.print(s);
	}
	public static void main(String[] args) {
		printTriangle(5);

	}

}
