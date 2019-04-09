class Solution {
    private TreeMap<Integer, int[]> map; //用map原因，不用重复遍历rects, 有ceilingkey可随机取
    private Random rand;
    private int area = 0; 
    public Solution(int[][] rects) {
        map = new TreeMap<>();
        rand = new Random();
        for (int[] rect : rects) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            area += (x2 - x1 + 1) * (y2 - y1 + 1);
            map.put(area, rect); //因为多次call所以不能每次都遍历，题目要求均匀取点，所以按照area才是概率相等（看做连续的），用area来做key
        }
    }
    
    public int[] pick() {
        int key = map.ceilingKey(rand.nextInt(area) + 1);
        int[] curRect = map.get(key);
        int x1 = curRect[0], y1 = curRect[1], x2 = curRect[2], y2 = curRect[3];
        int x = x1 + rand.nextInt(x2 - x1 + 1), y = y1 + rand.nextInt(y2 - y1 + 1);
        return new int[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
