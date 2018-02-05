class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min1 >= nums[i]) min1 = nums[i];
            else if (min2 >= nums[i]) min2 = nums[i];
            else return true;
        }
        return false;
    }
}
//转换问题为找一个数前面有两个数比它大,如果到一个min1,min2都比他小说明前面有两个数比他小了
