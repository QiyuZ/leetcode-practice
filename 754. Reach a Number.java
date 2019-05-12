class Solution {
    public int reachNumber(int target) {
        int step = 1, sum = 0;
        target = Math.abs(target);
        while (sum < target || (sum - target) % 2 != 0) sum += step++;
        return step - 1;
    }
}
/*当target>sum 就直接加，如果相差为偶数其实相当于把那个差/2对应的那个数变成负数即可
如果差为基数，那么继续走，直到为偶数再采取相同策略

*/
