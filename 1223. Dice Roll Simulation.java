class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][7];//dp[i][j]第i次扔骰子以j结尾的总个数  dp[i][7]第i次扔骰子总个数
        // for (int i = 1; i < 8; i++) dp[1][i] = 1;
        // dp[i][7] = 6;
        dp[0][6] = 1;   //等效于上面的写法，好处是如果rollMax中有0则上面不成立
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 6; j++) {
                dp[i][j] = dp[i - 1][6];//理想情况全部基于上一次都符合
                if(i - rollMax[j] > 0) {
                    int reduction = dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j];
                    //注意这里是i - rollMax[j] - 1因为比如最多有一个连续1出现，那么要找的是x21,x31,x41,x51,x61(x11已经在前面一轮排除了)
                    //所以要找的是i - rollMax[j]之前那一轮的符合结果的，排除以j结尾的
                    dp[i][j] = ((dp[i][j] - reduction) % mod + mod) % mod;
                }
                dp[i][6] = (dp[i][6] + dp[i][j] % mod) % mod;              
            }
        }
        return dp[n][6];
    }
}
