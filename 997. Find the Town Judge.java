class Solution {
    public int findJudge(int N, int[][] trust) { //不能用union find因为这相当于是个单向图
        int[] graph = new int[N + 1];
        for (int[] t : trust) {
            graph[t[0]]--; //出发node减去入度
            graph[t[1]]++; //接入的node加上入度
        }
        for (int i = 1; i < graph.length; i++) {
            if (graph[i] == N - 1) return i; //judge除了本身就有人连接所以是n-1
        }
        return -1;
    }
}
