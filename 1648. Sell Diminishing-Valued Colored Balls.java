class Solution {
    private static final int MOD = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
        if (inventory == null || inventory.length == 0) return 0;
        Arrays.sort(inventory);
        int curIndex = inventory.length - 1, curVal = inventory[curIndex];
        long profit = 0;
        while (orders > 0) {
            while (curIndex >= 0 && inventory[curIndex] == curVal) curIndex--;
            int nextVal = curIndex < 0 ? 0 : inventory[curIndex];
            int sameColor = inventory.length - 1 - curIndex; //note here we use arr length because it always comsume from most right one, like [3,6,6] -> [3,3,3]
            int count = sameColor * (curVal - nextVal);
            if (orders >= count) {
                profit += (long)(curVal + nextVal + 1) * (curVal - nextVal) / 2 * sameColor; //just Arithmetic seq, like [3,6,6] we will take 6,5,4 (not 3) so the first one is curVal and last one is nextVal+1. Note that's for one seq, so we need to multiply sameColor
            } else {
                int times = orders / sameColor;
                int remainder = orders % sameColor;
                //like [3,6,6], we just need 5 orders, so times=2, remainder=1, so it needs to take 6,5 for every one. So the last element for Arithmetic seq is curVal-times+1
                //now it's [3,4,4] so now the current one will be curVal-times, take remainder count of it
                profit += (long)(curVal + (curVal - times + 1)) * times / 2 * sameColor;
                profit += (long)(curVal - times) * remainder;
            }
            orders -= count;
            profit %= MOD;
            curVal = nextVal; //after it becomes [4,4,4], the val should be the next, but it still iterates from right one;
        }
        return (int)profit;
    }
}
