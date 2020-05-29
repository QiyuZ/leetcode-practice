class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i / 2] + (i % 2 == 0 ? 0 : 1);
        }
        return res;
    }
}
/**
* 对于偶数 2, 4 : 10, 100;  3, 6 : 11, 110 它们1个数相等是因为如果翻一倍相=左移=末尾加0，所以res[i] = res[i / 2]
* 但是对于比如2,3：10, 11 因为最后一位变成了1所以要判断奇数偶数，奇数+1
*/
