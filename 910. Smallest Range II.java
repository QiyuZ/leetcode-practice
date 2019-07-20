class Solution {
    public int smallestRangeII(int[] A, int K) { //相当于不变或者+2K，不影响结果，所以看做先都不变，然后一个个+2K
        int n = A.length;
        if (n == 1) return 0;
        Arrays.sort(A);
        int min = A[0], max = A[n - 1], res = max - min;
        if (res == 0) return res;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, A[i] + 2 * K); //max 还不变，当前改变
            min = Math.min(A[0] + 2 * K, A[i + 1]); //最小的已经变了，或者就是下一个
            res = Math.min(res, max - min);
        }
        return res;
    }
}
