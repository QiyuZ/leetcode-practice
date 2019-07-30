class Solution {
    public int numSubarraysWithSum(int[] A, int S) { //sliding window
        int l = 0, r = 0, sum = 0, count = 0;
        while (r < A.length) {
            sum += A[r];
            while (r > l && sum > S) sum -= A[l++];
            if (sum == S) count++;
            for (int i = l; i < r && S == sum && A[i] == 0; i++) count++;
            r++;
        }
        return count;
    }
}
