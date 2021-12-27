class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;
        int l1 = s1.length(), l2 = s2.length();
        Boolean[][][] dp = new Boolean[l1 + 1][l2 + 1][2000]; //at most 3 digits, that's 1000 because when compare it could be -999 to 999 so we use 2000
        // dp[i][j][diff] means if s1[i:] truncated by <diff> characters if diff > 0 
        // and s2[j:] truncated by <-diff> characters if diff < 0 are equal
        return dfs(0, 0 , 0, s1.toCharArray(), s2.toCharArray(), dp);
    }
    
    private boolean dfs(int i, int j, int diff, char[] s1, char[] s2, Boolean[][][] dp) {
        if (i == s1.length && j == s2.length) return diff == 0;
        if (dp[i][j][1000 + diff] != null) return dp[i][j][1000 + diff];
        // Literal matching on s1[i] and s2[j]
        if (i < s1.length && j < s2.length && diff == 0 && s1[i] == s2[j]) { //all chars
            if (dfs(i + 1, j + 1, 0, s1, s2, dp)) return dp[i][j][1000] = true;
        }
        // Literal matching on s1[i]
        if (i < s1.length && !Character.isDigit(s1[i]) && diff > 0 && dfs(i + 1, j, diff - 1, s1, s2, dp)) {
            return dp[i][j][diff + 1000] = true;
        }
        // Literal matching on s2[j]
        if (j < s2.length && !Character.isDigit(s2[j]) && diff < 0 && dfs(i, j + 1, diff + 1, s1, s2, dp)) {
            return dp[i][j][diff + 1000] = true;
        }
        // Wildcard matching on s1[i]
        for (int k = i, val = 0; k < s1.length && Character.isDigit(s1[k]); ++k) {
            val = val * 10 + (s1[k] - '0');
            if (dfs(k + 1, j, diff - val, s1, s2, dp)) return dp[i][j][diff + 1000] = true;
        }
        // Wildcard matching on s2[j]
        for (int k = j, val = 0; k < s2.length && Character.isDigit(s2[k]); ++k) {
            val = val * 10 + (s2[k] - '0');
            if (dfs(i, k + 1, diff + val, s1, s2, dp)) return dp[i][j][diff + 1000] = true;
        }
        return dp[i][j][diff + 1000] = false;
    }
}
