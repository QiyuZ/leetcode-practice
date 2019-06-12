class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;
        int up = 0, down = 0, res = 0; //标记几个上升，几个下降
        for (int i = 1; i < A.length; i++) {
            if (down > 0 && A[i] > A[i - 1] || A[i - 1] == A[i]) { //已经下降但是下一个是上升则reset
                up = 0;
                down = 0;
            }
            if (A[i] > A[i - 1]) up++;
            if (A[i] < A[i - 1]) down++;
            if (down != 0 && up != 0) res = Math.max(down + up + 1, res); //up, down不是原始状态
        }
        return res;
    }
}
