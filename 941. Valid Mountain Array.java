class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2) return false;
        int i = 0, j = A.length - 1;
        while (i + 1 < A.length && A[i + 1] > A[i]) i++;
        while (j - 1 >= 0 && A[j] < A[j - 1]) j--;
        return i < A.length - 1 && j > 0 && i == j; //从两头爬山，看最后是否相遇并且不是两边
    }
}
