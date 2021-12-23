class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (hasApple == null || hasApple.isEmpty() || n == 0 || edges == null || edges.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return findApples(map, new HashSet<>(), hasApple, 0);
    }
    
    private int findApples(Map<Integer, List<Integer>> map, Set<Integer> visited, List<Boolean> hasApple, int node) {
        visited.add(node);
        int res = 0;
        for (int next : map.getOrDefault(node, new ArrayList<>())) {
            if (visited.contains(next)) continue;
            res += findApples(map, visited, hasApple, next);
        }
        if ((res > 0 || hasApple.get(node)) && node != 0) res += 2; 
        //res>0 means there's apple in child node, so we need come and back; note we have to see if node is the start point
        visited.remove(node);
        return res;
    }
}
