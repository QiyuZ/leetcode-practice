class Solution {
    public int maxHeight(int[][] cuboids) {//actually just a 3d 300. Longest Increasing Subsequence
        if (cuboids == null || cuboids.length == 0) return 0;
        for (int[] c : cuboids) Arrays.sort(c); //we wanna the height to be the max
        Arrays.sort(cuboids, (a, b) -> a[0] + a[1] + a[2] - b[0] - b[1] - b[2]); //sort it from ptential smaller to larger, as it's more possible to meer the requirement in line 11
        int res = 0;
        int[] dp = new int[cuboids.length];
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2]; //init value, current one
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]); //previous sum plus current one
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
