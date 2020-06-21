class Solution {
    public int calculateMinimumHP(int[][] dungeon) {//从后到前看最少损失多少health,不能从前到后因为不知道未来的cost
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] minRequired = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) minRequired[i][n] = Integer.MAX_VALUE;//边际最大值
        for (int j = 0; j <= n; j++) minRequired[m][j] = Integer.MAX_VALUE;
        minRequired[m][n - 1] = 0;//终点的右边和下边标0因为已经是最后一个
        minRequired[m - 1][n] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int fromPath = Math.min(minRequired[i + 1][j], minRequired[i][j + 1]);//选择一边的最小required
                minRequired[i][j] = Math.max(fromPath - dungeon[i][j], 0);
                //这里是减因为是求最小要求的比如0-(-5)=5就是至少要5health,0-5=-5说明不会减少即取0
            }
        }
        return minRequired[0][0] + 1;//以上求的是以0为标准，但是题目要求是>0所以+1
    }
}
