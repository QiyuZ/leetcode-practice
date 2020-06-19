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

class Solution {
    public int hIndex(int[] citations) { //找到临界点，所有0到l-1的citations小于l, l到n的citations大于等于n-l
        if (citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length - 1, n = citations.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] == n - mid) return n - mid;
            else if (citations[mid] > citations.length - mid) r = mid;
            else l = mid + 1;
        }
        if (citations[l] < n - l) l++; //avoid [0,0]
        return n - l;
    }
}


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {//N − h papers have no more than h
                return n - i;
            }
        }
        return 0;   
    }
}
