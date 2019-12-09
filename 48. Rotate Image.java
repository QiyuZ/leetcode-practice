class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) { //注意此处要从i开始，否则1,2  2,1就要变回原来的了
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int l = 0, r = matrix[i].length - 1;
            while (l < r) {
                int temp = matrix[i][l]; 
                matrix[i][l++] = matrix[i][r];
                matrix[i][r--] = temp;
            }
        }
    }
}
