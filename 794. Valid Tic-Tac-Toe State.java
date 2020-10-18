class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length == 0) return false;
        int n = board.length;
        int[] rows = new int[n], cols = new int[n]; //横竖两条对角线
        int diag = 0, antidiag = 0, count = 0; //另外X数量应该大于等于O数量
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                char cur = board[i].charAt(j);
                if (cur == 'X') {
                    rows[i]++;
                    cols[j]++;
                    count++;
                    if (i == j) diag++;
                    if (i + j == n - 1) antidiag++; //注意是n-1因为是0开始的
                } else if (cur == 'O') {
                    rows[i]--;
                    cols[j]--;
                    count--;
                    if (i == j) diag--;
                    if (i + j == n - 1) antidiag--;
                }
            }
        }
        if (count != 0 && count != 1) return false; //只能是0或者1，注意是与不是或否则一直成立
        boolean xwins = diag == n || antidiag == n ? true : false, owins = diag == -n || antidiag == -n ? true : false;
        for (int i = 0; i < n; i++) {
            if (rows[i] == n || cols[i] == n) xwins = true;
            if (rows[i] == -n || cols[i] == -n) owins = true;
        }
        if ((xwins && count != 1) || (owins && count != 0)) return false; //如果x win则个数多一个owin则相等，注意这里应该只判断不成立的因为有可能都没赢
        return true;
    }
}
