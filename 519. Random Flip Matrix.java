class Solution {
    
    private int rows, cols, total;
    private Map<Integer, Integer> map;
    private Random rand;
    
    public Solution(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows; 
        cols = n_cols; 
        total = rows * cols;
    }
    
    public int[] flip() {
        int r = rand.nextInt(total--);
        int pos = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[] {pos / cols, pos % cols};
    }
    /*Fisher–Yates shuffle
    每次随机到一个数字，然后在字典中查，如果这个数字不在字典中，表示这个数字还没被选中过，
    那么就直接返回这个数字，把这个数字和末尾数字交换；如果随机数已经在字典中出现过，那么说明这个位置已经被选中过，
    使用字典里保存的交换后的数字返回。*/
    
    public void reset() {
        map.clear();
        total = rows * cols; //注意要变回去因为total此时已经改变
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
