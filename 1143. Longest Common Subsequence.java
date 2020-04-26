class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; //dp[i][j] text1的第i位和text2的第j位前一共有多少一样的
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0; //边界都是0
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1; //如果相等，等于上一位的+1
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //不相等则为text1或者text2前一位的比较
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
