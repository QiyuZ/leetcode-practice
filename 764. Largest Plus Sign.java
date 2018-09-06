class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(grid[i], N); //填充N，假设没有0的最大情况
        for (int[] m : mines) grid[m[0]][m[1]] = 0;
        for (int i = 0; i < N; i++) {
            int l = 0, r = 0, u = 0, d = 0;
                for (int j = 0, k = N - 1; j < N && k >= 0; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction 
                //举例说明，从左边来，此处注意是要最小值，因为要保证两边一样长，而l遇到0就要重新计算
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) res = Math.max(res, grid[i][j]);
        }
        return res;
    }
}
