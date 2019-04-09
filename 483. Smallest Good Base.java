class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int p = (int)(Math.log(num + 1) / Math.log(2)); p >= 1; p--) { //p为最大长度，因为最小进制为2，最长就是/log（2）
            if ((1 << p) < num) { //num如果小就不可能是这个长度，跳过；因为二进制这是最小的了
                long k = helper(num, p);
                if (k != -1) return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1); //如果都没有就是直接-1的
    }
    private long helper(long num, int p) {
        long l = 1, r = (long)(Math.pow(num, 1.0/p) + 1);
        while (l < r) {
            long mid = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i <= p; i++) { //注意此处是从0开始到第P 位的
                sum += cur; //因为最后结果是111..11所以每个都是乘以1
                cur *= mid;
            }
            if (sum == num) return mid;
            else if (sum > num) r = mid;
            else l = mid + 1;
        }
        return -1;
    }
}
