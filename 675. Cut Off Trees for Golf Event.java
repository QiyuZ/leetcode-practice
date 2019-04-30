class Solution {
    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) pq.offer(new int[] {i, j, forest.get(i).get(j)});
            }
        }
        //因为要从小往大走而且没有重复，所以每次目标已经确定，多次bfs下一次的目标，并且更新每次的起点
        int[] start = new int[2];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll(); //target
            int step = minStep(forest, tree, start, m, n);
            if (step < 0) return -1; //有一个走不了就全部走不了
            sum += step;
            start[0] = tree[0]; //upfate start
            start[1] = tree[1];
        }
        return sum;
    }
    
    private int minStep (List<List<Integer>> forest, int[] tree, int[] start, int m , int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;
                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n 
                        || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue; //注意0不能走，1可以
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
