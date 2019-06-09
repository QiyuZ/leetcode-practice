class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
        int res = 0;
        for(int i = 0; i <= grid.length - 3; i++) {
            for(int j = 0; j <= grid[0].length - 3; j++) {
                if(helper(i, j, grid)) res++;
            }
        }
        return res;
    }
    
    private boolean helper(int x, int y, int[][] grid) {
        if (grid[x + 1][y + 1] != 5) return false; //等差数列可求每个和为15，中间必为5
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (grid[i][j] <= 0 || grid[i][j] > 9) return false;
                set.add(grid[i][j]);
            }
        }
        if (set.size() != 9) return false;
        int dig = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        int antidig = grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y +2 ];
        if (dig != antidig) return false;
        for (int k = 0; k < 3; k++){
            int row = grid[x + k][y] + grid[x + k][y + 1] + grid[x + k][y + 2];
            int col = grid[x][y + k] + grid[x + 1][y + k] + grid[x + 2][y + k];
            if (row != dig || col != dig) return false;
        }
        return true;
    }
}
