class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) sum += a % 2 == 0 ? a : 0;
        int[] res = new int[A.length];
        int i = 0;
        for (int[] q : queries) {
            int val = q[0], index = q[1];
            if (A[index] % 2 == 0 && (A[index] + val) % 2 == 0) sum += val; //偶变偶
            else if ((A[index] + val) % 2 == 0) sum += A[index] + val; //奇数变偶数
            else if (A[index] % 2 == 0 && (A[index] + val) % 2 != 0) sum -= A[index]; //偶数变奇数，忽略奇数变奇数
            A[index] += val;//别忘了更新A
            res[i++] = sum;
        }
        return res;
    }
}
