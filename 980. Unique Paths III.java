class Solution {
    private int res = 0, empty = 1, sx, sy, ex, ey;
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < 0) return; //-1路障，-2是走过了都不可以
        if (i == ex && j == ey) { //只要走到end了不管什么情况都要return
            if (empty == 0) res++;
            return;
            
        } 
        int cur = grid[i][j];
        grid[i][j] = -2; //用-2 标记已经走过了
        empty--;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
         grid[i][j] = cur; //别忘记变回来
        empty++;
    }
}
