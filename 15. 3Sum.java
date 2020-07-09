class Solution {
    public List<List<Integer>> threeSum(int[] nums) { //O(n^2)
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; //避免重复
            int l = i + 1, r = n - 1;
            while (l < r) {
                //如果此时同二分法则为O(n^2logn)因为不是动态的每次都要重新找，下面这样做找到一组不停止，因为还可能有更多答案接着找
                if (nums[l] + nums[r] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < n && nums[l + 1] == nums[l]) l++; //避免重复
                    while (r - 1 >= 0 && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } 
                else if (nums[l] + nums[r] + nums[i] > 0) r--;
                else l++;
            }
        }
        return res;
    }
}
