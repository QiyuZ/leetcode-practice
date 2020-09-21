class Solution {
    private int count = 0;
    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int sx = -1, sy = -1, empty = 1;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } 
            }
        }
        dfs(grid, sx, sy, empty);
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j, int empty) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < 0) return;
        if (grid[i][j] == 2) { //注意此时一定要return，即使empty不是0，否则line 31要变为之前的值而不是0（考虑2）
            if (empty == 0) count++;
            return;
        } 
        grid[i][j] = -1;
        dfs(grid, i - 1, j, empty - 1);
        dfs(grid, i + 1, j, empty - 1);
        dfs(grid, i, j + 1, empty - 1);
        dfs(grid, i, j - 1, empty - 1);
        grid[i][j] = 0; //直接变为0即可
    }
}





