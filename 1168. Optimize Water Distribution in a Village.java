class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if (wells == null || wells.length == 0) return 0;
        List<int[]> edges = new ArrayList<>();
        int[] uf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
            edges.add(new int[] {0, i, wells[i - 1]}); //convert the build well to "we have a well at 0, it will cost wells[i] to connect to other places"
        }
        for (int[] pipe : pipes) edges.add(pipe);
        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for (int[] edge : edges) {
            int parent1 = find(uf, edge[0]), parent2 = find(uf, edge[1]);
            if (parent1 == parent2) continue;
            res += edge[2];
            uf[parent1] = parent2;
        }
        return res;
    }
    private int find(int[] uf, int parent) {
        if (parent == uf[parent]) return parent;
        return find(uf, uf[parent]);
    }
}
