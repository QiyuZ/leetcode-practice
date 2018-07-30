class Solution {
    public boolean search(int[] nums, int target) { //注意只能是  先降后升或者先升后降
        if (nums == null || nums.length == 0) return false;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) { //三种情况
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) { //左右中三者相等无法判断先降后升还是先升后降，各缩小一步范围
                start++;
                end--;
            } else if (nums[mid] >= nums[start]) { //先升后降
                if (target >= nums[start] && target <= nums[mid]) end = mid; //如果target再升中，就不用考虑后半段
                else start = mid; //反之不考虑前面的
            } else {//先降后升，同理
                if (target >= nums[mid] && target <= nums[end]) start = mid; 
                else end = mid;
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;
    }
}
//注意规范二分法写法
