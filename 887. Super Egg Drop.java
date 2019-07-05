class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1]; //能检查几层 dp[i][j] with i steps and j eggs 
        int m = 0;
        while (dp[m][K] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1; //之所以加是因为碎了下楼，没事上楼
            }
        }
        return m;
    }
}
