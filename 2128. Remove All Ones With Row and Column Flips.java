class Solution {
     // time = O(m * n), space = O(1)
    public boolean removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) flip(grid, i, true);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) flip(grid, j, false);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return false;
            }
        }
        return true;
    }
    private void flip(int[][] grid, int x, boolean isRow) {
        int m = grid.length, n = grid[0].length;
        if (isRow) {
            for (int j = 0; j < n; j++) grid[x][j] = 1 - grid[x][j];
        } else {
            for (int i = 0; i < m; i++) grid[i][x] = 1 - grid[i][x];
        }
    }
}
