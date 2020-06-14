class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //cost优先
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
            if (!map.containsKey(f[0])) map.put(f[0], new HashMap<>());
            map.get(f[0]).put(f[1], f[2]);
        }
        queue.offer(new int[] {0, src, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int price = cur[0], city = cur[1], stop = cur[2];
            if (dst == city) return price;//因为cost优先,所以最先到达的一定是价格最优的
            if (stop > K || !map.containsKey(city)) continue;//不符合的跳过
            Map<Integer, Integer> next = map.get(city);
            for (int id : next.keySet()) {
                queue.offer(new int[] {price + next.get(id), id, stop + 1});
            }

        }
        return -1;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= K; i++){
            int[] tmp = Arrays.copyOf(cost, n);
            for (int[] a : flights){
                int cur = a[0], next = a[1], price = a[2];
                if (cost[cur] == Integer.MAX_VALUE) continue;
                tmp[next] = Math.min(tmp[next], cost[cur] + price);//相当于每次多更新所有的next，因为有min所以已经走过的不会变大
            }
            cost = tmp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
    
}
