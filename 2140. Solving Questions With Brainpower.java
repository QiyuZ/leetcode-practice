class Solution {
    private Long[] memo;
    public long mostPoints(int[][] questions) { //actually same as dp O(n) since we use memo to make sure only visit once for each one
        this.memo = new Long[questions.length];
        if (questions == null || questions.length == 0) return 0;
        return dfs(questions, 0);
    }
    private long dfs(int[][] questions, int index) {
        if (index >= questions.length) return 0;
        if (memo[index] != null) return memo[index];
        long cur = 0;
        long include = dfs(questions, index + questions[index][1] + 1);
        long exclude = dfs(questions, index + 1);
        long res = Math.max(include + questions[index][0], exclude);
        memo[index] = res;
        return res;
    }
}

class Solution {
    public long mostPoints(int[][] questions) { //from back to start
        long dp[] = new long[questions.length];
        dp[questions.length - 1] = questions[questions.length - 1][0];
        for(int i = questions.length - 2; i >= 0; i--){
            long ifInclude = questions[i][0];
            if(questions[i][1] + i + 1 < questions.length) ifInclude += dp[questions[i][1] + i + 1]; //add the back one if possible
            long ifExclude = dp[i + 1];
            dp[i] = Math.max(ifInclude, ifExclude);
        }
        return dp[0];
    }
}
