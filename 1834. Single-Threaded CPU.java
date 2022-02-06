class Solution {//idea:sort by start time and add into the queue when the started time <= pre task done, the queue sorts by processing time
    public int[] getOrder(int[][] tasks) {
        if (tasks == null || tasks.length == 0) return new int[0];
        int n = tasks.length;
        int[][] orders = new int[n][3];
        for (int i = 0; i < n; i++) orders[i] = new int[] {i, tasks[i][0], tasks[i][1]};
        Arrays.sort(orders, (a, b) -> a[1] - b[1]); //the ones start earlier should be added into the queue earlier
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]); //sort firstly by processing time, then index
        int pos = 0, time = 0, i = 0;
        int[] res = new int[n];
        while (pos < n) { //note better use pos than i, because all orders could be added into queue, then i==n but pos's not. Or here we can do i < n && !queue.isEmpty()
            if (queue.isEmpty()) time = Math.max(time, orders[i][1]);//the previous task done time or next task's starting time
            while (i < n && time >= orders[i][1]) queue.offer(orders[i++]); //add all potential task into the queue
            int[] cur = queue.poll();
            res[pos++] = cur[0];
            time += cur[2];
        }
        return res;
    }
}
