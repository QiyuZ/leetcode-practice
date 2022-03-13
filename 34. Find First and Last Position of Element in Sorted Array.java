class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) return new int[] {-1, -1};
        int first = binarySearch(nums, target);
        if (nums[first] != target)  return new int[] {-1, -1}; //note it could be non-existed
        int second = binarySearch(nums, target + 1); // find next one, even it doesn't exist, it should stop at the next pos of target
        return new int[] {first, second - 1};
    }
    
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length; //note here we use nums.length as in some case if it doesn't exist we wish it stop at nums.length pos. eg. [5,10, 10] when search 11, it should stop at nums.length
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid; //coz we are trying to find the first one
            else l = mid + 1;
        }
        return l;
    }
}
