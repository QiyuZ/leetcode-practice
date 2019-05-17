class Solution {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i + 1 < row.length; i += 2) {
            map.put(row[i], row[i + 1]);
            map.put(row[i + 1], row[i]);
        }
        int res = 0;
        for (int i = 0; i + 1 < row.length; i += 2) {
            if (map.get(i) != i + 1) { //应该挨着
                int cur = map.get(i);
                int next = map.get(i + 1);
                map.put(cur, next);
                map.put(next, cur);
                res++;
            }
        }
        return res;
    }
}

/*
02 20 13 31 23 32


*/
