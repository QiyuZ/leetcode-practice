class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE, res = -1;
        int l = 0, r = A.length - 1;
        while (l < r) {
            if (A[l] + A[r] >= K) r--;
            else {
                if (K - A[l] - A[r] < diff) {
                    diff = K - A[l] - A[r];
                    res = A[l] + A[r];
                }
                l++;
            }
        }
        return res;
    }
}
