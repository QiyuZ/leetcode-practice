class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int res = 0;
        for (int i = L; i <= R; i++) {
            int num = 0;
            int j = i;
            while (j != 0) {
                if ((j & 1) == 1) num++;
                j >>= 1;
            }
            if (primes.contains(num)) res++;
        }
        return res;
    }
}



class Solution {
    public int countPrimeSetBits(int L, int R) {
        int cnt = 0;
        Set<Integer> listPrimes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29 ));
        int[] res = countBits(R);
        for(int i=L;i<=R;i++){
            if(listPrimes.contains(res[i])){
                cnt++;
            }             
        }
        return cnt;
    }    
    
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= num; i++){
            dp[i] = dp[i >> 1] + dp[i & 1]; //  比如110 11的加上0的
        }
        return dp;
    }
}
