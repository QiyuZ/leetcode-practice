class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1; //这点注意是1不是0
        for (int i = 0; i < nums.length; i++) {
            //此题虽然没说范围是1——n但是缺失数是按照这个顺序来的，所以按照顺序排好比如[3,4,-1,1]->[1,-1,3,4]
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) { //这里要-1因为不是从0开始的
                //此处注意用while，因为可能把后面大的数移到了前面，所以要多次判断直到满足要求
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1; //找出第一个不满足条件的就是第一个缺失的数
        }
        return nums.length + 1;//没有缺失的则说明少下一个数
    }
}
