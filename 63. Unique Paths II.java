class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (m == 0 && n == 0) return 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) { //边界有1后面全是1
            if (obstacleGrid[i][0] == 1) {
                while (i < m) obstacleGrid[i++][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                while (j < n) obstacleGrid[0][j++] = 1;
            }
        }
        for (int i = 0; i < m; i++) { //障碍为0.空位1
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) res[i][j] = 0;
                else res[i][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (res[i][j] == 0) continue; //常规dp,不甲酸障碍
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) { //一排一排看，有几条路到row[j]
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}

/**
     * obstacleGrid =  0,0,0
     *                 0,1,0
     *                 0,0,0
     *    index of dp 0,1,2,3
     
     *   first time   0,1,1,1
     *   sec   time   0,1,0,1
     *   third time   0,1,1,2
     **/
