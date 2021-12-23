class Solution {
    public int findKthPositive(int[] arr, int k) {
        int target = 1, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target) {
                if (count + arr[i] - target >= k) return target + (k - count) - 1;
                count = count + arr[i] - target;
            }
            target = arr[i] + 1;
        }
        return target + (k - count) - 1;
    }
}

class Solution {
    public int findKthPositive(int[] A, int k) {
        int l = 0, r = A.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] - 1 - m < k) l = m + 1; //normally, arr[index] - index - 1 = 0, if larger than k, that means missing before index
            else r = m;
        }
        return l + k;
    }
}
