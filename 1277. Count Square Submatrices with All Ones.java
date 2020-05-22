class Solution {
    public int countSquares(int[][] matrix) { //same as 221, dp 每个数字代表当前最大的边长
        int res = 0;
        if (matrix == null || matrix.length == 0) return res;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    if (i > 0 && j > 0) {//限制于最小的
                        matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + 1;
                    }
                    res += matrix[i][j];
                }
            }
        }
        return res;
    }
}
