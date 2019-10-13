class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                int[] cur = queue.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) return path;
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x >= grid.length || x < 0 || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 1) continue;
                    queue.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
            path++;
        }
        return -1;
    }
}
