class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1]; //1放到第一个，2放到第二个。。负数和超过长度的不用管，说明这一位是漏掉的
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1; //检查哪个被漏掉了
        }
        return nums.length + 1; //如果都没说明中间没有少的比如1,2,3，所以返回下面一个
    }
}
