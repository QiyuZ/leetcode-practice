class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 2) return m + n - 2; //can break all potential bricks
        boolean[][][] visited = new boolean[m][n][k + 1];//add the state of bricks has been break when reach to [r][c]
        visited[0][0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], o = cur[2];
                if (r == m - 1 && c == n - 1) return res;
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    int no = o + grid[nr][nc];
                    if (no <= k && !visited[nr][nc][no]) { //need to smaller than k and make sure such state hasn't been reached before
                        queue.offer(new int[] {nr, nc, no});
                        visited[nr][nc][no] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
