class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0])) map.put(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[] {time[1], time[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});
        int[] dis = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        queue.offer(new int[] {K, 0});
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            N--;
            int curDis = cur[1];
            res = curDis;
            if (!map.containsKey(cur[0])) continue;
            for (int[] next : map.get(cur[0])) {
                if (!visited[next[0]] && next[1] + curDis < dis[next[0]]) queue.offer(new int[] {next[0], curDis + next[1]});
            }
        }
        return N == 0 ? res : -1;
    }
}


//Time complexity: O(Nlog(N) + E), Space complexity: O(N + E)
