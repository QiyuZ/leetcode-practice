class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int max = 0, m = M.length, n = M[0].length;
        int[][][] dp = new int[m][n][4]; //最后一维代表着四个方向
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] != 1) continue;
                for (int k = 0; k < 4; k++) dp[i][j][k] = 1; //如果等于1先给四个方向赋值
                if (j > 0) dp[i][j][0] += dp[i][j - 1][0];//横着的
                if (i > 0) dp[i][j][1] += dp[i - 1][j][1];//竖着的
                if (i > 0 && j > 0) dp[i][j][2] += dp[i - 1][j - 1][2];//对角线
                if (i > 0 && j < n - 1) dp[i][j][3] += dp[i - 1][j + 1][3];//反对角线
                max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        }
        return max;
    }
}
