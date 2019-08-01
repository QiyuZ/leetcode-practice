class Solution {
    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int min = Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A[0].length - 1, j + 1)]));
                A[i][j] += min;
            }
        }
        int res = 101;
        for (int num : A[A.length - 1]) res = Math.min(res, num);
        return res;
    }
}


