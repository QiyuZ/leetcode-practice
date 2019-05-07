class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1]; //dp[i][j] means A[i], B[j]前多少连续相等
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if(A[i - 1] == B[j - 1]) { //当前相等则在之前的基础上+1
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        res = Math.max(res,dp[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
