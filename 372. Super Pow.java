class Solution {
    private int m = 1337;
    public int superPow(int a, int[] b) {
        a %= m;
        int res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = res * normalPow(a, b[i]) % m;
            a = normalPow(a, 10); //比如2^15 到b[0]=1时，先把a变成2^10再a^b[0], 其实就是2^15=2^10*2^5
        }
        return res;
    }
    public int normalPow(int a, int b) {
        int res = 1;
        while (b != 0) {
            if (b % 2 != 0)  res = (res * a) % m; //是奇数就把多出来的那一位乘到结果上
            a = (a * a) % m; //然后肯定是偶数把a相乘
            b /= 2;
        }
        return res;
    }
}
