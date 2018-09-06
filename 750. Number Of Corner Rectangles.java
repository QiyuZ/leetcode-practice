class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length <= 1 || grid[0].length <= 1) return 0;
        int res = 0, n = grid.length, m= grid[0].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < m; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) count++;
                }
                res += count > 0 ? count * (count - 1)  / 2 : 0;
            }
        }
        return res;
    }
}
/* 查找有几个1组成的pair, 比如对照第一行和接下来每一行，比如 i和i+1行，有几组1在同一个col上面（可以形成rec）
1 0 1 0 1
1 0 1 1 1

1   2   3    3 * 2 / 2 = 3 */
