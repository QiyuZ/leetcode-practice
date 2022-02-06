class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] meeting : meetings) {
            if (!map.containsKey(meeting[0])) map.put(meeting[0], new ArrayList<>());
            if (!map.containsKey(meeting[1])) map.put(meeting[1], new ArrayList<>());
            map.get(meeting[0]).add(new int[] {meeting[1], meeting[2]});
            map.get(meeting[1]).add(new int[] {meeting[0], meeting[2]});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]); //person, time when know
        queue.offer(new int[] {0, 0});
        queue.offer(new int[] {firstPerson, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            visited.add(p[0]); //note add here instead of inside the for loop, because if we add the next node with late time the same person with earlier time can't be added
            if (!map.containsKey(p[0])) continue;
            for (int[] m : map.get(p[0])) {
                if (m[1] < p[1] || visited.contains(m[0])) continue;
                queue.offer(new int[]{m[0], m[1]});
            }
            map.remove(p[0]);
        }
        return new ArrayList<>(visited);
    }
}
