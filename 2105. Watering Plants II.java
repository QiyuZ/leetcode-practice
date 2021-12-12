class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        if (plants == null) return 0;
        int l = 0, r = plants.length - 1;
        int fillA = capacityA, fillB = capacityB;
        int res = 0;
        while (l <= r) {
            if (l == r) {
                res = plants[l] > Math.max(capacityA, capacityB) ? res + 1 : res;
                return res;
            }
            if (plants[l] > capacityA) {
                res++;
                capacityA = fillA - plants[l];
            } else capacityA -=  plants[l];
            l++;
            if (plants[r] > capacityB) {
                res++;
                capacityB = fillB - plants[r];
            } else capacityB -= plants[r];
            r--;
        }
        return res;
    }
}
