class Solution {
    public int consecutiveNumbersSum(int N) { 
        // (x + (x + (m - 1))) * m / 2 = N 等差数列公式 -> (2x + m - 1) * m = 2N -> 2xm + m^2 - m = 2n -> x = ((N - m(m-1)/2)) / m,可见m是关键，列举m
        int res = 0;
        for (int m = 1; m <= N; m++) { //虽然是<=m 但是其实复杂度是sqrt(n)，因为for里面是（m - 1） * m
            int mx = N - (m - 1) * m / 2;
            if (mx <= 0) break; //mx<=0 不用接着试，后面的都不成立
            if (mx % m == 0) res++; //有此个x和m则成立
        }
        return res;
    }
}
