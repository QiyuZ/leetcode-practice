class Solution {
    public int largestIsland(int[][] grid) { //染色法，然后查看0和哪几个相连，找面积最大的
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int n = grid.length;
        int color = 2; //0,1 已经有，从2开始
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, color);
                    map.put(color++, area);
                }
            }
        }
        int res = map.getOrDefault(2, 0); //不能为0因为可能全染了，那么下面的遍历就找不到面积了
        if (res == n * n) return res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>(); //防止重复
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < n - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < n - 1 ? grid[i][j + 1] : 0);
                    int newArea = 1; //本次的0变1也计算进去
                    for (int c : set) newArea += map.get(c);
                    res = Math.max(res, newArea);
                }
            }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = color;
        return 1 + dfs(grid, i + 1, j, color) + dfs(grid, i - 1, j, color) + dfs(grid, i, j - 1, color) + dfs(grid, i, j + 1, color);
    }
}
