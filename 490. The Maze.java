public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue <int[]> queue = new LinkedList <>();
        queue.add(start);
        boolean[][] visited = new boolean[m][n]; //这里不能标记maze -1因为之后有的只是路过不是最终位置,会导致停在中间
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for (int[] dir: dirs) {
                int x = cur[0], y = cur[1];
                while (x + dir[0] >=0 && x + dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n 
                       && maze[x + dir[0]][y + dir[1]] == 0) { //下一个只有是0的才可以走
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x][y]) {
                    queue.add(new int[] {x, y });
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
