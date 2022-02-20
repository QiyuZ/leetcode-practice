class Solution {
    public boolean validTree(int n, int[][] edges) { //union find
        if (n - 1 != edges.length) return false; //检查是否有没连的
        int[] parents = new int[n];
        Arrays.fill(parents, -1); //标记未被连接
        for (int[] edge : edges) {
            int child0 = find(edge[0], parents);
            int child1 = find(edge[1], parents);
            if (child0 == child1) return false; //如果相等说明edge[0]下面已经连过,则说明有cycle不成立
            parents[child0] = child1; 
        }
        return true;
    }
    public int find(int num, int[] parents) {
        if (parents[num] == -1) return num;
        return find(parents[num], parents);
    }
}


class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0); //not need to use indegree as it starts with 0;
        seen.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!graph.containsKey(node)) continue;
            for (int neighbour : graph.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }
        return seen.size() == n;   
    }
}
