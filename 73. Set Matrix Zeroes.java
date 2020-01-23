public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false; boolean col = false;
        for (int i = 0; i < matrix.length; i++) { //判断某个元素是不是0，如果是则吧对应的行或者列放上0（without extra space），其中如果第一行和
            for (int j = 0; j < matrix[0].length; j++) {  // 和第一列用true false来判断
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0; 
        }
        if (col) {
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }
}
