class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        int diff = 0;
        for (int num : nums) diff ^= num; //diff为single number a,b的异或
        for (int i = 0; i < 32; i++) { //只知道a,b的异或可以用它来分组，从右第一个的1就是分组标准，因为它说明一定是有一个是0，一个是1
            if (((1 << i) & diff) != 0) {//注意不是==1因为可以是10,100这样
                diff = (1 << i); //找到比如10，是a=3, b=1的异或第一个不同的bit
                break;
            } 
        }
        // line 7 to line 12 equals to     
        // 1. diff = Integer.highestOneBit(diff);
        // 2. diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) res[0] ^= num;//等于0则说明是b=1的组
            else res[1] ^= num;
        }
        return res;
    }
}


