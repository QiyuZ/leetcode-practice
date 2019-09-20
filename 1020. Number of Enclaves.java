class Solution {
    public int numEnclaves(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 1) dfs(A, i, 0);
            if (A[i][n - 1] == 1) dfs(A, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (A[0][j] == 1) dfs(A, 0, j);
            if (A[m - 1][j] == 1) dfs(A, m - 1, j);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) res++;
            }
        }
        return res;
    }
    
    private void dfs(int[][] A, int i, int j) {
        int m = A.length, n = A[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || A[i][j] == 0) return;
        A[i][j] = 0;
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
    }
}


