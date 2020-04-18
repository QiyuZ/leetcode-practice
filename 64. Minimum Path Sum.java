class Solution { //dp
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

// dfs timeout
// class Solution {
//     private int res = Integer.MAX_VALUE;
//     public int minPathSum(int[][] grid) {
//         if (grid == null || grid.length == 0) return 0;
//         dfs(0, 0, grid, new boolean[grid.length][grid[0].length], 0);
//         return res;
//     }
//     private void dfs(int i, int j, int[][] grid, boolean[][] visited, int sum) {
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) return;
//         if (i == grid.length - 1 && j == grid[0].length - 1) {
//             res = Math.min(res, sum + grid[i][j]);
//             return;
//         }
//         visited[i][j] = true;
//         dfs(i + 1, j, grid, visited, sum + grid[i][j]);
//         dfs(i - 1, j, grid, visited, sum + grid[i][j]);
//         dfs(i, j - 1, grid, visited, sum + grid[i][j]);
//         dfs(i, j + 1, grid, visited, sum + grid[i][j]);
//         visited[i][j] = false;
//     }
// }
