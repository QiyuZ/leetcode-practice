class Solution {
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price); //注意是负数，而要找花钱最少的，要max
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price); //已经有了sell1的钱
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
