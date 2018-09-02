class Solution {
    public int minSwap(int[] A, int[] B) {
        int swap = 1, keep = 0, n = A.length;
        for (int i = 1; i < n; i++) {
            int newSwap = swap, newKeep = keep;
            if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) { //必须换
                newSwap = keep + 1; //因为是i - 1大，说明之前没变，要在keep基础上+1
                newKeep = swap; //因为必须换，newkeep等于上一步的swap(上一步swap了，就不会这种必须换的情况了)
            } else if (A[i] > B[i - 1] && B[i] > A[i - 1]) { //可换可不换
                newKeep = Math.min(keep, swap); //取最小
                newSwap = Math.min(keep, swap) + 1; //在最小的基础上换
            } else { //其他情况按照keep和swap设定来，keep不变，swap+1
                newKeep = keep;
                newSwap = swap + 1;
            }
            keep = newKeep;
            swap = newSwap;
        }
        return Math.min(keep, swap);
    }
}
