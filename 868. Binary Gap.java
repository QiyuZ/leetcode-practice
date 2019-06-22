class Solution {
    public int binaryGap(int N) {
        int res = 0, pos = -1, pre = -1; //上一个1的位置和当前的
        while (N != 0) {
            pos++;
            if ((N & 1) == 1) { //当前是1就记录距离
                if (pre != -1) res = Math.max(res, pos - pre);
                pre = pos; //更新pre
            }
            N = N >> 1; //向右移
        }
        return res;
    }
}
