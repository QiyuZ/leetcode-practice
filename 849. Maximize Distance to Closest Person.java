class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) return 0;
        int res = 0, i = 0, j = 0;
        for (; j < seats.length; j++) {
            if (seats[j] == 1) {
                if (i == 0) res = j; //在开头可以在最边上
                else res = Math.max(res, (j - i + 1) / 2); //在中间
                i = j + 1; //i移到下一个位置，如果是连续1会一直移动
            }
        }
        return Math.max(res, seats.length - i); //考虑结尾可能有特殊情况
    }
}
