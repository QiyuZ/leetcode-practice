class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> (a.height - b.height));
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        int res = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir : dirs) {
                int row = dir[0] + cur.row;
                int col = dir[1] + cur.col;
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) continue;
                res += Math.max(0, cur.height - heightMap[row][col]);
                visited[row][col] = true;
                queue.offer(new Cell(row, col, Math.max(cur.height, heightMap[row][col])));
            }
        }
        return res;
    }
    
    class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}

/*
从四周到中间开始找出最低的和周围的比较，如果比周围的哪个大则说明可以装水，因为这个已经是最低的了，并且把较高高度传递下去，因为这个高度可以一直装水
直到遇到更低的
*/
