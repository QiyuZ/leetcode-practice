// class Solution {
//     int sum = Integer.MAX_VALUE;
//     public int assignBikes(int[][] workers, int[][] bikes) {
//         dfs(workers, 0, bikes, new boolean[bikes.length], 0);
//         return sum;
//     }
//     private void dfs(int[][] workers, int i, int[][] bikes, boolean[] usedBikes, int dis) {
//         if (i == workers.length) {
//             sum = Math.min(dis, sum);
//             return;
//         }
//         if (dis >= sum) return;
//         for (int j = 0; j < bikes.length; j++) {
//             if (usedBikes[j]) continue;
//             usedBikes[j] = true;
//             dfs(workers, i + 1, bikes, usedBikes, dis + getDistance(workers[i], bikes[j]));
//             usedBikes[j] = false;
//         }
//     }
//     private int getDistance(int[] worker, int[] bike) {
//         return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
//     }
// }

class Solution {
    Map<String, Integer> map = new HashMap<>();
    //提升1 用map记录状态，到了第几个worker和bikes的使用状态i + "&" + mask，如果相同则可以直接读取值
    public int assignBikes(int[][] workers, int[][] bikes) {
        return dfs(workers, 0, bikes, 0);
    }
    private int dfs(int[][] workers, int i, int[][] bikes, int mask) {//提升2 用mask来表示所有bikes的使用情况比如011就是第一个没用
        if (i == workers.length) return 0;
        if (map.containsKey(i + "&" + mask)) return map.get(i + "&" + mask);
        int dis = Integer.MAX_VALUE;
        for (int j = 0; j < bikes.length; j++) {
            if ((mask & (1 << j)) != 0) continue;
            int temp = getDistance(workers[i], bikes[j]) + dfs(workers, i + 1, bikes, (mask | (1 << j)));
            if (temp < dis) dis = temp;
        }
        map.put(i + "&" + mask, dis);
        return dis;
    }
    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
