class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = i; //初始化，一个是空对于别的都是i
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i][j], dp[i + 1][j])) + 1;
                                               //插入（j的插入）        替换       删除（相当于i的插入）
            }
        }
        return dp[m][n];
    }
}
