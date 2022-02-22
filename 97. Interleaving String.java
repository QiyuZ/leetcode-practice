class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1, 0, s2, 0, s3, 0, new boolean[s1.length()][s2.length()]);
    }
    private boolean dfs(String s1, int index1, String s2, int index2, String s3, int index3, boolean[][] visited) {
        if (index3 == s3.length()) return true;
        if (index1 == s1.length()) return s3.substring(index3).equals(s2.substring(index2));
        if (index2 == s2.length()) return s3.substring(index3).equals(s1.substring(index1));
        if (visited[index1][index2]) return false;
        boolean res = false;
        if (s1.charAt(index1) == s3.charAt(index3)) res = dfs(s1, index1 + 1, s2, index2, s3, index3 + 1, visited);
        if (s2.charAt(index2) == s3.charAt(index3)) res = res || dfs(s1, index1, s2, index2 + 1, s3, index3 + 1, visited); //dont use else if as we should try both, as we need to check or, as we just need one valid case
        visited[index1][index2] = true; //dont need to revert to false, as if it's invalid to get an answer, dont visit it again
        return res;
    }
}


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); int len2 = s2.length(); int len3 = s3.length();
        if(len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true; //for all empty case
        
        /*
        If S2 is empty, then just check whether char in s1 matches with that of s3
        Note: j == 0 here.
        */
        for(int i = 1; i <= len1; i++) dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        
        /*
        If S1 is empty, then just check whether char in s2 matches with that of s3
        Note: i == 0 here.
        */
        for(int j = 1; j <= len2; j++) dp[0][j] = dp[0][j-1] && s3.charAt(j-1) == s2.charAt(j-1);
        
        /*
        Now check for both s1,s2 being non empty
        */
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                // Characters to be compared
                int c1 = s1.charAt(i - 1);
                int c2 = s2.charAt(j - 1);
                int c3 = s3.charAt(i + j - 1);
                // If c3 matches c1, then is every char before c1 in s1 valid?
                // If c3 matches c2, then is every char before c2 in s2 valid?
                dp[i][j] = (c1 == c3 && dp[i-1][j]) || (c2 == c3 && dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
