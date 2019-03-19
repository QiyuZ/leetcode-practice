class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int sum = 0, F = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F += i * A[i];
        }
        int res = F;
        for (int i = A.length - 1; i>= 1; i--) {
            F = F + sum - A[i] * A.length; //可观察新的值等于上一个+sum再减去最后一个乘以长度
            res = Math.max(F, res);
        }
        return res;
    }
}
/**
A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
F(0)到F(1)相当于都加一倍然后最后-4*6
*/
