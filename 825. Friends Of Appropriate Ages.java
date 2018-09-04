class Solution {
    public int numFriendRequests(int[] ages) {
        int[] map = new int[121]; //每个年龄有多少人, 优化1 不用map用常数大小数组，这样时间和空间都是O（1）
        for (int age : ages) map[age]++;
        int count = 0;
        for (int i = 0; i <= 120; i++) {
            for (int j = 0; j <= 120; j++) {
                if (valid(i, j)) count += map[i] * (i == j ? map[j] - 1 : map[j]); //注意i,j相等不能skip，因为可能多个相等年龄
            }
        }
        return count;
    }
    public boolean valid(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100)); //其实条件2和3重复了
    }
}

class Solution {
    public int numFriendRequests(int[] ages) { //优化2，另一数组sums记录范围，这样计算count不用2 for，直接找范围内个数即可
        int[] nums = new int[121], sums = new int[121];
        for (int age : ages) nums[age]++; //记录每个年龄多少人
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i]; //相当于记录小于i的有多少人
        int res = 0;
        for (int i = 15; i < sums.length; i++) { //i / 2 + 7 < i -> i>14
            if (nums[i] == 0) continue; //0一定要跳过，否则后面是负数
            int count = sums[i] - sums[i / 2 + 7]; //(i/2+7, i] 有多少个
            res += (count - 1) * nums[i]; //不能和自身request
        }
        return res;
    }
}
