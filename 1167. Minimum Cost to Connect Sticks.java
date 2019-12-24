class Solution {
    public int connectSticks(int[] sticks) {
        int res = 0;
        if (sticks == null || sticks.length < 2) return res;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : sticks) queue.offer(s);
        while (queue.size() != 1) { //每次用最小的这样cost少
            int combine = queue.poll() + queue.poll();
            res += combine;
            queue.offer(combine);
        }
        return res;
    }
}
