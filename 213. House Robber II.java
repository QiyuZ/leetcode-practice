class Solution {
    public int rob(int[] nums) {//因为首尾不能相接，所以两大类情况，0到n-1或者1到最后
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1)); 
        //必须两个都算，不能比两端和然后只算最大的，因为两端的不一定用的上，eg.[2,7,9,3,1] 2+3<7+1但是用前面的
    }
    
    private int rob(int[] nums, int start, int end) {
        int rob = 0, notRob = 0;
        for (; start <= end; start++) {
            int curRob = notRob + nums[start];
            int curNot = Math.max(rob, notRob);
            rob = curRob;
            notRob = curNot;
        }
        return Math.max(rob, notRob);
    }
}
