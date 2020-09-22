class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        boolean col = false, row = false; //单独考虑第一行和第一列因为比如第一行被变了对应的列都会变0
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true; //标记第一行和第一列是否变0
                    if (j == 0) col = true;
                    matrix[i][0] = 0; //标记的第一行和第一列相应位置
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0; //根据mark决定是否变0
            }
        }
        if (row) Arrays.fill(matrix[0], 0); //处理第一行
        if (col) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;//处理第一列
        }
    }
}
