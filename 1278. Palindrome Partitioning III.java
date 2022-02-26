class Solution {
    Integer[][][] memo;
    public int palindromePartition(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) return -1;
        int n = s.length();
        if (k == n) return 0;
        memo = new Integer[n + 1][n + 1][k + 1];
        return dfs(0, 0, k, s);
    }
    
    private int dfs(int pos, int start, int k, String s) { //pos: current index, the place we do the cut, start: start of the partition
        if (pos == s.length()) {
            if (start == s.length() && k == 0) return 0;
            return s.length() + 1;
        }
        if (memo[start][pos][k] != null) return memo[start][pos][k];
        int continuePartition = dfs(pos + 1, start, k, s); //cut at next position
        int partitionHere = k >= 1 ? needChange(s, start, pos) + dfs(pos + 1, pos + 1, k - 1, s) : s.length() + 1; //if we can cut then recursive; if we cant then it's invalid
        return memo[start][pos][k] = Math.min(continuePartition, partitionHere);
    }
    
    private int needChange(String s, int l, int r) {
        int count = 0;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) count++;
        }
        return count;
    }
}
 
