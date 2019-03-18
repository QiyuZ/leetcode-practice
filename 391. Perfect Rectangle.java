class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;
        int area = 0;
        int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int [] points : rectangles) {
            x1 = Math.min(points[0], x1);
            y1 = Math.min(points[1], y1);
            x2 = Math.max(points[2], x2);
            y2 = Math.max(points[3], y2);
            area += (points[2] - points[0]) * (points[3] - points[1]);
            String s1 = points[0] + "-" + points[1], s2 = points[0] + "-" + points[3];
            String s3 = points[2] + "-" + points[1], s4 = points[2] + "-" + points[3];
            if (!set.add(s1)) set.remove(s1); //已经有的说明不是顶点，是重合的
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        if (!set.contains(x1 + "-" + y1) || !set.contains(x1 + "-" + y2) || !set.contains(x2 + "-" + y1) || !set.contains(x2 + "-" + y2) || set.size() != 4) return false;
        
        return area == (x2 - x1) * (y2 - y1);
    }
}
/*
两个条件一是总面积相等，并且四个顶点和构成的大长方形一样
比如[[0,0,1,1],[0,1,3,2],[1,0,2,2]]
有重合面积一样但是四个点无法构成
*/
