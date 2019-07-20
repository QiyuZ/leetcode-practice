class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (visited[cur]) continue;
                if (cur == n * n) return move;
                visited[cur] = true;
                for (int j = 1; j <= 6 && cur + j <= n * n; j++) { //注意此处不能越界
                    int next = cur + j;
                    int val = getBoardVal(board, next); //找到了编号，要找真实的坐标
                    if (val != -1) next = val; //跳梯子
                    if (!visited[next]) queue.offer(next);
                }
            }
            move++;
        }
        return -1;
    }
    
    private int getBoardVal(int[][] board, int val) {
        int n = board.length;
        int oldRow = (val - 1) / n;
        int x = n - 1 - oldRow; //因为r是从下向上数的
        int oldCol = (val - 1) % n;
        int y = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol; //偶数行（下向上）是正常方向，奇数的是反方向
        return board[x][y];
    }
}
