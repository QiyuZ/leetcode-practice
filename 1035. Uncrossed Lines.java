class Solution {
    public int maxUncrossedLines(int[] A, int[] B) { //其实转换问题就是不能交叉，1143. Longest Common Subsequence and same as edit distance and
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1; //相等就在上一个+1
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //不相等就找上一个较大的
            }
        }
        return dp[m][n];
    }
}
