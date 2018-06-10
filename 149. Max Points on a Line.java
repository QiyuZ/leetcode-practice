/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samep = 0;
            int samex = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) samep++; //有可能相同两个点，但会和当前点k=0,所以要考虑重复的
                    if (points[i].x == points[j].x) {  //垂直x轴，k无穷大，不用计算下面的，直接算上
                        samex++; 
                        continue; //不存在可计算K直接跳过
                    }
                    int num = points[j].y - points[i].y;
                    int denum = points[j].x - points[i].x;
                    int gcd = gcd(denum, num);
                    String k = (num/gcd) + "-" + (denum/gcd);
                    //这样表达的原因是有时数字很大会有精度问题，写成计算前的方式不会出错，用-连接也不会有重复的情况
                    if (map.containsKey(k)) map.put(k, map.get(k) + 1);
                    else map.put(k, 2);
                    res = Math.max(map.get(k) + samep, res); //别忘记重复的点
                }
            }
            res = Math.max(res, samex);//别忘记垂直x轴的直线
        }
        return res;
    }
    
    public int gcd(int a, int b) { //求最大公约数
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
