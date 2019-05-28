class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, color, graph)) res.add(i);
        }
        return res;
    }
    
    private boolean dfs(int i, int[] color, int[][] graph) {
        if (color[i] > 0) return color[i] == 2;
        color[i] = 1;
        for (int next : graph[i]) {
            if (color[next] == 1 || !dfs(next, color, graph)) return false;
        }
        color[i] = 2;
        return true;
    }
}
/*
0 初始值，没有被visited
1 正在visiting, 如果遇到了color[i] == 1说明是个环，unsafe
2 已经被visited, 说明是safe的，如果遇到了说明本次i也是safe
*/
