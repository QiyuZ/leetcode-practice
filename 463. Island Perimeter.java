class Solution {
    private int count = 0;
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return count;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) dfs(grid, i, j);
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        int num = 0;
        if (i - 1 >= 0 && (grid[i - 1][j] == 1 || grid[i - 1][j] == -1)) num++;
        if (i + 1 < m && (grid[i + 1][j] == 1 || grid[i + 1][j] == -1)) num++;
        if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == -1)) num++;
        if (j + 1 < n && (grid[i][j + 1] == 1 || grid[i][j + 1] == -1)) num++;
        grid[i][j] = -1;
        count += (4 - num);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

public static int islandPerimeter(int[][] grid) { //easier one
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2; //避免重复，每次只看左和上
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
