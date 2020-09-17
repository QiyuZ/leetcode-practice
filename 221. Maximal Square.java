// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         if (matrix == null || matrix.length == 0) return 0;
//         int[][] squares = new int[matrix.length][matrix[0].length];
//         int res = 0;
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (i == 0 || j == 0) {
//                     squares[i][j] = matrix[i][j] - '0';
//                     if (matrix[i][j] == '1' && res == 0) res = 1; //因为边界没有之前的，所以要单独判断，更好的方法是让squares多一层行和列作为缓冲，保证generic 写法
//                     continue;
//                 }
//                 if (matrix[i][j] != '1') continue;
//                 squares[i][j] = Math.min(squares[i - 1][j], Math.min(squares[i - 1][j - 1], squares[i][j - 1])) + 1;
//                 res = Math.max(res, squares[i][j]);
//             }
//         }
//         return res * res;
//     }
// }

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(dp[i][j], res);
                } 
            }
        }
        return res * res;
    }
}
