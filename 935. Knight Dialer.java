class Solution {
    public int knightDialer(int N) { //dp
        int[][] dirs = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}}; //记录当前的数字是从哪里来的
        int[][] dp = new int[N + 1][10]; //N 个，从1-10
        for (int i = 0; i < 10; i++) dp[1][i] = 1; //初始化，一位的是1
        int mod = 1000000007;
        for (int i = 2; i <= N; i++) { //没有0位，1位已经初始化1
            for (int j = 0; j < 10; j++) {
                int[] dir = dirs[j];
                for (int d : dir) {
                    dp[i][j] = (dp[i - 1][d] % mod + dp[i][j]) % mod; //当前的等于现有的加上上一个的
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[N][i] % mod) % mod; //可以从任意数开始，都+1
        }
        return res;
    }
}
