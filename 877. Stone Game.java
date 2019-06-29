class Solution {
    public boolean stoneGame(int[] piles) {
        if (piles.length == 2) return true;
       int n = piles.length;
        int[][] dp = new int[n][n]; //dp[i][j]表示从i到j 比对手多几个石头，不限制是Alex还是lee
        for (int i = 0; i < n; i++) dp[i][i] = piles[i]; //因为只有一个那个肯定是多这个个数
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
                //这里是关键从相邻开始扩展同时遍历i
                //取头或者取尾，用-来表示是因为当前dp[i][j]是我比你多，我可以选头或者选尾，但是之后因为该你选了比如dp[i+1][i+d]就是你比我多，那么我选这个可以让我比你多多少？ 就要减
            }
        }
        return dp[0][n - 1] > 0; //我和你是动态的那么怎么判断Alex呢，因为他是先手，所以看从0到n-1的
    }
}
