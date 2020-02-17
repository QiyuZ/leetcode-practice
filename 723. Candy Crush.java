class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0) return board;
        int m = board.length, n = board[0].length;
        boolean shouldContinue = false;
        // Crush horizontally
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) && Math.abs(board[i][j]) == Math.abs(board[i][j + 2])) { //attention to ingnore 0
                    shouldContinue = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -Math.abs(board[i][j]); //mark to negative which is going to be dropped
                }
            }
        }   
        // Crush vertically
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - 2; i++) {
                if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) && Math.abs(board[i + 2][j]) == Math.abs(board[i][j])) {
                    shouldContinue = true;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -Math.abs(board[i][j]);
                }
            }
        }
        //drop
        for (int j = 0; j < n; j++) { //从下到上，非0的照常，是0的填充上面的，上面空余的填0
            int r = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] > 0) board[r--][j] = board[i][j];
            }
            while (r >= 0) board[r--][j] = 0;
        }
        return shouldContinue ? candyCrush(board) : board;
    }
}
