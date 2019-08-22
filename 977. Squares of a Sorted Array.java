Quest Groupsclass Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0;
        while (i < A.length) {
            if (A[i] >= 0) break;
            i++;
        }
        int pos = i, neg = i - 1, index = 0;
        while (pos < A.length && neg >= 0) {
            if (Math.abs(A[neg]) <= A[pos]) {
                res[index++] = (int)Math.pow(A[neg--], 2);
            } else {
                res[index++] = (int)Math.pow(A[pos++], 2);
            }
        }
        while (pos < A.length) res[index++] = (int) Math.pow(A[pos++], 2);
        while (neg >= 0) res[index++] = (int)Math.pow(A[neg--], 2);
        return res;
    }
}


class Solution { 
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) { //从后面开始即可
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
