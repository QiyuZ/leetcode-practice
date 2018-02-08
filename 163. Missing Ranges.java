class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            long start = i == 0 ? (long)lower : (long)nums[i - 1] + 1;//注意这要用long否则max+1就成负数了
            long end = i == nums.length ? (long)upper : (long)nums[i] - 1;
            addRange(start, end, res);
        }
        return res;
    }
    //先找到可能的区间然后在函数里判断是否成立
    public void addRange(long start, long end, List<String> res) {
        if (start > end) return;
        if (start == end) res.add(start + "");
        else res.add(start + "->" + end);
    }
}
