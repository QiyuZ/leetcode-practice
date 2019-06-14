class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int target = 0, level = 0; //用bit表示状态，比如1,2分别是1,10 target就是11，即最后比较的
        for (int i = 0; i < graph.length; i++) {
            int status = (1 << i);
            target |= status;
            visited.add(status + "-" + i); 
            queue.offer(new int[] {status, i}); //i来记录下一个的位置
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == target) return level;
                for (int j = 0; j < graph[cur[1]].length; j++) {
                    int nextNode = graph[cur[1]][j];
                    int nextStatus = cur[0] | (1 << nextNode); //更新状态，继续异或
                    if (visited.contains(nextNode + "+" + nextStatus)) continue;
                    visited.add(nextNode + "+" + nextStatus);
                    queue.offer(new int[] {nextStatus, nextNode});
                }
            }
            level++;
        }
        return -1;
    }
}
