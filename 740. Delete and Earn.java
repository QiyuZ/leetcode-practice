class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[10001];
        for (int num : nums) sum[num] += num;
        for (int i = 2; i < 10001; i++) sum[i] = Math.max(sum[i - 1], sum[i - 2] + sum[i]);
        return sum[10000];
    }
}

/*题目中说的是取一个去一个但是是可以成群操作的，比如
[2, 2, 3, 3, 3, 4] 取2或者4，最后结果就是3全删去，224;取3结果就是333，规律就是其实就是隔一个取一个（相同的数）
因为最多10000个，建立10001个bucket来装，然后看怎么取最好 */
