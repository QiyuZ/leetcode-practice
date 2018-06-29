class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            int j = i, k = getNext(nums, i);
            while (nums[i] * nums[k] > 0 && nums[i] * nums[getNext(nums, k)] > 0) { //这里是检查方向相同，即两个同正或同负
                if (j == k) {
                    if (j == getNext(nums, j)) break; //注意这里要break这个while不然出不来比如[-1, 2]说明以这个index起始的不成立
                    return true;
                } 
                j = getNext(nums, j); //不相等就接着走
                k = getNext(nums, getNext(nums, k));
            }
            
        }
        return false;
    }
    public int getNext(int[] nums, int n) {
        return (n + nums[n]) >= 0 ? (n + nums[n]) % nums.length : nums.length + ((nums[n] + n) % nums.length); 
        //注意，小于时是负数所以是nums.length +
    }
}
/*快慢指针，当两者重合且慢的下一个不是自身说明成立*/
