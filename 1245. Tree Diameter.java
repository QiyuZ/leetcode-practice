class Solution {
    private int res = 0;
    public int treeDiameter(int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        treeTraversal(map, 0, -1); //-1 as no parent
        return this.res;
    }
    private int treeTraversal(Map<Integer, List<Integer>> map, int cur, int parent) {//kind like from bottom to top, so just need to do traversal once
        if (!map.containsKey(cur)) return 0;
        int max1 = 0, max2 = 0;
        for (int next : map.get(cur)) {
            if (next == parent) continue; //avoid visit the previous node
            int nodeLen = treeTraversal(map, next, cur);
            if (nodeLen > max1) {
                max2 = max1;
                max1 = nodeLen;
            } else if (nodeLen > max2) max2 = nodeLen;
        }
        this.res = Math.max(res, max1 + max2);
        return max1 + 1;
    }
}
