package leetcodeAbove100;
//121. Best Time to Buy and Sell Stock
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//Example 1:
//Input: [7, 1, 5, 3, 6, 4]
//Output: 5
//
//max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//Example 2:
//Input: [7, 6, 4, 3, 1]
//Output: 0
//In this case, no transaction is done, i.e. max profit = 0.
public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
        // if no ascending pair, then maxProfit is 0
        // compare all ascending pairs and get the maxProfit by Max(SellPrice - BuyPrice)
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = prices[0];
        int ans = 0;
        
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int[] descPrices = { 7, 6, 5, 4, 3, 1 };
		System.out.println("The maxProfit is: " + maxProfit(prices)); // 5 (6 - 1)
		System.out.println("The maxProfit for descending prices is: " + maxProfit(descPrices)); // 0
	}

}
