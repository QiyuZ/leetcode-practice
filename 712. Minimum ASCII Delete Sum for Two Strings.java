class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] cost = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                if (i == 0 && j == 0) cost[i][j] = 0;
                else if (i == 0) cost[i][j] = cost[i][j - 1] + s2.charAt(j - 1); //横竖的第一行意味着删光所有，所以要全加起来
                else if (j == 0) cost[i][j] = cost[i - 1][j] + s1.charAt(i - 1);
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) cost[i][j] = cost[i - 1][j - 1]; //相等不动
                else cost[i][j] = Math.min(cost[i - 1][j] + s1.charAt(i - 1), cost[i][j - 1] + s2.charAt(j - 1)); //不等，删最小的
            }
        }
        return cost[s1.length()][s2.length()];
    }
}//same as edit distance
