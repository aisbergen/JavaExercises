class Solution {
    public int maxProfit(int[] prices) {
        int lowest_price = prices[0];
        int highest_profit = 0;
        for(int todays_price : prices){
            highest_profit = Math.max(highest_profit, todays_price - lowest_price);
            lowest_price = Math.min(lowest_price, todays_price);
        }
        return highest_profit;
    }
}