public int getLength (int[][] grid, int startX, int startY) {
	if (grid == null || grid.length == 0) return 0;
	int target = grid[startX][startY];
	Queue<int[]> queue = new LinkedList<>();
	queue.offer(new int[] {startX, startY});
	boolean[][] visited = new boolean[grid.length][grid[0].length];
	visited[startX][startY] = true;
	int res = 0;
	int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	while (!queue.isEmpty()) {
		int[] cur = queue.poll();
		int x = cur[0], y = cur[1];
		int count = 0
		for (int[] dir : dirs) {
			int i = x + dir[0];
			int j = y + dir[1];
			if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) continue;
			queue.offer(new int[] {i, j});
			visited[i][j] = true;
			count++;
		}
		res += 4 - count;
	}
	return res;
}
