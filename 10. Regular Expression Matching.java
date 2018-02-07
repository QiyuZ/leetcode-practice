class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //p=“”时肯定不match但是，s=""， p可能match，比如“a*”，所以要先处理一遍
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true; //看p 前面的前面能不能匹配上，如果可以就把a*作为空
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2]; //不match那就当做empty看待因为这是j位是*所以要和j-1的相等
                    } else {
                        dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2]);
                                    //single char   multiple char   empty
                        //举例aa a*          aaaa a*              b ba*
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
