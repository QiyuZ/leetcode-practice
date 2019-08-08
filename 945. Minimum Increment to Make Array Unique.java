class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length <= 1) return 0;
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {//此处要小于等于因为后面变了后可能变小了比如 1，1，2,2,3,7 -> 1,2,3,2,3,7
                int temp = A[i];
                A[i] = A[i - 1] + 1;
                res += A[i] - temp;
            }
        }
        return res;
    }
}
