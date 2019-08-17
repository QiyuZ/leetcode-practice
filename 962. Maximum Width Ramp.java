class Solution {
    public int maxWidthRamp(int[] A) { //n^2思路双指针前后找依次计算，但其实从后面找最大的那个可以保留着节约时间，所以用maxR记录
        if (A.length == 0) return 0;
        int[] maxR = new int[A.length];
        maxR[maxR.length - 1] = A[A.length - 1];
        for (int i = maxR.length - 2; i >= 0; i--) maxR[i] = Math.max(A[i], maxR[i + 1]);
        int i = 0, j = 0, res = 0;
        while (i < A.length && j < maxR.length) {
            if (A[i] <= maxR[j]) { //如果符合就向后走更新res
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;//不符合只能移动i
            }
        }
        return res;
    }
}
