class Solution {
    private final int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {//dp[steps][position] = dp[steps-1][position] + dp[steps-1][position+1] + dp[steps-1][position-1]
        int maxPos = Math.min(steps, arrLen);  //                      stay                    right                     left                        
        int[][] dp = new int[steps + 1][maxPos];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < maxPos; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD; //stay
                if (j + 1 < maxPos && dp[i - 1][j + 1] > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD; //go right
                if (j - 1 >= 0 && dp[i - 1][j - 1] > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD; //go right
            }
        }
        return dp[steps][0]; 
    }
}
