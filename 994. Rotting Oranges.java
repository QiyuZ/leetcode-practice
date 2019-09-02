class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++; 
                else if (grid[i][j] == 2) queue.offer(new int[] {i, j});
            }
        }
        if (fresh == 0) return 0;
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int res = 0;
        while (!queue.isEmpty()) { 
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                int[] cur = queue.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
                    queue.offer(new int[] {x, y});
                    fresh--;
                    grid[x][y] = 2;
                }
            }
            res++;
        }
        return fresh == 0 ? res - 1 : -1;//bfs一遍看是否可以替换所有的fresh,如果不能就是-1， res-1是因为最后一遍poll出的都是rotten的没有状态转换
    }
}
