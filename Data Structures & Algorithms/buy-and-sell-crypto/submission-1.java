class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minLeft = Integer.MAX_VALUE;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < minLeft) minLeft = prices[i - 1];
            if(prices[i] - minLeft > maxProfit) maxProfit = prices[i] - minLeft;
        }

        return maxProfit;
    }
}
