class Solution {
    //背包问题 dp[i][j] += dp[i - group[k]][j - profit[k]] dp[i][j]表示i个人利润大于j的方案数量
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[G + 1][P + 1];
        int mod = 1000000007;
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            for (int i = G; i >= group[k]; i--) {
                for (int j = P; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - group[k]][Math.max(0, j - profit[k])]) % mod;
                    //注意人数要小于等于本次可用的， 但是profit[k]可以很大记到0上
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= G; i++) {
            res = (res + dp[i][P]) % mod;
        }
        return res;
    }
}
