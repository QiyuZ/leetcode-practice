class Solution {
    public int minAreaRect(int[][] points) {
        if (points.length <= 3) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>()); //题目中说了平行的长方形，所以这里以x,y为轴
            map.get(p[0]).add(p[1]);
        }
        int res = 40000 * 40000;
        for (int[] p1 : points) {
            for (int [] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue; //平行的不要，找对角的
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    res = Math.min(res, (Math.abs(p1[0] - p2[0]) * (Math.abs(p1[1] - p2[1]))));
                }
            }
        }
        return res == 40000 * 40000 ? 0 : res;
    }
}
