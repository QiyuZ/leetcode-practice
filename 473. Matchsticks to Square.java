class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false; 
        for (int num : nums) { //有一个大就不能
            if (num > sum / 4) return false;
        }
        Arrays.sort(nums); //先sort,从大的开始找更快
        int side = sum / 4;
        return helper(nums, nums.length - 1, new int[] {side, side, side, side});
    }
    
    private boolean helper(int[] nums, int i, int[] sides) {
        if (i < 0) return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0; //数字用完看是否全部构成
        for (int j = 0; j < sides.length; j++) {
            if (nums[i] > sides[j]) continue; //当前数字不能用
            sides[j] -= nums[i]; //可以用，剩下长度多少
            if (helper(nums, i - 1, sides)) return true;
            sides[j] += nums[i]; //如果不是这个情况，返回原状
        }
        return false;
    }
}
