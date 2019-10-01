class Solution {
    public int minScoreTriangulation(int[] A) {
        return dfs(0, A.length - 1, new int[A.length][A.length], A);
    }
    
    private int dfs(int i, int j, int[][] memo, int[] A) {
        if (i + 2 > j) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k , memo, A) + dfs(k, j, memo, A) + A[i] * A[j] * A[k]);
        }
        memo[i][j] = res;
        return res;
    }
}
