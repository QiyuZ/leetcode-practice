class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }
    
    private int atMost(int[] A, int K) { //滑动窗口是算至少的，算两个减去即使exactly K的
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, res = 0;
        for (int j = 0; j < A.length; j++) {
            if (map.getOrDefault(A[j], 0) == 0) K--;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1; //比如到了1，2，1那么121，21，1， 2-0+1=3
        }
        return res;
    }
}

