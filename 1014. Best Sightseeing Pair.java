class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int left = 0; //看作 (A[i] + i) + (A[j] - j) 左右两个数
        int res = A[0] + A[1] - 1;
        for (int i = 1; i < A.length; i++) {
            int cur = A[left] + left + A[i] - i; //计算最佳res
            res = Math.max(res, cur);
            if (A[left] + left < A[i] + i) left = i; //因为左右两个数相当于分开的，所以比较左边是否需要更新，for循环中i就相当于right了
        }
        return res;
    }
}
