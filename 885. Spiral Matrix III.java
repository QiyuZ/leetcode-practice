class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>();
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int move = 0, d = 0;
        res.add(new int[] {r0, c0});
        while (res.size() < R * C) { //不能等于
            if (d == 0 || d == 2) move += 1; //长度+1
            for (int i = 0; i < move; i++) {
                r0 += dirs[d][0];
                c0 += dirs[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) res.add(new int[] {r0, c0});
            }
            d = (d + 1) % 4;
        }
        return res.toArray(new int[R * C][2]);
    }
}
