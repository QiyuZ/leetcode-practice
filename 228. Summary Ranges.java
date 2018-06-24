class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) continue; //连续的就跳过
            if (start == i) list.add(nums[i] + ""); //如果一样说明没有range
            else list.add(nums[start] + "->" + nums[i]);
            start = i + 1; //跳到下一位
        }
        return list;
    }
}
