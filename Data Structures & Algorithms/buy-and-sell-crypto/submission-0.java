class Solution {
    public int maxProfit(int[] prices) {

        int[] prefix = new int[prices.length];
        int minLeft = Integer.MAX_VALUE;
        prefix[0] = minLeft;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < minLeft) minLeft = prices[i - 1];
            prefix[i] = minLeft;
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] - prefix[i] > maxProfit) maxProfit = prices[i] - prefix[i];
        }

        return maxProfit;
    }
}
