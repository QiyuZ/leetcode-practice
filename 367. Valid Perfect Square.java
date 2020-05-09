class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        int l = 1, r = num / 2 + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long multi = (long)mid * mid; //可能越界要用long
            if (multi == (long)num) return true;
            else if (multi > (long)num) r = mid;
            else l = mid + 1;
        }
        return (long)l * l == (long)num;
    }
}
