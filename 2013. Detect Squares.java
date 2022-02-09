class DetectSquares {
    private List<int[]> points;
    private Map<String, Integer> counts;
    public DetectSquares() {
        points = new ArrayList<>();
        counts = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        String key = point[0] + "-" + point[1];
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) { //to make this easier and avoid duplicate, we can just find diagnosed one
        int res = 0;
        for (int[] p : points) {
            if (p[0] == point[0] || Math.abs(p[0] - point[0]) != Math.abs(p[1] - point[1])) continue;
            res += counts.getOrDefault(point[0] + "-" + p[1], 0) * counts.getOrDefault(p[0] + "-" + point[1], 0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
