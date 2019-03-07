class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        int n = s.length();
        int[] min = new int[n];
        boolean[][] pali = new boolean[n][n]; //判断是否是回文
        for (int i = 0; i < n; i++) {
            min[i] = i;
            for (int j = 0; j <= i; j++) {
                //新的左右相等，并且j+1到i-1或者ij相邻或相等，则是回文说明这一段是回文，那么标记回文
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || pali[j + 1][i - 1])) {
                    pali[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);
                    //如果j为0这一段都是回文则0，不用切，否则比较原来和在j前切一下（使得ji回文）
                }
            }
        }
        return min[n - 1];
    }
}
