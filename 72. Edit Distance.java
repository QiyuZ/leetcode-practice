class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;//注意初始化，因为是要修改的个数一个是0，一个是i所以i个要修改
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];//本位不修改，结果和上一位一样
                else dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                //本位进行操作base是i-1,j-1，
                //                       i-1的结果和j一样说明本位要删去，插入    强行和之前一样是替换  
            }
        }
        return dp[m][n];
    }
}


