class Solution {
    private final int[][] dirs = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};               
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        x = Math.abs(x); //利用对称性，到（-10， -1） 和到（10， 1）是相同的步数
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[] {0, 0});
        visited.add("0-0");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (x == cur[0] && y == cur[1]) return count;
                for (int[] dir : dirs) {
                    int newX = dir[0] + cur[0], newY = dir[1] + cur[1];
                    if (newX < -1 || newY < -1 || newX + newY > 300 || visited.contains(newX + "-" + newY)) continue;
                    //此处有个特殊情况，起始时要考虑可以往负方向走，所以把左边拓宽两个
                    queue.offer(new int[] {newX, newY});
                     visited.add(newX + "-" + newY);
                }
            }
            count++;
        }
        return -1;
    }
}
