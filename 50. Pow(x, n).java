class Solution {
    public double myPow(double x, int n) { //lgn
        if (n == 0 || x == 1) return 1;
        boolean negative = (n < 0);
        long count = n > 0 ? n : -(long)n; //注意用long,防止Corner case 越界，而且负号要放在long前面，否则结果越界
        double res = 1;
        while (count > 0) {
            if (count % 2 != 0) { //因为最后肯定是1要乘以前面的x
                count--;
                res *= x;
            } else {
                count /= 2;
                x *= x;
            }
        }
        return negative ? (1.0 / res) : res;
    }
}
