
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        //    之前买或者今天买    之前卖或者今天卖
        int[] hold = new int[n], unhold = new int[n]; //hold[i]第i天后手中有股票的profit, unhold[i]第i天结束后手中没有股票profit
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) hold[i] = Math.max(-prices[i], hold[i - 1]);
            else hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]); //前一天的hold或者是两天前unhold然后买入（cooldown一天）
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]); //前一天的或者这个时候昨天的现在卖出去
        }
        return unhold[n - 1];//是unhold不是hold的原因是，最后一天手里不应该有股票
    }
}


//通过上面for循环中可以看出，其实只涉及到之前/当前的买和卖，所以不用数组
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int pre_sell = 0, sell =0; //可以说buy是买股后的利益，sell是卖股后的利益
        int buy = Integer.MIN_VALUE, pre_buy = 0; //初始化buy一个最小值
        for (int price : prices) {
            pre_buy = buy; 
            buy = Math.max(pre_buy, pre_sell - price); //buy是pre_buy或者之前盈利再买
            pre_sell = sell;
            sell = Math.max(pre_sell, pre_buy + price); //之前盈利或者之前花过钱的盈利再卖
            //因为sell和buy都是和pre_buy和pre_sell有关，sell和buy不直接相关，所以肯定至少差一天
        }
        return sell;
    }
}
