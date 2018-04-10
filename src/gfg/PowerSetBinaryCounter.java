package gfg;
/*
 * Finding all subsets of a given set in Java
	Problem: Find all the subsets of a given set.
	
	Input: 
	S = {a, b, c, d}
	Output:
	{}, {a} , {b}, {c}, {d}, {a,b}, {a,c},
	{a,d}, {b,c}, {b,d}, {c,d}, {a,b,c}, 
	{a,b,d}, {a,c,d}, {b,c,d}, {a,b,c,d}
	
	ref: https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 */
public class PowerSetBinaryCounter {
	public static void printPowerSets(char[] set) {
		int n = set.length;
		// Run a loop to print all 2 ^ n subsets one by one
		for (int i = 0; i < (1 << n); i++) { // Loop from 0 ~ 2 ^ n
			System.out.print(" { ");
			for (int j = 0; j < n; j++) { // j : 0, 1, 2, 3
				if ((i & (1 << j)) > 0) {
					System.out.print(set[j] + " ");
				}
			}
			System.out.println("}");
		}
	}
	public static void main(String[] args) {
		char set[] = {'a', 'b', 'c'};
		printPowerSets(set);

	}
	/*
	 * 1 << n means left shift binary 1(01) by n times. 1 << 2 -> 100 
	 * 1 << n gets 2 ^ n. Typically a set has 2 ^ n power sets.
	 */
}
