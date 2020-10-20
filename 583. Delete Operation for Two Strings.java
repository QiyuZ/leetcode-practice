class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null || word1.length() == 0 && word2.length() == 0) return 0;
        if (word1.length() == 0 || word2.length() == 0) return word1.length() == 0 ? word2.length() : word1.length();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[m][n]; //找出longest common sub sequence, 剩下的就是要操作的，注意乘以2因为是两者的
    }
}
