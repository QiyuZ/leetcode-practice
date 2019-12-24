class Solution {
    public int maximumMinimumPath(int[][] A) {
        if (A == null || A.length == 0) return 0;
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[2] - a[2])); //x,y,min, 因为每次要找路径最小值的最大可去项，所以大的在前面
        queue.offer(new int[] {0, 0, A[0][0]});
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) return cur[2];
            visited[cur[0]][cur[1]] = true;
            for (int[] d : dirs) {
                int x = d[0] + cur[0], y = d[1] + cur[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                queue.offer(new int[] {x, y, Math.min(cur[2], A[x][y])}); //保持更新路径中的最小值
            }
        }
        return -1;
    }
}
