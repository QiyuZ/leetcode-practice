class Solution {
    public int jump(int[] nums) { //greedy
        int cur = 0, pre = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (cur < i) return -1; //无法到达
            cur = Math.max(cur, nums[i] + i);
            if (i == pre) { //当前位置就是上次最大值能到的地方，记录
                count++;
                pre = cur;
            }
        }
        return count;
    }
}
