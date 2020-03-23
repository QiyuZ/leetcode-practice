class Solution {
    private static final int[] nums = new int[] {0, 1, 6, 8, 9};
    private static final Map<Integer, Integer> map = new HashMap<>();
    private int count, N;
    static {
        map.put(0, 0); map.put(1, 1); map.put(6, 9); map.put(8, 8); map.put(9, 6);
    }
    public int confusingNumberII(int N) {
        this.N = N;
        count = 0;
        dfs(0);
        return count;
    }
    
    private void dfs(long start) {
        if (start > N) return;
        if (isConfusing(start)) count++;
        for (int i = start == 0 ? 1 : 0; i < nums.length; i++) { //此处注意不可以一直是0否则无法退出，如果start是0，要从1开始
            dfs(start * 10 + nums[i]);
        }
    }
    
    private static boolean isConfusing(long N) { //注意此处要用long防止越界
        long res = 0, copy = N;
        while (copy != 0) {
            res = res * 10 + map.get((int)copy % 10); //此处要转换成int
            copy /= 10;
        }
        return res != N;
    }
}
