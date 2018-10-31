class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] < A[mid + 1]) l = mid + 1; //mid+1大说明它可能是
            else r = mid;
        }
        return l;
    }
}
