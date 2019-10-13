class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1; //注意起点和终点不可以是1
        queue.offer(new int[] {0, 0});
        visited.add(0 + "-" + 0);
        int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                int[] cur = queue.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) return path;
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x >= grid.length || x < 0 || y < 0 || y >= grid[0].length || visited.contains(x + "-" + y) || grid[x][y] == 1) continue;
                    queue.offer(new int[] {x, y});
                    visited.add(x + "-" + y);
                }
            }
            path++;
        }
        return -1;
    }
}

