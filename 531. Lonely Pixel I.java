class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0) return 0;
        int m = picture.length, n = picture[0].length;
        int[] col = new int[n], row = new int[m];//两个数组分别记录行列B的个数，也可以one-pass，先res++后期如果有一个对应的不是1了再减
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (row[i] != 1) continue;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && col[j] == 1) res++;
            }
        }
        return res;
    }
}
