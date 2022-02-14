class Solution {
    private int res = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        if (n <= 0 || m <= 0) return 0;
        if (m == 1 || n == 1) return m == 1 ? n : m;
        dfs(0, 0, new boolean[n][m], 0);
        return res;
    }
    private void dfs(int r, int c, boolean[][] rect, int count) { //fill row one by one
        int n = rect.length, m = rect[0].length;
        if (count >= res) return; //no need continue as current needs more
        if (r >= n) { //all rows have been filled
            res = count;
            return;
        }
        if (c >= m) { //this row has been filled, move to next
            dfs(r + 1, 0, rect, count); //note that c should start from 0
            return;
        }
        if (rect[r][c]) { //if this point has been covered, move to next col in this row
            dfs(r, c + 1, rect, count);
            return;
        }
        int maxSide = 0;
        while (maxSide < Math.min(n - r, m - c) && !rect[r][c + maxSide]) maxSide++; //note, check to see if the square could be formed, but we can only check col as row is filled one by one
        for (int i = maxSide; i >= 1; i--) {
            modifyRect(rect, r, c, i, true);
            dfs(r, c + i, rect, count + 1);
            modifyRect(rect, r, c, i, false);
        }
    }
    
    private void modifyRect(boolean[][] rect, int r, int c, int side, boolean cover) { //note that in line 24, the maxSide moved to an invalid case, so it's exclusive
        for (int i = r; i < r + side; i++) {
            for (int j = c; j < c + side; j++) rect[i][j] = cover;
        }
    }
}
