class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][8];//dp[i][j]第i次扔骰子以j结尾的总个数  dp[i][7]第i次扔骰子总个数
        // for (int i = 1; i < 8; i++) dp[1][i] = 1;
        // dp[0][7] = 6;
        dp[0][7] = 1;   //等效于上面的写法，好处是如果rollMax中有0则上面不成立
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 6; j++) {
                int k = i - rollMax[j - 1];
                dp[i][j] = dp[i - 1][7];//理想情况全部基于上一次都符合, base case
                if (k == 1) dp[i][j]--; //比如i=3, rollMax[5]即6的限制是2,排除一种66即可
                else if (k > 1) { 
                    int reduction = dp[k - 1][7] - dp[k - 1][j];
                    //注意这里是i - rollMax[j - 1] - 1因为比如i = 8, rollMax[5]即6的限制是3，那么此时该第8位了前面有7位，以XXXX666结尾的是不合法的
                    //而666是固定的而不会出现xxx6666因为是不合法，已经排除过，所以要找的是xxx1,xxx2,xxx3,xxx4,xxx5,即dp[4][7]-dp[4][6]减去6的找其他
                    dp[i][j] = ((dp[i - 1][7] - reduction) % mod + mod) % mod;
                }
                dp[i][7] = (dp[i][7] + dp[i][j] % mod) % mod;              
            }
        }
        return dp[n][7];
    }
}
