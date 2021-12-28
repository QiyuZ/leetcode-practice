class Solution {
    private static final int n = 3; //reusable, if the interviewer just wanna change the size
    public String tictactoe(int[][] moves) {
        int[] col = new int[n], row = new int[n];
        int diag = 0, antiDiag = 0, player = 1;
        for(int[] move : moves) {
            int x = move[0], y = move[1];
            row[x] += player; //note that all of these 4 need to add player not 1
            col[y] += player;
            if (x == y) diag += player;
            if (x + y == n - 1) antiDiag += player;
            if (Math.abs(row[x]) == n || Math.abs(col[y]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
                return player == 1 ? "A" : "B";
            }
            player *= -1; //swtich to another player
        }
        return moves.length == n * n ? "Draw" : "Pending"; //need to check if the board is full
    }
}
