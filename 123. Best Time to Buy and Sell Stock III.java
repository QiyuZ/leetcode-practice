class Solution {
    public int maxProfit(int[] prices) {
        int buy0 = Integer.MAX_VALUE, profit0 = 0, buy1 = Integer.MAX_VALUE, profit1 = 0;
        for (int p : prices) {
            buy0 = Math.min(buy0, p); //找花费最小
            profit0 = Math.max(profit0, p - buy0); //找获益最大
            buy1 = Math.min(buy1, p - profit0); //再一次买的时候，可以认为 花的钱是当前的价格-之前的获利
            profit1 = Math.max(profit1, p - buy1);
        }
        return profit1;
    }
}
