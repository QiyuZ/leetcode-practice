class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        int mod = 1000000007;
        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (N - (j - 1))) % mod;//听一首新歌的，歌是新的所以之前是j-1
                if (j > K) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - K)) % mod) % mod; //听老歌的因为包含里面所以还是j, 至少隔k个所以有j-k个选项
                }
            }
        }
        return (int)dp[L][N];
    }
}
