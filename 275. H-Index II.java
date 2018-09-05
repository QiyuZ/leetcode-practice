class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length, n = citations.length; //这里最大值是长度所以 r = length
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (citations[mid] == n - mid) return n - mid;
            else if (citations[mid] < n - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}
