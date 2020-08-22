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


class Solution {
    private final int[] sums;
    private final int[][] rects;
    private final Random rand = new Random();
    
    // for rects = [[1, 1, 2, 4], [3, 2, 5, 4], [2, 5, 5, 6]]
    // sum is [8, 17, 25]
    
    public Solution(int[][] rects) {
        this.rects = rects;
        sums = new int[rects.length];
        int sum = 0, index;
        for (int i = 0; i < rects.length; i++)
        {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sums[i] = sum;
        }
    }
    
    public int[] pick() {
        int lo = 0, hi = sums.length - 1;
        int target = rand.nextInt(sums[sums.length - 1]);
        
        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            
            if (sums[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        
        int[] rect = rects[lo];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int base = sums[lo] - width * height;
        return new int[]{rect[0] + (target - base) % width, rect[1] + (target - base) / width};
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
