// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int days = prices.length;
//         int[] buy = new int[days], sell = new int[days];
//         buy[0] = -prices[0] - fee; //假设买的时候收费（卖的时候收费也可以假设）
//         for (int i = 1; i < days; i++) {
//             buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee); //前一天的买或者在在卖出的基础上今天买
//             sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);//前一天的卖或者在在买入的基础上今天卖
//         }
//         return sell[days - 1];
//     }
// }

//to save space
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0] - fee, sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int preBuy = buy;  //因为下面第一个是buy,如果第一个是sell就
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, preBuy + prices[i]);
        }
        return sell;
    }
}
