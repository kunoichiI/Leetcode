package pramp;
// An iterative solution to solve the numOfPath problem
public class NumOfPath2 {
	public static int NumOfPathsToDest(int n) {
		if (n == 1)
			return 1;
		
		// initialize two rows to store path results
		int[] prevRow = new int[n];
		for (int i: prevRow) {
			prevRow[i] = 1;
		}
		
		int[] curRow = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					curRow[j] = prevRow[j];
				} else {
					curRow[j] = prevRow[j] + curRow[j-1];
				}
			}
			prevRow = curRow;
		}
		return curRow[n-1];
	}
	public static void main(String[] args) {
		System.out.println(NumOfPathsToDest(1)); // 1
		System.out.println(NumOfPathsToDest(2)); // 1
		System.out.println(NumOfPathsToDest(3)); // 2
		System.out.println(NumOfPathsToDest(5)); // 14
		System.out.println(NumOfPathsToDest(17)); //35357670
	}

}
