package leetcode;

//Given predicted stock prices for next n days for a stock e.g : 20, 40, 52, 15, 30, 50, 10, 25 
//find the maximum profit that can be made with a single buy-sell transaction. If no profit can be made return 0. In the example buying at 15 and selling at 50 gives maximum profit. 
//		Note that the two prices are neither minimum nor maximum in the array

public class BiggestProfitBuyStocks {
	public int buyStock(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < A.length; i++) {
			int j = i -1;
			while(j >= 0 && A[j] < A[i]) {
				int profit = A[i] - A[j];
				if (profit > max) {
					max = profit;
				}
				j--;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] A = {20, 40, 52, 15, 30, 50, 10, 25};
		BiggestProfitBuyStocks bpbs = new BiggestProfitBuyStocks();
		System.out.print(bpbs.buyStock(A));

	}

}
