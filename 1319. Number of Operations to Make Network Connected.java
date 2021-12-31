class Solution {
    public int makeConnected(int n, int[][] connections) { //same as the question to count island
        if (connections == null || n > connections.length + 1) return -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int[] c : connections) { // note that the connections may not contains all node, so we need ^^ to init, otherwise some may be missed
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int components = 0;
        for (int node : map.keySet()) {
            if (visited.contains(node)) continue;
            dfs(map, visited, node);
            components += 1;
        }
        return components - 1; // min 1 to exclude to "main" island
    }
    private void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int cur) {
        if (!map.containsKey(cur) || visited.contains(cur)) return;
        visited.add(cur);
        for (int next : map.get(cur)) dfs(map, visited, next);
    }
}
