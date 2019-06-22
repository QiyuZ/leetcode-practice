class Solution {
    public int[][] transpose(int[][] A) {
        int[][] b = new int[A[0].length][A.length]; //就是把坐标反一下，因为有可能长宽不一样，所以初始化长度翻转
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                b[j][i] = A[i][j];
            }
        }
        return b;
    }
}
