class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (int[] ob : obstacles) set.add(ob[0] + "-" + ob[1]);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //代表四个方位
        int x = 0, y = 0, res = 0, d = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) d = 0;
            } else if (c == -2) {
                d--;
                if (d == -1) d = 3;
            } else {
                while (c > 0 && !set.contains((x + dirs[d][0]) + "-" + (y + dirs[d][1]))) { //注意这点要加括号
                    x = x + dirs[d][0];
                    y = y + dirs[d][1];
                    c--;
                }
                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }
}
