class Solution {
    public boolean checkValid(int[][] matrix) { //check sum can save space, or use boolean[n][n] or set
        if (matrix == null || matrix.length == 0) return false;
        int n = matrix.length, sum = (1 + n) * n / 2;
        for(int i = 0 ; i < n - 1; i++) { //need to check if there's same value, in case like 2,2,2 passed as 1,2,3
            if(matrix[i][0] == matrix[i + 1][0]) return false;
        }
        for(int j = 0 ; j < n - 1; j++) {
            if(matrix[0][j] == matrix[0][j + 1]) return false;
        }
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) cur += matrix[i][j];
            if (cur != sum) return false;
        }
        for (int j = 0; j < n; j++) {
            int cur = 0;
            for (int i = 0; i < n; i++) cur += matrix[i][j];
            if (cur != sum) return false;
        }
        return true;
    }
}

class Solution {
    public boolean checkValid(int[][] matrix) {
        if(matrix.length == 0) return true;
        int n = matrix.length;
        
        boolean[][] rowMap = new boolean[n][n];
        boolean[][] colMap = new boolean[n][n];
        
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                int val = matrix[row][col];
                rowMap[row][val - 1] = true;
                colMap[val - 1][col] = true;
            }
        }
        
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(rowMap[row][col] && colMap[row][col]) continue;
                return false;
            }
        }
        
        return true;
    }
}
