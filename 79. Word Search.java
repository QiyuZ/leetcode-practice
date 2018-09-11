class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        if (dfs(board, word, index + 1, i + 1, j, visited) || dfs(board, word, index + 1, i - 1, j, visited) || 
               dfs(board, word, index + 1, i, j - 1, visited) || dfs(board, word, index + 1, i, j + 1, visited)) return true;
        visited[i][j] = false;//如果没有找到就还原
        return false;
    }
}
