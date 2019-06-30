class Solution {
    public int projectionArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                x = Math.max(x, grid[j][i]); //x找最大的
                y = Math.max(y, grid[i][j]); //y找最大的
                if (grid[i][j] > 0) res += 1; //投影底部的必须加
            }
            res += x + y;
        }
        return res;
    }
}
