class Solution {
    private static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, house = 0;
        int[][] reach = new int[m][n], dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    house++;
                    bfs(grid, reach, dis, i, j);
                }
            }
        }
        int min = Integer.MAX_VALUE; // the max case could be complex that more than m * n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == house) min = Math.min(min, dis[i][j]); //all houses can reach with min distance
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(int[][] grid, int[][] reach, int[][] dis, int i, int j) {
        int m = grid.length, n = grid[0].length, level = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dirs[k][0];
                    int ny = cur[1] + dirs[k][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        reach[nx][ny]++;
                        dis[nx][ny] += level;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
            level++;
        }
    }
}

/* 每次从1（building）出发，计算到每个0的距离（dis[][]计算距离）并+1表示这个1可以到达这个0（reach[][]来计数），这样全部走一遍下来后，0的计数等于building总数则说明这个0可以作为中心点
然后再比较谁的距离短 */
