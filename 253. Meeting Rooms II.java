class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
        for (int[] interval : intervals) {
            while (!queue.isEmpty() && queue.peek()[1] <= interval[0]) { 
                int[] pre = queue.poll();
                interval[0] = Math.min(interval[0], pre[0]);//注意这里面不能offer进queue因为可能后面还有
            }
            queue.offer(interval); //要到最后无论有没有poll当前的才能进
        }
        return queue.size();
    }
}
