class Solution {
    private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < m; i++) { //找到一个岛，置为2，于此同时加入queue中，方便后面找到另一个岛的最短路径
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                int[] cur = queue.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 2) continue;
                    if (A[x][y] == 1) return step;
                    queue.offer(new int[] {x, y});
                    A[x][y] = 2; //变为2在这里相当于加了visited，所以要加上节约时间
                }
            }
            step++;
        }
        return -1;
        
    }
    
    private void dfs (int[][] A, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 2 || A[i][j] != 1) return;
        A[i][j] = 2;
        queue.offer(new int[]{i, j});
        for (int[] d : dirs) dfs(A, i + d[0], j + d[1], queue);
    }
}



