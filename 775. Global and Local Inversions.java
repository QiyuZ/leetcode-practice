class Solution {
    public boolean isIdealPermutation(int[] A) { //means no extra global inversion which is not local
        if (A == null || A.length == 0) return true;
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1) return false; //因为是0到N-1，所以如果有相差>1则毕竟存在extra global inversion
        }
        return true;
    }
}
