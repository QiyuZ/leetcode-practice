class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 9) return false;
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], cubes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int cube = (i / 3) * 3 + j / 3; //5, 6
                if (rows[i][num] || cols[j][num] || cubes[cube][num]) return false;
                rows[i][num] = true;
                cols[j][num] = true;
                cubes[cube][num] = true;
            }
        }
        return true;
    }
}
