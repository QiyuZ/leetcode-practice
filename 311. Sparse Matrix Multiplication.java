class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int an = A.length, am = A[0].length, bn = B.length, bm = B[0].length;
        int[][] res = new int[an][bm];
        for (int i = 0; i < an; i++) {
            for (int j = 0; j < am; j++) {
                if (A[i][j] != 0) { //0的可以忽略，节省时间
                    for (int k = 0; k < bm; k++) {
                        if (B[j][k] != 0) res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
/*
比如例子中 res[0][0] = 7 = (0,0)*(0,0) + (0,1)*(1,0) + (0,2)*(2,0) 
所以通式为 res[i][k] = a[i][j] * b[j][k] */
