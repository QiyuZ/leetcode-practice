class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= res[i];
        }
        return res;
    }
}
//除了本身的乘积，那么就循环两次，第一次乘上这个数之前的，第二次乘上之后的
