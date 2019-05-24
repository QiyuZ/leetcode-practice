class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]));
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
            if (!map.containsKey(f[0])) map.put(f[0], new HashMap<>());
            map.get(f[0]).put(f[1], f[2]);
        }
        queue.offer(new int[] {0, src, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int price = cur[0], city = cur[1], stop = cur[2];
            if (dst == city) return price;
            if (stop <= K) {
                Map<Integer, Integer> next = map.getOrDefault(city, new HashMap<>());
                for (int id : next.keySet()) {
                    queue.offer(new int[] {price + next.get(id), id, stop + 1});
                }
                
            }
        }
        return -1;
    }
}
