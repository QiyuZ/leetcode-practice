class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y == z || x == z || y == z) return true;
        if (x + y < z) return false;
        return z % GCD(x, y) == 0;
    }
    public int GCD(int x, int y) {
        if (x == 0) return y;
        else return GCD(y % x, x);
    }
}

/*
x = 4, y = 6, z = 8.

GCD(4, 6) = 2

8 is multiple of 2

so this input is valid and we have:

-1 * 4 + 6 * 2 = 8
*/
