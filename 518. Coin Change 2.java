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
/**
* The reason why we cannot change the order of loop is:
*
* When looping coins first, we are always appending a new coin type (or not) to previous combination of coins(for * a smaller target number), since previous combination is always unique, appending a new type of coins will make * the combination still unique. We are always considering the different coin type in next loop.
* When looping amount first, it will happen the following scenario:
* If we want to get amount of 8, we can append 3 and append 5, also we can append 5 and append 3 to achieve it. * * In this way, we use the two coin(3 and 5) in different way, but the same number (one for each). We will keep * * considering the previous type of coin when the amount is increasing.
*/
