class Solution {
    public int smallestRangeI(int[] A, int k) {
        if (A.length == 1) return 0;
        int min = 10001, max = -1;
        for (int a : A) {
            if (a > max) max = a;
            if (a < min) min = a;
        }
        return (max - min < 2 * k) ? 0 : (max - min - 2 * k);
    }
}
