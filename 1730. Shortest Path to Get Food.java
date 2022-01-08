class Solution {
    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[] {i, j});
                    break;
                }
            }
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == '#') return steps;
                if (grid[cur[0]][cur[1]] == 'X') continue; //note!! this is needed as the value may be added by the adjacent element
                grid[cur[0]][cur[1]] = 'X';
                for (int[] dir : dirs) {
                    int newX = cur[0] + dir[0], newY = cur[1] + dir[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] != 'X') {
                        queue.offer(new int[] {newX, newY});
                    } 
                }
            }
            steps++;
        }
        return -1;
    }
}
