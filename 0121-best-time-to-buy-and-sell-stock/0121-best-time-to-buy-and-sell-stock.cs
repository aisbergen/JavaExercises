public class Solution {
    public int MaxProfit(int[] prices) {
        int profit = 0;
        
        for(int i=0;i<prices.Length;i++){
            if(prices[0]<prices[i]){
                profit = Math.Max(profit, prices[i] - prices[0]);
            }else{
                prices[0] = prices[i];
            }
        }
        return profit;
    }
}