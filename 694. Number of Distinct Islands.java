class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    public void dfs(int[][] grid, int x, int y, int i, int j, StringBuilder sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        sb.append(i - x).append(j - y); //使用相对坐标
        grid[i][j] = 0;
        dfs(grid, x, y, i - 1, j, sb);
        dfs(grid, x, y, i + 1, j, sb);
        dfs(grid, x, y, i, j - 1, sb);
        dfs(grid, x, y, i, j + 1, sb);
    }
}
