class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] res = new int[R * C][2];
        int i = 0;
        Set<String> visited = new HashSet<>();
        visited.add(r0 + "/" + c0);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            res[i++] = cur;
            for (int[] d : dirs) {
                int x = d[0] + cur[0], y = d[1] + cur[1];
                if (x < 0 || x >= R || y < 0 || y >= C || visited.contains(x + "/" + y)) continue;
                queue.offer(new int[] {x, y});
                visited.add(x + "/" + y);
            }
        }
        return res;
    }
}


