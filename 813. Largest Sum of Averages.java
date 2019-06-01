class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] memo = new double[n + 1][n + 1]; //memo[i][j]表示前i个分成j group最大值
        double  cur = 0;
        for (int i = 0; i < n; i++) {
            cur += A[i];
            memo[i + 1][1] = cur / (i + 1); //只分成一组即为所有的average
            memo[i + 1][i + 1] = cur; //分成i+1组（因为从0开始），就是所有的和
        }
        return search(n, K, A, memo);
    }
    
    private double search(int n, int K, int[] A, double[][] memo) {
        if (memo[n][K] != 0) return memo[n][K];
        if (n < K) return 0; //不存在，其实也是分组越多越好，出现n<k说明分不了K组，一定不是最佳值
        double cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += A[i]; //n-i个分为一组
            memo[n][K] = Math.max(memo[n][K], search(i, K - 1, A, memo) + cur / (n - i));
        }
        return memo[n][K];
    }
}
