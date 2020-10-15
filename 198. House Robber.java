class Solution {
    public int rob(int[] nums) {
        int rob = 0, notRob = 0;
        for (int num : nums) {
            int curRob = notRob + num;
            int curNot = Math.max(rob, notRob);
            rob = curRob;
            notRob = curNot;
        }
        return Math.max(rob, notRob);
    }
}

class Solution {
    public int rob(int[] nums) {      
        if(nums.length == 0) return 0; 
        int length = nums.length;
        int S[] = new int[length+1];
        S[0] = 0;
        S[1] = nums[0];
        for(int i=1; i<length; i++) {
            S[i+1] = Math.max(S[i], (S[i-1] + nums[i])); //下一个等于当前的，或者是前一个+下一个值
        }
        return S[length];        
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int pre = nums[0], cur = Math.max(nums[0], nums[1]), res = cur; //可以dp但是发现其实只取决于前一个和前前一个所以可以直接用变量
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = res;
        }
        return res;
    }
}
