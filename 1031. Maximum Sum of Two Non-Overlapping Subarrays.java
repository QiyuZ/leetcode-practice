class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) sum[i] = sum[i - 1] + A[i];
        int m = sum[M - 1], l = sum[L - 1], res = 0;
        for (int i = 0; i < A.length; i++) {
            if (i >= L && i + M - 1 < A.length) res = Math.max(res, l + sum[i + M - 1] - sum[i - 1]); //l在左，m在右
            if (i >= M && i + L - 1 < A.length) res = Math.max(res, m + sum[i + L - 1] - sum[i - 1]); //m在左，l在右
            if (i >= L) l = Math.max(l, sum[i] - sum[i - L]); //更新
            if (i >= M) m = Math.max(m, sum[i] - sum[i - M]);
        }
        return res;
    }
}
