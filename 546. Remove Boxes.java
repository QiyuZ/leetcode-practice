class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];
        return dfs(dp, boxes, 0, len - 1, 1);
    }
    
    private int dfs(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (i > j) return 0;
        if (i == j) return k * k;
        if (dp[i][j][k] != 0) return dp[i][j][k];
        int cur = dfs(dp, boxes, i + 1, j, 1) + k * k; //choose to merge k boxes
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                cur = Math.max(cur, dfs(dp, boxes, i + 1, m - 1, 1) + dfs(dp, boxes, m, j, k + 1));
                /*
                the first term is the other boxes
                and the second term contain information of the same boxes(box[i] or box[m]) we have found till now
                */
            }
        }
        dp[i][j][k] = cur;
        return cur;
    }
}
