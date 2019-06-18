class Solution {
    public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        while (m * p != n * q) {
            n++; //n++因为 n*q起始是小的
            m = n * q / p; 
        }
        //不存在两个偶数情况，因为可以化简为1,1
        if (m % 2 == 0 && n % 2 == 1) return 0; 
        //可以作图不断做轴对称图像得出 https://leetcode.com/problems/mirror-reflection/discuss/141765/Java-short-solution-with-a-sample-drawing
        if (m % 2 == 1 && n % 2 == 0) return 2;
        if (m % 2 == 1 && n % 2 == 1) return 1;
        return -1;
    }
}
