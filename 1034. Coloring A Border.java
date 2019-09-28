class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int target = grid[r0][c0];
        int m = grid.length, n = grid[0].length;
        queue.offer(new int[] {r0, c0});
        visited.add(r0 + "-" + c0);
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dirs) {
                if (cur[0] == 0 || cur[0] == m - 1 || cur[1] == 0 || cur[1] == n - 1) grid[cur[0]][cur[1]] = color; //如果在边界直接变color
                int x = d[0] + cur[0], y = d[1] + cur[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x + "-" + y)) continue;
                if (grid[x][y] == target) { //如果还是这个component的就继续
                    queue.offer(new int[] {x, y});
                    visited.add(x + "-" + y);
                } else grid[cur[0]][cur[1]] = color; //如果不是说明已经到头了
            }
        }
        return grid;
    }
}
