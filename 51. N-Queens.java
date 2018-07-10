class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];  //新建棋盘并且填充
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }
    
    public void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board[0].length) { //说明走到头，转化为list<String>形势加入
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, col)) { //满足条件变成Q
                board[i][col] = 'Q';
                dfs(board, col + 1, res); //注意这其实是按照col的顺序来的
                board[i][col] = '.'; //完成全部，要记得变回来
            }
        }
    }
    public boolean validate(char[][] board, int x, int y) {
        int i = 0, j = 0;
        for (i = 0; i < y; i++) {  //同一行不能用Q
            if (board[x][i] == 'Q') return false;
        }
        for (i = x, j = y; i >= 0 && j >= 0; i--, j--) { //左上对角线没有Q
            if (board[i][j] == 'Q') return false;
        }
        for (i = x, j = y; i < board.length && j >= 0; i++, j--) { //左下对角线没有Q
            if (board[i][j] == 'Q') return false;
        }
        return true;
        //不用检查col和右边的对角线是因为这是按照col从左到右来检查，右边还没有不会有Q
    }
    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
