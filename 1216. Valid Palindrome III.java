class Solution { //actually same as 1312. Minimum Insertion Steps to Make a String Palindrome.java
    public boolean isValidPalindrome(String s, int k) {
        if (s == null || s.length() <= 1) return true;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(s.length() - 1 - j)) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return n - dp[n][n] <= k;
    }
}
