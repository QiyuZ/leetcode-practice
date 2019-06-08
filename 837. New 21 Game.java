class Solution {
    public double new21Game(int N, int K, int W) {
        if (N < K) return 0;
        if (K == 0 || N >= K + W) return 1;
        double[] dp = new double[N + 1];
        double wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = wsum / W; //dp[i] = dp[1] * 1/W + dp[2] * 1/W + dp[3] * 1/W + ... dp[i-2] * 1/W + dp[i-1] * 1/W, wsum就是dp[1]到dp[i - 1]之和
            if (i < K) wsum += dp[i]; //小于k就继续抽，更新wsum
            else res += dp[i]; //大于k就不用更新，但是要把结果加起来，因为虽然不再抽了但是是可以到达的，比如第一个例子中抽到大于1的
            if (i >= W) wsum -= dp[i - W]; //超过w就是下一次的了，窗口右移
        }
        return res;
    }
}
