class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n]; //从 i到j要几步
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; //一个单独字母就一步
            if (i + 1 < n) dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 2; //如果相邻相等则一步，否则两步
        }
        
        for (int len = 2; len < n; len++) { //因为之前考虑过了一步，所以直接从2开始
            for (int start = 0; start + len < n; start++) { //起点
                dp[start][start + len] = s.charAt(start) == s.charAt(start + len) ? len : len + 1; //最差情况一个个加
                for (int k = 0; k < len; k++) { //从start 到start+len中间一个个试
                    int cur = dp[start][start + k] + dp[start + k + 1][start + len]; //a->c = a->b + b->c
                    dp[start][start + len] = Math.min(dp[start][start + len], 
                                                      s.charAt(start + k) == s.charAt(start + len) ? cur - 1 : cur); //
                }
            }
        }
        return dp[0][n - 1];
    }
}
