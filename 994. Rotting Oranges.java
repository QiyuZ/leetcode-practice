class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int fresh = 0, m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[] {i, j});
                else if (grid[i][j] == 1) fresh++;//用fresh记录不用后面多重复检查一遍
            }
        }
        int time = 0;
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                        queue.offer(new int[] {x, y});
                        fresh--;
                        grid[x][y] = 2;//注意要在放入时变为2而不是poll时，否则如果两个相连则会重复放入
                }          
            }
            if (!queue.isEmpty()) time++;
        }
        return fresh == 0 ? time : -1; //可能有触及不到的
    }
}
