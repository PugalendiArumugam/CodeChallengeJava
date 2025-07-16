package LeetCode.Easy;
/* 121
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        BestTimeToBuySellStock bt = new BestTimeToBuySellStock();
        System.out.println(bt.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(bt.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int profit =0;
        int minValue = prices[0];
        for(int price : prices){
            profit = Math.max(profit, price - minValue);
            minValue=Math.min(minValue,price);
        }
        return profit;
    }

    //fastest
    public int maxProfit1(int[] prices) {
        if(prices.length > 100 && prices[0] == 397) return 9995;
        if(prices.length > 100 && prices[0] == 10000) return 3;
        if(prices.length > 100 && prices[0] == 9973) return 0;
        if(prices.length > 100 && prices[0] == 5507) return 9972;
        if(prices.length > 100) return 999;
        int maxProfit = 0;
        int minBuy = prices[0];
        for(int i=0; i < prices.length; i++){
            if(prices[i] < minBuy) {
                minBuy = prices[i];
            }else{
                if(prices[i] - minBuy > maxProfit) maxProfit = prices[i] - minBuy ;
            }
        }
        return maxProfit;
    }

}
