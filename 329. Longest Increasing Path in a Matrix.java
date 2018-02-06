class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] record = new int[m][n]; //这个用来dp节约时间
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, record);
                max = Math.max(len, max);
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] record) {
        if (record[i][j] != 0) return record[i][j];//如果之前处理过就直接返回
        int max = 1;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, record);
            max = Math.max(max, len);
        }
        record[i][j] = max;
        return max;
    }
}
