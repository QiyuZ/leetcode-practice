class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        List<Integer> leaves = new ArrayList<>();
        if (n == 0) return leaves;
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        for (int[] edge : edges) { //构建图
            if (!nodes.containsKey(edge[0])) nodes.put(edge[0], new HashSet<>());
            nodes.get(edge[0]).add(edge[1]);
            if (!nodes.containsKey(edge[1])) nodes.put(edge[1], new HashSet<>());
            nodes.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) { //找出入度为1的，即为叶子
            if (nodes.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {//根最多只能有两个，可画图证明
            List<Integer> newLeaves = new ArrayList<>();
            n -= leaves.size(); //删去叶子
            for (int leave : leaves) {
                for (int parent : nodes.get(leave)) {
                    nodes.get(parent).remove(leave);
                    if (nodes.get(parent).size() == 1) newLeaves.add(parent); //加入新叶子
                }
                
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
