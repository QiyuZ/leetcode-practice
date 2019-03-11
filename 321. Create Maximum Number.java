class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] result1 = findMaxKValue(nums1, i);
            int[] result2 = findMaxKValue(nums2, k - i);
            // 对两个数组执行merge操作
            int[] temp = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;
            while (pos1 < result1.length || pos2 < result2.length){
                temp[tpos++] = compare(result1, pos1, result2, pos2) ? result1[pos1++] : result2[pos2++];
            }
            if (!compare(result, 0, temp, 0))
                result = temp;
        }
        return result;
    }
    private boolean compare(int[] result1, int pos1, int[] result2, int pos2) {
        for ( ; pos1 < result1.length && pos2 < result2.length; pos1++, pos2++){
            if (result1[pos1] > result2[pos2])
                return true;
            if (result1[pos1] < result2[pos2])
                return false;
        }
        return pos1 != result1.length;
    }

    private int[] findMaxKValue(int[] nums, int k) {
        int[] result = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++){
            while (len > 0 && len + nums.length - i > k && result[len - 1] < nums[i]){
                len--;
            }
            if (len < k)
                result[len++] = nums[i];
        }
        return result;
    }

}

/**
1）分别从nums1(长度为m）和nums2（长度为n）中挑选出i（max(0, k - n) <= i <= min(m, k) 和k-i个数，在保持挑选数组的元素相对顺序不变的情况下，使选出的子数组最大化，主要利用贪心算法进行选取；

2）在保持元素相对位置不变的前提下，将数组nums1与nums2合并，使合并的数组最大化。
*/
