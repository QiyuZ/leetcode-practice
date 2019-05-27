class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] res = new double[query_row + 1][query_row + 1];
        res[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double remain = Math.max(res[i][j] - 1.0, 0); //每次上面有剩余的就往下平均分成两份
                if (remain == 0) continue;
                res[i + 1][j] += remain / 2;
                res[i + 1][j + 1] += remain / 2;
            }
        }
        return Math.min(res[query_row][query_glass], 1.0);
    }
}
