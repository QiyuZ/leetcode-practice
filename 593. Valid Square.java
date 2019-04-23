class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = getDist(p1, p2);
        if (d1 == 0 || d1 != getDist(p3, p4)) return false;
        double d2 = getDist(p1, p3);
        if (d2 == 0 || d2 != getDist(p2, p4)) return false;
        double d3 = getDist(p1, p4);
        if (d3 == 0 || d3 != getDist(p2, p3)) return false;
        if (d1 == d2 || d1 == d3 || d2 == d3) return true;
        return false;
    }
    private double getDist(int[] p1, int[] p2) {
        return (double)(p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}

/*
至少有两个是距离相等，而且22互等

如果是长方形，则找出中心到四个点距离相等
*/
