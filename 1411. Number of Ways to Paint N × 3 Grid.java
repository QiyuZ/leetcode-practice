class Solution {
    public int numOfWays(int n) {
        if (n <= 0) return 0;
        //第一行来看按照pattern来分 ABA, ABC各有6种 即 3 * 2 = 6， 3 * 2 * 1 = 6
        //pattern ABA 可以产生3种ABA的即 BAB BCB CAC 和两种ABC的即 CAB BAC
        //pattern ABC 可以产生2中ABC即 CAB BAC 和两种ABA的即BCB BAB
        //double(n) = 3 * double(n - 1) + 2 * triple(n - 1);
        //triple(n) = 2 * double(n - 1) + 2 * triple(n - 1);
        //total(n) = double(n) + double(n)
        long tripleColor = 6, doubleColor = 6;
        int mod = 1000000007;
        while (n > 1) {
            long tempDouble = doubleColor;
            doubleColor = ((3 * doubleColor) % mod + (2 * tripleColor) % mod) % mod;
            tripleColor = ((2 * tempDouble) % mod + (2 * tripleColor) % mod) % mod;
            n--;
        }
        return (int)(doubleColor + tripleColor) % mod;
    }
}
