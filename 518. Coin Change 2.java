class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; //注意这里是几种方法而不是几个coin
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin]; 
                //举例，组成五元的方法个数=之前组成五元的方法个数（不包括2元）+ 组成3元的方法个数（因为这个时候遇到coin=2相当于要用2这个coin）
            }
        }
        return dp[amount];
    }
}
