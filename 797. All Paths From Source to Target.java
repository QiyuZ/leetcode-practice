class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        dfs(graph, res , cur, 0);
        return res;
    }
    public void dfs(int[][] graph, List<List<Integer>> res, List<Integer> cur, int pos) {
        cur.add(pos);
        if (pos == graph.length - 1) { //注意不能写成pos == graph.length， cur.add(pos) 在下面，因为这个是找index每次不是+1
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i : graph[pos]) { 
            dfs(graph, res , cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}
