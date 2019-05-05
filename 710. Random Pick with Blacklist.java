class Solution {
    private int m;
    private Random rand;
    private Map<Integer, Integer> map;
    //一般思路，一直nextInt直到找到不在black里面的，但是要多次recall nextInt
    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        for (int b : blacklist) map.put(b, -1);
        m = N - blacklist.length; 
        //使用的个数，我们只用这个集合，但是有的有效数字在这个集合外，解决方式是吧这个范围内黑名单的数字映射给m范围外但是不在黑名单的数字
        //比如 N = 10 black= [3, 5], 那么就映射 3->9 5->8 , 取随机数只在[0, 8)，这样9,8也可以取到了
        for (int b : blacklist) {
            if (b < m) {
                while (map.containsKey(N - 1)) N--;
                map.put(b, N - 1);
                N--;
            }
        }
        
        rand = new Random();
    }
    
    public int pick() {
        int res = rand.nextInt(m);
        return map.containsKey(res) ? map.get(res) :res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
