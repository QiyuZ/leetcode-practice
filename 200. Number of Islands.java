class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    //如果是1就 count+1并且把四周以及四周的四周（DFS）全变成0，这样后后面的就不会有重复了
    public  void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

//union find
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0, m = grid.length, n = grid[0].length;
        int[] union = new int[m * n];
        int[][] dirs = {{-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    union[i * n + j] = i * n + j;
                    count++;
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') continue;
                        int a = i * n + j, b = find(union, x * n + y);
                        if (a != b) {
                            count--;
                            union[b] = a;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int find(int[] union, int index) {
        if (union[index] != index) return find(union, union[index]);
        return index;
    }
}
