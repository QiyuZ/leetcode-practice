class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1; //相当于是展开递增的
        while (l < r) {
            int mid = l + (r - l) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            else if (val > target) r = mid;
            else l = mid + 1;
        }
        return matrix[l / n][l % n] == target;
    }
}
