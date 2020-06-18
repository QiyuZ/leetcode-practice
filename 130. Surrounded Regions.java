class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < n; i++) {                 //不必每个都找，因为只要连接边缘的就不会变，所以从四个边dfs
            if (board[0][i] == 'O') dfs(board, 0, i); //找出连接边缘的，全替换成A，这些就是不会被替换的，再遍历没有连接边缘的变X
        }
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

class Solution { //find all 'O' and use a flag to determine whether replace or not and use list to maintain location
    private boolean replace = true;
    private List<int[]> replacedList = new ArrayList<>();
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j, new boolean[board.length][board[0].length]);
                    if (replace) {
                        for (int[] xy : replacedList) board[xy[0]][xy[1]] = 'X';
                    }
                    replace = true;
                    replacedList = new ArrayList<>();
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i == m || j < 0 || j >= n || board[i][j] !='O' || visited[i][j]) return;
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) this.replace = false;
        replacedList.add(new int[]{i, j});
        visited[i][j] = true;
        dfs(board, i - 1, j, visited);
        dfs(board, i + 1, j, visited);
        dfs(board, i, j - 1, visited);
        dfs(board, i, j + 1, visited);
    }
}
