class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) { //sliding window
        int maxChanged = 0, base = 0, changed = 0; //分成本来就满意的和可以被改变的
        for (int i = 0; i < customers.length; i++) {
            if (i >= X) changed -= grumpy[i - X] == 0 ? 0 : customers[i - X]; 
            if (grumpy[i] == 0) base += customers[i];
            else changed += customers[i];
            maxChanged = Math.max(changed, maxChanged);
        }
        return maxChanged + base;
    }
}
