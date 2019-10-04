class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) queue.offer(s);
        while (queue.size() >= 2) {
            int y = queue.poll(), x = queue.poll();
            if(y - x > 0) queue.offer(y - x);
        }
        return queue.size() == 0 ? 0 : queue.poll();
    }
}
