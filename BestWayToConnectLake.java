/*
0010
0100
0100

0 means water, 1 means land, there are 2 lakes, how many best ways to connect them together?
*/

import java.util.LinkedList;
import java.util.Queue;


public class water {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int getNum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        boolean found = false;
        int count = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    markLake(grid, i, j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    if (!isSide(grid, i, j)) continue;
                    int cur = bfs(grid, i, j, min);
                    if (cur == min) count++;
                    else if (cur < min) {
                        min = cur;
                        count = 1;
                    }
                }
            }
        }
        return count;
    }
    public void markLake(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) return;
        grid[i][j] = 2;
        markLake(grid, i + 1, j);
        markLake(grid, i, j + 1);
        markLake(grid, i - 1, j);
        markLake(grid, i, j - 1);
    }

    public boolean isSide(int[][] grid, int i, int j) {
        if (i > 0 && grid[i - 1][j] == 1) return true;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) return true;
        if (j > 0 && grid[i][j - 1] == 1) return true;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) return true;
        return false;
    }

    public int bfs (int[][] grid, int i, int j, int min) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {i, j});
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            if (len > min) return Integer.MAX_VALUE;
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 2) continue;
                    if (grid[newX][newY] == 0) return len;
                    else if (grid[newX][newY] == 1) queue.offer(new int[] {newX, newY});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        water test = new water();
        int[][] grid = {{1, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}};
        System.out.println(test.getNum(grid));
    }
}
