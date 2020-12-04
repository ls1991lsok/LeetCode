/* 

121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.


Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            if(price < buy) buy = price;
            else profit = Math.max(profit, price - buy);
        }
        
        return profit;
    }
}

/****************************************************

Solution 2 --- DP

let's denote elements of example 1 input [7,1,5,3,6,4]

as 7 = a1, 1 = a2, ...

If we wanna find the max profit, which is a5 - a2, then

this equals to (a5 - a4) + (a4 - a3) + (a3 - a2)

****************************************************/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int tempProfit = 0;
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            tempProfit = Math.max(0, tempProfit += (prices[i + 1] - prices[i]));
            profit = Math.max(tempProfit, profit);
        }
        
        return profit;
    }
}