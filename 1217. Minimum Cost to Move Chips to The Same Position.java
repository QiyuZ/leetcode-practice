class Solution {
    //interesting question. Every even pos chip can move to any even pos for free, because we can move it for several times (like [1, 100000] only cost 1 because like 1 can move to 0 costing 1 and 100000 can move to 0 for free, or 100000 moves to 0 for free and then cost 1 to move to pos 1). 
    //Then every odd pos chip just need to cost 1 to move to even and then for free. As the final pos should either be odd or even pos, so we can just count for odd and even number to get the smaller one, which means the final pos should be even or odd.
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int n : position) {
            if (n % 2 == 0) even++;
            else odd++;
        }
        return Math.min(even, odd);
    }
}
