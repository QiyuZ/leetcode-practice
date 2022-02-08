class Solution {
    public long maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) dp[j] += points[i][j];
            for (int j = 1; j < n; j++) dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            for (int j = n - 2; j >= 0; j--) dp[j] = Math.max(dp[j], dp[j + 1] - 1);
        }
        long max = dp[0];
        for (int i = 1; i < n; i++) max = Math.max(max, dp[i]);
        return max;
    }
}

//line 8 and 9 means what the max number could be if calculating the col difference right now, for the next col
//eg. [3,1,1] -> [3,2,1] 1->2 as assume the next number get 3 - (1 - 0)
