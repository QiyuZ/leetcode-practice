class Solution {
    private static final int mod = 1000000007;
    public int checkRecord(int n){ //ignore A first (as only 1 A is valid) and then insert A into possible cases
        long[] P = new long[n + 1]; //end with Present without absent
        long[] L = new long[n + 1]; //end with Late absent
        P[0] = P[1] = L[1] = 1;
        for(int i = 2; i <= n; i++){
            P[i] = (P[i - 1] + L[i - 1]) % mod;
            L[i] = (P[i - 1] + P[i - 2]) % mod; //1 L or 2 L
        }
        long res = (P[n] + L[n]) % mod;
        //insert A, in position i 
        for(int i = 0; i < n; i++){ 
            long s = ((P[i] + L[i]) % mod * (P[n - 1 - i] + L[n - 1 - i]) % mod) % mod;
            res = (res + s) % mod;
        }
        return (int) res;
    }
}
