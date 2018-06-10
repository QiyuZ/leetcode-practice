class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return nums.length;
        int pos = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[pos]) {
                pos++; //先移动一位，之前的那个没重复的保留，相当于0011， 指针指到第二个0再和后面交换
                int temp = nums[pos];
                nums[pos] = nums[j];
                nums[j] = temp;
            }
        }
        return pos + 1; //最后一个数字的本身
    }
}
