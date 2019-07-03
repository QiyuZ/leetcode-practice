class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i, new HashMap<>());
        for (int[] e : edges) {
            graph.get(e[0]).put(e[1], e[2]);
            graph.get(e[1]).put(e[0], e[2]);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] - a[0])); //剩余moves多的先走，因为后面要储存
        queue.offer(new int[] {M, 0}); //moves left, node index
        Map<Integer, Integer> nodes = new HashMap<>();
        while (!queue.isEmpty()) {
            int moves = queue.peek()[0], index = queue.peek()[1];
            queue.poll();
            if (!nodes.containsKey(index)) {
                nodes.put(index, moves); //在哪，还可以走多少步，即可访问多少个node
                for (int i : graph.get(index).keySet()) {
                    int remain = moves - graph.get(index).get(i) - 1; //可走的减去本边的个人减去原始的node就是走完这个边剩余的
                    if (!nodes.containsKey(i) && remain >= 0) queue.offer(new int[] {remain, i});
                }
            }
        }
        int res = nodes.keySet().size();
        for (int[] e : edges) {
            int a = nodes.getOrDefault(e[0], 0);
            int b = nodes.getOrDefault(e[1], 0);
            res += Math.min(e[2], a + b); //可能有重合
        }
        return res;
    }
}
