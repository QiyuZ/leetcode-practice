class Solution {
    public int lenLongestFibSubseq(int[] A) {
        if (A.length < 3) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length, res = 0;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            map.put(A[j], j); //类似于2 sum的方法，看差值是否存在
            for (int i = 0; i < j; i++) {
                int k = map.getOrDefault(A[j] - A[i], -1);
                dp[i][j] = (A[j] - A[i] < A[i] && k != -1) ? dp[k][i] + 1 : 2; 
                //k需在i前面，并且有这样的k存在，否则就ij算是初始化两个
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0; //至少为3
    }
}


class Solution {
    public int lenLongestFibSubseq(int[] A) {
        if(A.length < 3) return 0;
        int[][] LFS = new int[A.length][A.length];
        int res = 0;
        for(int i=2;i<A.length;i++) {
            int start = 0; int end = i - 1;
            while (start < end) {
                if(A[start] + A[end] > A[i]) end--;
                else if(A[start]+A[end]<A[i]) start++;
                else {
                    LFS[end][i] = LFS[start][end] + 1;
                    res = Math.max(res,LFS[end][i]);
                    end--;
                    start++;
                }
            }
        }
        return res== 0 ? 0 : res + 2;
    }
}
