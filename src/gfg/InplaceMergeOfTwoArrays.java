package gfg;
// GFG
//We have an array of size m+n in which m elements are present, in sorted order, and a second array of size n, again in sorted order. We want both of them to be sorted and present in the first array. No third array is supposed to be given.
//
//Example:
//
//   1, 3, 55, 66, 77, _, _, _ 
//   5, 9, 20 
//The answer would be:
//
//   1, 3, 5, 9, 20, 55, 66, 77 

public class InplaceMergeOfTwoArrays {
	public void moveToEnd(int[] mPlusN, int size) {
		int i, j = size - 1;
        for (i = size - 1; i >= 0; i--) 
        {
            if (mPlusN[i] != -1) 
            {
                mPlusN[j] = mPlusN[i];
                j--;
            }
        }
	}
	public void merge(int[] mPlusN, int[] N, int m, int n) { //m+n:size of mPlusN[], n:size of N[], merge N[] into mPlusN[]
//		for (int x = 0; x < n; x++) {
//			mPlusN[x] = -1;
//		}
		
		for (int i : mPlusN) {
			System.out.print(i + " ");
		}
		System.out.println();
		int i = n; // mPlusN start index for not being -1
		int j = 0; // N current start index 
		int k = 0; // output mPlusN current start index
		while(k < (m+n)) {
			if  ( (j == n) ||(i < (m+n) && mPlusN[i] <= N[j] )) {// take a value from mPlusN and if value is smaller and we have not reached the 
				// end of N[] or we have reached the end of N[]
				mPlusN[k] = mPlusN[i];
				//System.out.println("i:" + i);
				k++;
				i++;
			}else { // otherwise take value from N[]
				mPlusN[k] = N[j];
				//System.out.println("j:" + j);
				k++;
				j++;
			}
		}
		
	}
	public static void main(String[] args) {
		int[] A = {2, 4, -1, -1, -1, -1, 6, 8};
		int[] B = {1, 3, 5, 7};
		int n = B.length;
		int m = A.length - n;
		InplaceMergeOfTwoArrays imta = new InplaceMergeOfTwoArrays();
		imta.moveToEnd(A, m+n);
		
		System.out.println();
		imta.merge(A, B, m, n);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

}
