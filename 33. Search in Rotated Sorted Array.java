class Solution {
    public int search(int[] nums, int target) { //比81题少了个左中右相等的情况
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            //这里要大于等于因为可能是同一个，比如[3,1] target=3
            if (nums[mid] > nums[start]) {//在左区间
                if (target >= nums[start] && target <= nums[mid]) end = mid;//左区间里
                else start = mid;
            } else {
                if (target >= nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
