class Solution {
    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int[][] g = new int[m * 3][m * 3]; //扩大三倍，太小分不开
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3 ] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < g.length; i++) { //数岛
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) {
                    res++;
                    dfs(g, i, j);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] g, int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 1) return;
        g[i][j] = 1;
        dfs(g, i - 1, j);
        dfs(g, i + 1, j);
        dfs(g, i, j - 1);
        dfs(g, i, j + 1);
    }
}
