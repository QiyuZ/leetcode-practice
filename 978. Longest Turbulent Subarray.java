class Solution {
    public int maxTurbulenceSize(int[] A) {
        int pre = 0, cur = 0, len = 1, res = 1;
        for (int i = 0; i < A.length - 1; i++) {
            cur = getCur(A, i);
            if (cur * pre == -1) len++; //说明大小交替
            else if (cur == 0) len = 1; //相等
            else len = 2; //-1-1或者11，那么就是两个数符合
            res = Math.max(res, len); //此处每次更新res，不放在if里面，减少分类讨论，否则后两种情况都要处理res的更新和len的初始值问题
            pre = cur;
        }
        return res;
    }
    
    private int getCur(int[] A, int i) {
        if (A[i] == A[i + 1]) return 0;
        else if (A[i] < A[i + 1]) return -1;
        else return 1;
    }
}
