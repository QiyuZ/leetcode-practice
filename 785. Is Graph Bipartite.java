class Solution { //DFS  填色法， 相邻不能相同
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0 && !validate(color, graph, 1, i)) return false;
        }
        return true;
    }
    public boolean validate(int[] color, int[][] graph, int num, int pos) {
        if (color[pos] != 0) return color[pos] == num;
        color[pos] = num;
        for (int i : graph[pos]) {
            if (!validate(color, graph, -1 * num, i)) return false;
        }
        return true;
    }
}

class Solution { //BFS
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;
            color[i] = 1;
            queue.offer(i);
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j : graph[cur]) {
                    if (color[j] == color[cur]) return false;
                    if (color[j] != 0) continue;
                    color[j] = -1 * color[cur];
                    queue.offer(j);
                }
            }
        }
        return true;
    }
}
