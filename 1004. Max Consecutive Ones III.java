class Solution {
    public int longestOnes(int[] A, int K) {
        int res = 0, i = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0) K--;
            while (K < 0) {
                if (A[i] == 0) K++;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
