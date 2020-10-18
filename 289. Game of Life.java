class Solution {
    public void gameOfLife(int[][] board) {

        // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // Create a copy of the original board
        int[][] copyBoard = new int[rows][cols];

        // Create a copy of the original board
        for (int row = 0; row < rows; row++) {
            copyBoard[row] = board[row].clone(); //注意2D的不能直接clone要一行行的写,否则会有索引
        }

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (neighbors[i] != 0 || neighbors[j] != 0) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            // The evaluation is done against the copy, since that is never updated.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                // Rule 1 or Rule 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3))  board[row][col] = 0;
                // Rule 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3)  board[row][col] = 1;

            }
        }
    }
}


public class Solution {
    public void gameOfLife(int[][] board) {
        int[] diri = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dirj = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int di = diri[k] + i; int dj = dirj[k] + j;
                    if (di < 0 || dj < 0 || di >= board.length || dj >= board[0].length ) continue;
                    else if (board[di][dj] == 1 || board[di][dj] == 2) live++;
                }
                if (live == 3 && board[i][j] == 0) board[i][j] = 3;
                if ((live > 3 || live < 2) && board[i][j] == 1) board[i][j] = 2;
                //case2 2-3之间的不用考虑因为状态不改变
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                board[i][j] %= 2;
            }
        }
    }
}
//难点在于要记住上一步是同时变的，并不是一个个来的，之前变得可能会影响，所以如果是2即之前是活的也算是活的
/* 0：死变死 
 1：活变活
 2：活变死
 3：死变活
最后取余即可*/
