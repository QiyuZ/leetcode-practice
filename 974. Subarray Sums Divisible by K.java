class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1; //余数为0的本身就可以比如0，5 %5，而其他余数的需要等下一个做差
        int sum = 0, res = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) sum += K; //余数-1和1是一样的比如-2，7 % 5
            res += map[sum]++;
        }
        return res;
    }
}
//放进去余数， 比如(a+b)%5=1, (a+b+c)%5=1那么c就是5的倍数, 如果(a+b+c+d)%5=1 那么就有三个 c, d, c+d
