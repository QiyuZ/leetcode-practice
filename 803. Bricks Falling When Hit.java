class Solution {
    private static final int TOP = 2;
    private static final int BRICK = 1; 
    private static final int EMPTY = 0;
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        for (int[] hit : hits) grid[hit[0]][hit[1]]--; //先都去掉，然后一个个往上面加，看有几个和其连接
        for (int i = 0; i < grid[0].length; i++) dfs(0, i, grid); //把和top的连成一体，因为他们肯定是不会掉的
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            grid[x][y]++;
            if (grid[x][y] == BRICK && isConnected(x, y, grid)) { //它本身得和top连接,不然有没有它都会掉
                res[i] = dfs(x, y, grid) - 1; //不算本身
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != BRICK) return 0;    
        grid[i][j] = TOP;
        return dfs(i + 1, j, grid) + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i, j - 1, grid) + 1;
    }
    
    private boolean isConnected(int i, int j, int[][] grid) {//因为之前把top都连在了一起所以不用向上找
        if (i == 0) {
            return true;
        }       
        for (int[] d : DIRS) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == TOP) {
                return true;
            }
        }               
        return false;
    }
}
