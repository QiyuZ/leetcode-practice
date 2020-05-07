class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, res = nums[0]; //大于一半次数的顶多一个，不用记录每个准确的次数，count只计算相对的次数
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) res = nums[i];
            if (res == nums[i]) count++;
            else count--;
        }
        return res;
    }
}
