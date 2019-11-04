class Solution {
    private int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (List<Integer> con : connections) {
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timestamp = new int[n];
        dfs(graph, -1, 0, visited, timestamp, res);
        return res;
    }
    
    private void dfs(List<Integer>[] graph, int parent, int node, boolean[] visited, int[] times, List<List<Integer>> res) {
        visited[node] = true;
        times[node] = time++;
        int curTime = times[node];
        for (int next : graph[node]) {
            if (next == parent) continue;
            if (!visited[next]) dfs(graph, node, next, visited, times, res);
            times[node] = Math.min(times[node], times[next]);
            if (curTime < times[next]) res.add(Arrays.asList(node, next));
        }
    }
}
