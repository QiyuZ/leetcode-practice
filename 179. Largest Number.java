class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) s_nums[i] = nums[i] + "";
        Arrays.sort(s_nums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); //合起来大的放到前面,两个最大化整体也会最大
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s_nums.length; i++) sb.append(s_nums[i]);
        return s_nums[0].charAt(0) == '0' ? "0" : sb.toString(); //可能全是0
    }
}
