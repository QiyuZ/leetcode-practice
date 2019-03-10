class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0, pos = 0;
        while (miss <= n) {
            if (pos < nums.length && miss >= nums[pos]) {
                miss += nums[pos++];
            } else {
                miss *= 2;
                count++;
            }
        }
        return count;
    }
}


/**
miss为可能缺失的数
如果miss比本位数大，说明可以形成这个数，则把它加入扩大sum范围；反之，miss要放入下一个数，相当于翻倍
比如 [1,5,10], miss = 2 < 5, 构不成2，则放入2，翻倍为4
miss = 4 < 5, 构不成4放入4，翻倍为8，即8以内都可以完成，然后+5=13， +10 = 23，均可以构成
[1,2,4,5,10]
*/
