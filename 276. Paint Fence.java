class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        //初始第一个围栏，没有相同（刚开始），不同的k，和为k
        int same = 0, diff = k, total = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }
}
//举例1,2,3 涂到3时，如果要2,3颜色不同则(k-1)*total（之前的）
//如果颜色要和2相同，则面临的情况和2涂和1颜色不同的方法一样多 所以same=diff
