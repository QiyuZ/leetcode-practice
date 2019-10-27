class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] hor = new int[m + 1][n + 1], ver = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                hor[i][j] = grid[i - 1][j - 1] == 0 ? 0 : 1 + hor[i][j - 1]; //同一行i不动，j变化
                ver[i][j] = grid[i - 1][j - 1] == 0 ? 0 : 1 + ver[i - 1][j]; //同一列同理
            }
        }
        int res = 0;
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                int dist = Math.min(hor[i][j], ver[i][j]); //从大的开始mn,取可能的值也就是最小的
                for (; dist >= 1; dist--) {
                    if (hor[i - dist + 1][j] >= dist && ver[i][j - dist + 1] >= dist) { //如果上面一行和左边一列也满足条件则可以组成正方形
                        res = Math.max(res, dist * dist);
                        break; //可以直接break因为是从大的开始
                    }
                }
            }
        }
        return res;
    }
}
