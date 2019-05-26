class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0, count = 0, start = 0; 
        for (int end = 0; end < A.length; end++) {
            if (A[end] >= L && A[end] <= R) {
                count = end - start + 1; //count保留符合的subarray
                res += end - start + 1; //只要符合就要累加比如2,2,2就是6个
            } else if (A[end] < L) {
                res += count; //此时比如2,1,2 count遇到小于L的不reset因为后面的可能在范围内
            } else { //最大的已经超过，重新reset
                start = end + 1;
                count = 0;
            }
        }
        return res;
    }
}

 
