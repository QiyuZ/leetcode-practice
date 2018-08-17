class TicTacToe {
    
    private int[] rows; //四个分别检查每一类是否胜出
    private int[] cols;
    private int dig, antidig; //注意只考察对角反对角，一般的斜线不算，因为要达到n,只有（反）对角才可以做到
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1; //定义一加一减，绝对值先到的胜出
        rows[row] += add;
        cols[col] += add;
        if (row == col) dig += add;
        if (col + row == cols.length - 1) antidig +=add;
        int n = cols.length;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(dig) == n || Math.abs(antidig) == n ) return player;
        //不用看具体是正是负，最后一步走的胜出
        return 0; //继续走的return 0
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
