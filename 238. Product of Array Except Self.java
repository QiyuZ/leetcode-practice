class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int multi = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = multi;
            multi *= nums[i];
        }
        multi = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= multi;
            multi *= nums[i];
        }
        return res;
    }
}
//除了本身的乘积，那么就循环两次，第一次乘上这个数之前的，第二次乘上之后的, 一正一反避开自己
