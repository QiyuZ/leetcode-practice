class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; //不重复计算相同的
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] < target) l++;
                else if (nums[l] + nums[r] > target) r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; //跳过重复的
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
