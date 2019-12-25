class Solution {
    public int longestRepeatingSubstring(String S) {
        int n = S.length(), res = 0;
        int[][] dp = new int[n + 1][n + 1]; //dp[i][j] means longest repeating substring that ends at i and j position of the string.
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
