class Solution { 
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<String, Double> probsMap = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            probsMap.put(getKey(edge[0], edge[1]), succProb[i]);
        }
        double[] probs = new double[n];  // best prob so far for each node
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(start, 1.0));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int node = state.node;
            double prob = state.prob;
            if (!map.containsKey(node)) continue;
            for (int next : map.get(node)) {
                if (!probsMap.containsKey(getKey(node, next))) continue;
                double nextProb = prob * probsMap.get(getKey(node, next));
                if (probs[next] >= nextProb) continue;
                queue.add(new State(next, nextProb));
                probs[next] = nextProb;
            }
        }
        return probs[end];
    }
    
    private String getKey(int a, int b) {
        return a < b ? a + "-" + b : b + "-" + a;
    }
    
    class State {
        int node;
        double prob;
        State(int _node, double _prob) {
            node = _node;
            prob = _prob;
        }
    }
}
