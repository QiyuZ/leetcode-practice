class Solution {
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins); //排序为了从大开始取值
        dfs(coins,amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public void dfs(int[] coins, int amount, int index, int count) {
        if (amount == 0) min = Math.min(min, count);
        if (index < 0) return; //全部试完了
        int possible = amount / coins[index]; //该面值可以取的最大数量
        for (int i = possible; i >= 0; i--) {
            if (count + i < min) dfs(coins, amount - i * coins[index], index - 1, count + i);
            else break;
        }
    }
}

public class Solution {
    Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int max = amount + 2;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { //从总额度1开始一直到目标值
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return (dp[amount] == amount + 2) ? -1 : dp[amount];
    }
}
