class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            while (r >= 0 && A[r] % 2 == 1) r--; //找到右边第一个偶数
            while (l < A.length && A[l] % 2 == 0) l++; //找到左边第一个奇数
            if (r <= l) break; //比如全是偶数，此时l>r，就跳出
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            r--;
            l++;
        }
        return A;
    }
}
