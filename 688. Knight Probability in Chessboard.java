class Solution {
    private int[][] moves = new int[][] {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], 1); //初始化每个为1
        for (int num = 0; num < K; num++) {
            double cur[][] = new double[N][N]; //更新下一步
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++){
                    for (int[] move : moves) {
                        int newX = i + move[0];
                        int newY = j + move[1];
                        if (newX >= 0 && newX < N && newY >= 0 && newY < N) cur[i][j] += dp[newX][newY];
                        //满足条件则可以累加，                                当前位置可行解+=之前的边界
                    }
                }
            }
            dp = cur; //更新
        }
        return dp[r][c] / Math.pow(8, K);
    }
}
//相当于从边界开始计算有多少路不会出去，一直叠加
