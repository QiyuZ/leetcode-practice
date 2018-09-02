class Solution {
    public boolean validTree(int n, int[][] edges) { //union find
        if (n - 1 != edges.length) return false; //检查是否有没连的
        int[] parents = new int[n];
        Arrays.fill(parents, -1); //标记未被连接
        for (int[] edge : edges) {
            int child0 = find(edge[0], parents);
            int child1 = find(edge[1], parents);
            if (child0 == child1) return false; //如果相等说明edge[0]下面已经连过,则说明有cycle不成立
            parents[child0] = child1; 
        }
        return true;
    }
    public int find(int num, int[] parents) {
        if (parents[num] == -1) return num;
        return find(parents[num], parents);
    }
}
