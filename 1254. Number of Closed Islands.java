class Solution {
    public int closedIsland(int[][] grid) { //which simply means that 0 and its connected component cant be in the sides, so mark them as water first
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            fillWater(grid, 0, j);
            fillWater(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            fillWater(grid, i, 0);
            fillWater(grid, i, n - 1);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    fillWater(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void fillWater(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 0) return;
        grid[i][j] = 1;
        fillWater(grid, i + 1, j);
        fillWater(grid, i - 1, j);
        fillWater(grid, i, j + 1);
        fillWater(grid, i, j - 1);
    }
}
