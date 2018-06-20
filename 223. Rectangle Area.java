class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int left = Math.max(A, E); //左边的取偏右边的，右边的取偏左边的， 上下同理，检查是否有重合
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int res = area1 + area2;
        if (right > left && top > bottom) res -= (right - left) * (top - bottom);
        return res;
    }
}
