class Solution {
    public int numRookCaptures(char[][] board) {
        int x = -1, y = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i; y = j;
                    break;
                }
            }
        }
        int res = 0;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            for (int i = x + d[0], j = y + d[1]; i >= 0 && i < 8 && j >= 0 && j < 8; i += d[0], j += d[1]) {
                if (board[i][j] == 'p') {
                    res++;
                    break;
                }
                if (board[i][j] != '.') break;
            }
        }
        return res;
    }
}
