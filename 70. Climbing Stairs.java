class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) { 
            if (i == 0) dp[i] = 1;
            else if (i == 1) dp[i] = 2; //特殊考虑防止越界
            else dp[i] += dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
