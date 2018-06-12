class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int)Math.pow(10, n) - 1;
        for (int i = max - 1; i >= max / 10; i--) {
            long res = Long.valueOf(i + new StringBuilder().append(i).reverse().toString()); //可能的回文数
            for (long j = max; j * j >= res; j--) { //最小值不用试到0，到平方比res小下面的就不可能了
                if (res % j == 0)
                    return (int)(res % 1337);
            }
        }
        return 0;
    }
}
