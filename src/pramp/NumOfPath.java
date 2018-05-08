package pramp;

import java.util.Arrays;

//You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid. 
//The car is supposed to get to the opposite, Northeast (top-right), 
//corner of the grid. Given n, the size of the grid’s axes, write a function numOfPathsToDest 
//that returns the number of the possible paths the driverless car can take.

//For convenience, let’s represent every square in the grid as a pair (i,j). 
//The first coordinate in the pair denotes the east-to-west axis, 
//and the second coordinate denotes the south-to-north axis. 
//The initial state of the car is (0,0), and the destination is (n-1,n-1).
//
//The car must abide by the following two rules: it cannot cross the diagonal border. 
//In other words, in every step the position (i,j) needs to maintain i >= j. 
//See the illustration above for n = 5. In every step, it may go one square North (up), 
//or one square East (right), but not both. 
//E.g. if the car is at (3,1), it may go to (3,2) or (4,1).
//
//Explain the correctness of your function, and analyze its time and space complexities.
public class NumOfPath { // 01/12/2018 pramp mock interview asked this question
	public static int numOfPathsToDest(int n) {
		int[][] memo = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			memo[i][0] = 1;
		}
	
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i < j) 
					memo[i][j] = 0;
				else
					memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
			}
		}
		System.out.println("memo looks like: ");
		System.out.println(Arrays.deepToString(memo));
		return memo[n-1][n-1];
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(numOfPathsToDest(1)); // 1
		System.out.println(numOfPathsToDest(2)); // 1
		System.out.println(numOfPathsToDest(3)); // 2
		System.out.println(numOfPathsToDest(4)); // 5
		System.out.println(numOfPathsToDest(5)); // 14
		System.out.println(numOfPathsToDest(17)); // 35357670
		System.out.println(numOfPathsToDest(100)); // 2126189612
	}

}
