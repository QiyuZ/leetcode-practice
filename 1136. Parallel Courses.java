class Solution {//same as course schedule
    public int minimumSemesters(int n, int[][] relations) {
        if (n <= 0 || relations == null || relations.length == 0) return -1;
        int[] indegrees = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] r : relations) {
            indegrees[r[1]]++;
            if (!map.containsKey(r[0])) map.put(r[0], new ArrayList<>());
            if (!map.containsKey(r[1])) map.put(r[1], new ArrayList<>());
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        int count = 0, res = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                visited.add(cur);
                count++;
                if (!map.containsKey(cur)) continue;
                for (int next : map.get(cur)) {
                    if (!visited.contains(next) && --indegrees[next] == 0) queue.offer(next);
                }
            }
        }
        return count == n ? res : -1;
    }
}
