class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0], score = item[1];
            if (!map.containsKey(id)) map.put(id, new PriorityQueue<>((a, b) -> (b - a)));
            map.get(id).offer(score);
        }
        int index = 0;
        int[][] res = new int[map.size()][2];
        for (int id : map.keySet()) {
            int sum = 0;
            for (int i = 0; i < 5; i++) sum += map.get(id).poll();
            res[index++] = new int[] {id, sum / 5};
        }
        return res;
    }
}
