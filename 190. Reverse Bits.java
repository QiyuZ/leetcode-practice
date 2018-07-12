public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1; //每次先左移到本次的位置，刚开始是0所以没关系
            if ((n & 1) == 1) res++; //说明这一位是1，则加1
            n >>= 1; //移到下一位
        }
        return res;
    }
}
