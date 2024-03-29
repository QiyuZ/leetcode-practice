class Solution {
    public int minInsertions(String s) { //see 516. Longest Palindromic Subsequence, find the sub-panlindrome then n-x is the amounts that we can add (if the question is remove, it's the same answer)
        if (s == null || s.length() <= 1) return 0;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(n - 1 - j)) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return n - dp[n][n];
    }
}
