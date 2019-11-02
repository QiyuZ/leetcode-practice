class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d + 1][target + 1];
        dp[0][0] = 1; //起始状态为1，其实相当于递归条件下去到了d=0, target=0的状态，这时就是1说明找到了符合条件的
        int mod = 1000000007;
        for (int i = 1; i <= d; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (k > j) break;
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }
        return (int)dp[d][target];
    }
}
