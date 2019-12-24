// class Solution {
//     public int minimumCost(int N, int[][] connections) {
//         if (N < 2) return 0;
//         if (connections == null || connections.length == 0) return -1;
//         Map<Integer, List<int[]>> graph = new HashMap<>();
//         for (int[] connection : connections) {
//             int city1 = connection[0], city2 = connection[1], cost = connection[2];
//             if (!graph.containsKey(city1)) graph.put(city1, new ArrayList<>());
//             if (!graph.containsKey(city2)) graph.put(city2, new ArrayList<>());
//             graph.get(city1).add(new int[] {city2, cost});
//             graph.get(city2).add(new int[] {city1, cost});
//         }
//         PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
//         queue.offer(new int[] {1, 1, 0}); //初始化
//         Set<Integer> visited = new HashSet<>();
//         int cost = 0;
//         while (!queue.isEmpty()) {
//             int[] cur = queue.poll();
//             if (!graph.containsKey(cur[1]) || !visited.add(cur[1])) continue;
//             cost += cur[2];
//             for (int[] next : graph.get(cur[1])) {
//                 queue.offer(new int[] {cur[1], next[0], next[1]});
//             }
//         }
//         return visited.size() == N ? cost : -1;
//     }
// }


class Solution {
    int[] parent;
    int n;
    public int minimumCost(int N, int[][] connections) {
        this.parent = new int[N + 1];
        this.n = N;
        for (int i = 0; i <= N; i++) parent[i] = i;
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for (int[] c : connections) {
            if (n == 1) break;
            int px = find(c[0]), py = find(c[1]);
            if (px != py) {
                res += c[2];
                parent[px] = py;
                n--;
            }
        }
        return n == 1 ? res : -1;
    }
    private int find(int x) {
        if (parent[x] == x) return parent[x];
        return find(parent[x]);
    }
}
