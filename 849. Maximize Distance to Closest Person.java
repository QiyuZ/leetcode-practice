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
