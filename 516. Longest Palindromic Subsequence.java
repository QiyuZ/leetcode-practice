class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()]; 
        for (int i = s.length() - 1; i >= 0; i--) { //i 相当于左边 the substring from i to j
            dp[i][i] = 1;   //初始化，不能dp[j][j]=0 英文j范围不全，或者实现先对角线=1
            for (int j = i + 1; j < s.length(); j++) { //j相当于右边
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;  
                //两边相等，相当于中间已有的+2，即使ij相邻处理过变成比如dp[3][2]也没关系，因为这是0                
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); //不等就左边少一位或者右边少一位最大的
            }
        }
        return dp[0][s.length() - 1];
    }
}
/*举例 bbbab dp[0][4] 两b相等，则看bba有几个回文。2个，加2
cbbd dp[1][2] 两b相等 dp[2][1]不存在,但是不影响，因为是0
     dp[0][3] 不相等，则看bbd或者cbb最大值 */
