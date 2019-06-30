class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        long a = A, b = B, tmp, l = 2, r = (long)1e14, mod = (long)1e9 + 7;
        while (b > 0) { //最大公约数
            tmp = a;
            a = b;
            b = tmp % b;
        }
        while (l < r) {
            long mid = l + (r - l) / 2;
            long count = mid / A + mid / B - mid / (A * B / a); //A * B / a 这是最小公倍数
            if (count < N) l = mid+ 1;
            else r = mid;
        }
        return (int)(l % mod);
    }
}
