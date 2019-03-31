class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) return 0;
        Map<Integer, Integer>[] maps = new HashMap[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for (int j = 0; j < i; j++) {
                if((long)num - A[j] > Integer.MAX_VALUE) continue; //可能一正一负这样可能越界
                if((long)num - A[j] < Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                res += count; 
                //直接加的原因是如果是0无所谓，如果>=1那么j和它之前有个数相差diff，再加上A[i]正好三个， 比如2,4,6，j是4，ishi 6
                maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1); //update maps[i]
            }
        }
        return res;
    }
}
