class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) return A;
        int l = 0, r = A.length - 1;
        while (l < r) { 
            while (l < r && A[l] % 2 == 0) l++; //odd左，even右，找到不符合的两边，交换
            while (l < r && A[r] % 2 == 1) r--;
            int temp = A[l];
            A[l++] = A[r];
            A[r--] = temp;
        }
        return A;
    }
}
