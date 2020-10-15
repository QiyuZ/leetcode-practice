class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[] {};
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0, i = 0;
        while (i < res.length) {
            res[i++] = matrix[r][c];
            if ((r + c) % 2 == 0) { //根据方向分为两组，左上的坐标都是2的倍数
                if (c == n - 1) r++; //一般来说走到左上的头后要向右移，但是如果右边没有了就要像下移
                else if (r == 0) c++;//一般向右移
                else {
                    r--;
                    c++;
                }
            } else { ///根据方向分为两组，右下的坐标都不是2的倍数
                if (r == m - 1) c++; //一般来说走到右下的头后要向下移，但是如果右边没有了就要像右移
                else if (c == 0) r++;//一般来说走到右下的头后要向下移
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
