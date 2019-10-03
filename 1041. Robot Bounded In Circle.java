class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //按照一个顺序来，一直向左或者向右
        int d = 0, x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') d = (d + 1) % 4; //如果上面顺序是向左，那么此处就是+1，向右则是+3
            else if (instructions.charAt(i) == 'R') d = (d + 3) % 4;
            else {
                x += dirs[d][0];
                y += dirs[d][1];
            }
        }
        return (x == 0 && y == 0) || d != 0; //只要方向变了，多走几个肯定会回来
    }
}
