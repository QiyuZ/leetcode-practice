class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int step = 0;
        queue.offer(entrance);
        //mark as visited before push into the queue instead of poll, otherwise there will be duplicated, same for line 19
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                if (step != 0 && (x == 0 || y == 0 || x == m - 1 || y == n - 1)) return step;
                for (int[] dir : dirs) {
                    int newx = x + dir[0], newy = y + dir[1];
                    if (newx >=0 && newx < m && newy >= 0 && newy < n && maze[newx][newy] == '.') {
                        maze[newx][newy] = '+';
                        queue.offer(new int[] {newx, newy});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
