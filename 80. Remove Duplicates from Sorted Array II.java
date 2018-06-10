class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int count = 2; 
        for (int i = 2; i < nums.length; i++) {//从2开始，因为是排好序的并且最多可以有两个
            if (nums[i] != nums[count - 1] || nums[i] != nums[count - 2]) nums[count++] = nums[i];
            //有一个不相等就紧跟着补位
        }
        return count;
    }
}
