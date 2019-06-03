class Solution {
    private int mod = 1000000007;
    public int numFactoredBinaryTrees(int[] A) {
        if (A == null || A.length == 0) return 0;
        Map<Integer, Long> map = new HashMap<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], 1L);  //dp[i] = dp[j] * dp[i / j] + 1; 1是自身可单独形成
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0 && map.containsKey(A[i] / A[j])) {
                    long count = map.get(A[i]) + map.get(A[j]) * map.get(A[i] / A[j]);
                    map.put(A[i], count % mod);
                }
            }
        }
        long res = 0L;
        for (long v : map.values()) res = (res + v) % mod; //因为可以用或者不用，所以要把所有的加一起
        return (int)res;
    }
}
