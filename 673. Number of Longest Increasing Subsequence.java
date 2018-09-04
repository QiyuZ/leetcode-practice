class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 0, res = 0;
        int[] len = new int[n], count = new int[n];
        //len[i] 以nums[i]结尾的目前最大片段长度，count[i] 以nums[i]结尾的目前最大片段长度的个数（有几种path）
        for (int i = 0; i < n; i++) {
            len[i] = 1; //初始化，单个算1
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //大于说明递增了，再考虑
                    if (len[i] == len[j] + 1) count[i] += count[j]; //说明发现新路径，而最大len不变 （+1是当前的）
                    else if (len[i] < len[j] + 1) { //说明这个路径不是最大的，更新成最大的
                        count[i] = count[j];
                        len[i] = len[j] + 1; //（+1是当前的）
                    }
                } 
            }
            max = Math.max(max, len[i]);
        }
        
        for (int i = 0; i < len.length; i++) {
            if (len[i] == max) res += count[i];
        }
        return res;
    }
}
