class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Arrays.asList(0);
        for (int[] e : edges) {
            if (!map.containsKey(e[0])) map.put(e[0], new HashSet<>()); //undirected graph, add twice from different directions
            if (!map.containsKey(e[1])) map.put(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) leaves.add(i); //find the leaves
        }
        while (n > 2) {// at most 2 root, because if there's even number, 1-2-3 then 2 will be root, if there's odd number 1-2-3-4, then 2,3 will be root.
            //Because cycle is not allowed, so actually they can all be treated in a chain. And in the shortest chain (min heights), there could be only 2 roots
            List<Integer> newLeaves = new ArrayList<>();
            n -= leaves.size();
            for (int leave : leaves) {
                for (int parent : map.get(leave)) {
                    map.get(parent).remove(leave);
                    if (map.get(parent).size() == 1) newLeaves.add(parent); //find new leaves
                }
            }
            leaves = newLeaves;
        }
        return leaves; //the last "leaves" are roots
    }
}
