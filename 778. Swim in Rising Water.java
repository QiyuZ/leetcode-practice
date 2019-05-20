class Solution {
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int N = grid.length;
        int[] start = {0,0, grid[0][0]}, end = {N - 1, N - 1, grid[N - 1][N - 1]};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        queue.offer(end);
        grid[end[0]][end[1]] = -1;
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], val = cur[2];
            if (val > res) res = val;
            if (i == 0 && j == 0) return res;
            spread(grid, i, j + 1, queue);
            spread(grid, i, j - 1, queue);
            spread(grid, i + 1, j, queue);
            spread(grid, i - 1, j, queue);
        }
        return res;
    }
    
    private void spread (int[][] grid, int i, int j, PriorityQueue<int[]> queue) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == -1) return;
        queue.offer(new int[] {i, j, grid[i][j]});
        grid[i][j] = -1;
    }
}
