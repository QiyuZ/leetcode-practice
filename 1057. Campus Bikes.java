class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> { //优先级别 距离, worker, bike
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[2], b[2]);
        });
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                queue.offer(new int[] {(Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1])), i, j});
            }
        }
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] usedBikes = new boolean[bikes.length];
        int count = 0;
        while (!queue.isEmpty() && count < workers.length) { //用count就不用每次都检查是否全都更新了
            int[] cur = queue.poll();
            if (res[cur[1]] == -1 && !usedBikes[cur[2]]) {//如果之前res已经有值了说明之前距离更小不用更新，并且那个自行车要没被用过
                res[cur[1]] = cur[2];
                usedBikes[cur[2]] = true;
                count++;
            }
        }
        return res;
    }
}
