class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] grid = new int[n][n];
        buildGraph(grid, red_edges, blue_edges);
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true; visited[0][1] =true; //这里也可以不加，后面grid直接从1开始即可
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 1}); //此处初始0,1  0，-1的原因是0开始的node颜色无所谓，所以考虑两个待选颜色
        queue.offer(new int[] {0, -1});
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        int len = 0;
        while (!queue.isEmpty()) { //poll完即每个有路径的都走完了不用for n 一个个找
            int size = queue.size();
            len++;
            for (int count = 0; count < size; count++) {
                int[] cur = queue.poll();
                int node = cur[0], nextColor = -1 * cur[1];
                for (int i = 0; i < n; i++) {
                    if (grid[node][i] == nextColor || grid[node][i] == 3) {
                        if (visited[i][nextColor == -1 ? 0 : nextColor]) continue;
                        visited[i][nextColor == -1 ? 0 : nextColor] = true;
                        queue.offer(new int[] {i, nextColor});
                        res[i] = Math.min(res[i], len);
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;

    }
    
    private void buildGraph(int[][] g, int[][] red_edges, int[][] blue_edges) {
        int n = g.length;
        for (int[] e : red_edges) {
            int from = e[0];
            int to = e[1];
            g[from][to] = 1;
        }
        for (int[] e : blue_edges) {
            int from = e[0];
            int to = e[1];
            if (g[from][to] == 1) { //此处注意，可以一个边包含两个颜色，记为3
                g[from][to] = 3;
            } else {
                g[from][to] = -1;
            }
        }
    }
}

1129. Shortest Path with Alternating Colors
