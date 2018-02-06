/* There is a ball on the nth stairs, and it wants to get to the ground(level 0). There are some sticky stairs, 
and once the ball lands on the sticky stair, it is stuck and can never move. During odd turns, you can jump down 1, 2, or 4 stairs.  
During even turns, you can jump down 1, 3, 4 stairs. Return the number of ways you can get to ground. */


class Solution {
    public int jumpToGround (boolean[] sticky, int n) {
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 3;
        dp[1][1] = 3;
        for (int i = 2; i <= n; i++) {
            if (sticky[i - 1]) { //不能动的情况
                dp[i][0] = 0;
                dp[i][1] = 0;
            } else {
                if (i - 1 >= 1) {
                    dp[i][0] += dp[i-1][1];
                    dp[i][1] += dp[i-1][0];
                }
                if (i - 2 >= 1) {
                    dp[i][0] += dp[i-2][1];
                }
                if (i - 3 >= 1) {
                  dp[i][1] += dp[i -3][0];
                }
                if ( i - 4 >= 1) {
                    dp[i][0] += dp[i-4][1];
                    dp[i][1] += dp[i-4][0];
                }
           }
        }
        return dp[n][0] + dp[n][1];
    }
}
