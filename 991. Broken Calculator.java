class Solution {
    public int brokenCalc(int X, int Y) {
        if (X >= Y) return X - Y; //当 x大可以直接持续-1即可，因为double会更远
        int res = 0;
        while (Y > X) { //直接变y跟简单，操作相反，变为+1和/2
            if (Y % 2 == 1) Y++; //奇数则加
            else Y /= 2; //偶数就除以2减小差距
            res++;
        }
        return res + X - Y; //相当于情况1
    }
}
