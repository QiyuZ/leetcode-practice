class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];  //表示减去/加上val之前的生命值
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]); 
        //最后一个的生命值至少为1或者是比它大1的数，比如例子中-5，就是6
        //因为最后一个可能是正数，所以不用很大的正数，只有是1就可以了
        for (int i = n - 2; i >= 0; i--) dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
        for (int i = m - 2; i >= 0; i--) dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] += Math.min(down, right);
            }
        }
        return dp[0][0];
    }
}
//通项公式 dp[i][j] = dp[i + 1][j](dp[i][j + 1]) - dungeon[i][j]; 但是有可能是负数，要保证最小为1，所以是找两者最大值
