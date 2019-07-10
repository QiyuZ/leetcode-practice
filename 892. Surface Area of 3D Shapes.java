class Solution {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) area += 4 * grid[i][j] + 2; //单独一条的是这个公式
                if (i > 0) area -= Math.min(grid[i - 1][j], grid[i][j]) * 2; //每个相邻的小的那个会被重合，减去两个的
                if (j > 0) area -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
            }
        }
        return area;
    }
}
