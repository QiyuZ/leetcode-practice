class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0) return 0;
        int m = picture.length, n = picture[0].length, res = 0;
        int[] row = new int[m], col = new int[n];
        //第一步生成每行每列个数的map
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int j = 0; j < picture[0].length; j++) {
            if (col[j] != N) continue;
                boolean valid = false;
                int prevRow = -1;
                for (int i = 0; i < picture.length; i++) {
                    if (picture[i][j] == 'B') {
                        if (prevRow == -1 && row[i] == N || 
                            row[i] == N && Arrays.equals(picture[prevRow], picture[i])) {
                            prevRow = i;
                            valid = true;
                        } else {
                            valid = false; //只要有一个是B 但是不满足条件的这一列就全废了
                            break;
                        }
                    }
                }
                if (valid) res += N;
        }
        return res;
    }
}
