class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) { //遍历A，每次的dp[i] = dp[i - k] + max * k,新加进去一个就要重新计算前面的
            int max = 0;
            for (int k = 1; k <= K && i + 1 - k >= 0; k++) { //注意要+1因为此处K是长度
                max = Math.max(max, A[i + 1 - k]);
                dp[i] = Math.max(dp[i], (i + 1 == k ? 0 : dp[i - k]) + max * k); // i+1==k 说明整体都要被这个max来替代
            }
        }
        return dp[n - 1];
    }
}
