class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return helper(prices);
        int[][] dp = new int[k + 1][len]; //dp[i][j]表示i次交易下到j时的最大利润
        for (int i = 1; i <= k; i++) {//起始1最少一次交易
            int temProfit = -prices[0];
            for (int j = 1; j < len; j++) {//起始1，因为第一次不能卖
                dp[i][j] = Math.max(dp[i][j - 1], temProfit + prices[j]); //之前的利润或者，当前的利润加上当前的价格
                temProfit = Math.max(temProfit, dp[i - 1][j - 1] - prices[j]); //之前的最大当前利润或者再买入新的，注意这里是i-1因为交易次数少1
            }
        }
        return dp[k][len - 1];
    }
    public int helper(int[] prices) { //这是第二题的解法，证明可画图，全部差值之和等于最大/小值之差
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }
        return res;
    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) return 0;
        int n = prices.length;
        if (2 * k >= n) return quickSolution(prices); //相当于随意买卖参考122
        int[] cost = new int[k + 1], profit = new int[k + 1];
        Arrays.fill(cost, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                cost[i] = Math.max(cost[i], profit[i - 1] - price); //找最大因为是负数，当然后面盈利了就是正数了
                profit[i] = Math.max(profit[i], cost[i] + price);
            }
        }
        return profit[k];
    }
    
    private int quickSolution(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) res += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        return res;
    }
}
