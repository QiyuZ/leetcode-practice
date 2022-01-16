class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = -1, res = 0;
        for (int r = 0; r < seats.length; r++) {
            if (seats[r] == 1) {
                if (l == -1) res = r; //说明前面没有1，则可以坐在0 index这样res就是现在的r 
                else res = Math.max(res, (r - l) / 2); //一般情况左右有人，找中间位置
                l = r; //更新左边人的位置
            }
        }
        return Math.max(res, seats.length - 1 - l); //最后如果右边没人则坐最右边此时直接减去l就行，如果右边有人那么seats.length - 1 == l 计算也无所谓
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) return 0;
        int n = seats.length, start = 0, end = n - 1;
        while (start < n && seats[start] == 0) start++; //either seat in 2 sides
        while (end >= 0 && seats[end] == 0) end--;
        int cur = 0, maxZero = 0;
        for (int i = start; i <= end; i++) { //or in the middle
            if (seats[i] == 1) {
                maxZero = Math.max(maxZero, cur);
                cur = 0;
            } else cur++;
        }
        return Math.max((maxZero + 1) / 2, Math.max(start - 0, n - 1 - end)); //note here maxZero + 1 to ensure we dont need to handle even or odd cases
    }
}
