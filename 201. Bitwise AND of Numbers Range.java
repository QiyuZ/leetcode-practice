class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //for循环直接做是通不过的，可发现and其实是找所有数字的相同问位置，因为是连续的，所以相同位置必在前面，比如[26, 30]
        //11010　　11011　　11100　　11101　　11110，所以思路就是不断右移看两者什么时候相等，即找到相等的在前面的1，再把变过的数变回去
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
}
