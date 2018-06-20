class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long left = Math.max(rec1[0], rec2[0]);
        long right = Math.min(rec1[2],rec2[2]);
        long bottom = Math.max(rec1[1],rec2[1]);
        long top = Math.min(rec1[3],rec2[3]);
        if (top > bottom && right > left) return true;
        return false;
    }
}
//方法就是rectangle area那题的
