class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {  //只要是第一位一定要变为1
            if (A[i][0] == 0) toggle(A, i, "row");
        }
        for (int j = 1; j < n; j++) { //查看col 0比1多就变
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 0) count++;
            }
            if (count > m - count) toggle(A, j, "col");
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int cur = 0, multi = 0;
            for (int j = n - 1; j >= 0; j--) {
                cur += A[i][j] * Math.pow(2, multi++);
            }
            sum += cur;
        }
        return sum;
    }
    
    private void toggle(int[][] A, int index, String s) {
        if (s.equals("row")) {
            for (int j = 0; j < A[0].length; j++) A[index][j] = A[index][j] == 0 ? 1 : 0;
        } else {
            for (int i = 0; i < A.length; i++) A[i][index] = A[i][index] == 0 ? 1 : 0;
        }
    }
}




class Solution {
    public int matrixScore(int[][] A) {
        int M = A.length, N = A[0].length, res = (1 << (N - 1)) * M;//只要是第一位一定要变为1
        for (int j = 1; j < N; j++) { //只要A[i][j] == A[i][0]，那么不管这一行变没变，现在它会是1，那么cur就是计算1的个数
            int cur = 0;
            for (int i = 0; i < M; i++) cur += A[i][j] == A[i][0] ? 1 : 0;
            //     这一列有几个这样的数 * 每个的价值
            res += Math.max(cur, M - cur) * (1 << (N - j - 1)); //1多不变，0多变，这里不需要操作A，只要计算数量即可找最大的
        }
        return res;
    }
}
