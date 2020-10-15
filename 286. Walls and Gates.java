class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void wallsAndGates(int[][] rooms) { //bfs被更新到的一定会最小，因为这是bfs的性质
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[] {i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE) continue;
                rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                queue.offer(new int[] {x, y});
            }
            
        }
    }
}
