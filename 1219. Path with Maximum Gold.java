class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                maxGold = Math.max(maxGold, findMaxGold(grid, r, c));

        return maxGold;
    }
    private int findMaxGold(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
        int origin = grid[r][c];
        grid[r][c] = 0; // mark as visited
        int maxGold = 0;
        for (int i = 0; i < 4; i++) {
            maxGold = Math.max(maxGold, findMaxGold(grid, directions[i][0] + r, directions[i][1] + c));
        }
        grid[r][c] = origin; // backtrack
        return maxGold + origin;
    }
}
