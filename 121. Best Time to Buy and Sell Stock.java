class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE, res = 0;
        for (int p : prices) { //卖出一定在买入之后
            if (min > p) min = p; //看是否能更新min,即买入
            else if (p - min > res) res = p - min;//这样保证一定卖出在买入之后
        }
        return res;
    }
}
