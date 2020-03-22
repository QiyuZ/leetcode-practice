class Solution {
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        if (n <= 0 || m > 10) return res;
        int[][] skip = new int[10][10]; //构建map
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[1][9] = skip[9][1] = 5;
        skip[2][8] = skip[8][2] = 5;
        skip[3][7] = skip[7][3] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        boolean[] visited = new boolean[10];
        for (int i = m; i <= n; i++) {  //对称性四个角一样，四个边上的中间一样，中间5一个
            res += dfs(1, i - 1, skip, visited) * 4; //4 corners
            res += dfs(2, i - 1, skip, visited) * 4; // 4 mid of sides
            res += dfs(5, i - 1, skip, visited); // 1 middle
        }
        return res;
    }
    
    private int dfs(int cur, int num, int[][] skip, boolean[] visited) {
        if (num == 0) return 1;
        int res = 0;
        visited[cur] = true;
        for (int next = 1; next <= 9; next++) {
            int needSkip = skip[cur][next];
            if (visited[next] || (needSkip != 0 && !visited[needSkip])) continue;
            res += dfs(next, num - 1, skip, visited);
        }
        visited[cur] = false;
        return res;
    }
}


class Solution { //一次操作
    public int numberOfPatterns(int m, int n) {
        int[][] obstacle = new int[10][10];
        obstacle[1][3] = obstacle[3][1] = 2;
        obstacle[1][7] = obstacle[7][1] = 4;
        obstacle[3][9] = obstacle[9][3] = 6;
        obstacle[7][9] = obstacle[9][7] = 8;
        obstacle[1][9] = obstacle[9][1] = obstacle[3][7] = obstacle[7][3] = 
        obstacle[2][8] = obstacle[8][2] = obstacle[4][6] = obstacle[6][4] = 5;
        return dfs(m, n, 1, 1, obstacle, new boolean[10]) * 4 +
               dfs(m, n, 1, 2, obstacle, new boolean[10]) * 4 +
               dfs(m, n, 1, 5, obstacle, new boolean[10]);
    }
    
    int dfs(int m, int n, int steps, int cur, int[][] obstacle, boolean[] visited) {
        if (steps == n) return 1;
        if (steps > n) return 0;
        int ret = steps >= m ? 1 : 0; //大于等于m则说明当前已经符合，所以初始化为1
        visited[cur] = true;
        for (int i = 1; i <= 9; i++) {
            int needSkip = obstacle[cur][i];
            if (visited[i] || (needSkip != 0 && !visited[needSkip])) continue;
            ret += dfs(m, n, steps + 1, i, obstacle, visited);
        }
        visited[cur] = false;
        return ret;
    }
}
