class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        if (houses == null || houses.length == 0 || cost == null || cost.length == 0 || target <= 0) return 0;
        long[][][] dp = new long[m][n][m + 1]; //dp[i][j][k] i th house with j th color forming k group costs dp[i][j][k] money
        //用long是因为后面mark Integer.MAX_VALUE的，可能被别的值加减， 也可以直接跳过
        for (int k = 0; k <= m; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (k == 0 || k > i + 1) dp[i][j][k] = Integer.MAX_VALUE;//特殊不成立情况，0组或者比房子个数还多的组
                    else if (i == 0) {//特殊成立情况，因为成组后面要i-1所以先考虑第一个房子的特殊情况，而颜色无所谓
                        if (houses[i] != 0) dp[i][j][k] = j + 1 == houses[i] ? (long)0 : (long)Integer.MAX_VALUE; //如果已经有颜色，颜色和当前相同则无花费，不同则不成立
                        else dp[i][j][k] = (long)cost[i][j]; //因为是第一个所以就直接赋值
                    } else { //剩下正常情况
                        if (houses[i] != 0) {
                            if (j + 1 != houses[i]) dp[i][j][k] = (long)Integer.MAX_VALUE;
                            else {
                                dp[i][j][k] = dp[i - 1][j][k]; //可初始化成和上一个房子一样颜色，即组不变
                                for (int l = 0; l < n; l++) {
                                    if (l == j) continue;
                                    dp[i][j][k] = (long)Math.min(dp[i][j][k], dp[i - 1][l][k - 1]); //如果颜色不同，则相当于这个组是新加的，则找上一组的
                                }
                            }
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k] + (long)cost[i][j];
                            for (int l = 0; l < n; l++) {
                                if (l == j) continue;
                                dp[i][j][k] = (long)Math.min(dp[i][j][k], dp[i - 1][l][k - 1] + (long)cost[i][j]);
                            }
                        }
                    }
                }
            }
        }
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) res = (long)Math.min(res, dp[m - 1][i][target]);
        return res == Integer.MAX_VALUE ? -1 : (int)res;
    }
}
