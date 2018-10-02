class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { //往上移动
                if (c == n - 1) r++; //特殊走到头，右边没了项=向下移动
                else if (r == 0) c++; //一般走到头，向右
                else {r--; c++;} //一般就直接右上方
            } else {
                if (r == m - 1) c++;//一般走到头，右移
                else if (c == 0) r++;//特殊走到头，左边没了向下
                else {r++; c--;} //一般情况，直接左下移动
            }
        }
        return res;
    }
}

/*case1. 左下或者右上直接移动
case2. 一般走到头，向右移
特殊走到头（左/右边没了）向下移动*/
