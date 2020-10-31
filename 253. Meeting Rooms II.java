class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && queue.peek()[1] <= interval[0]) queue.poll();
            queue.offer(interval);
        }
        return queue.size();
    }
}
