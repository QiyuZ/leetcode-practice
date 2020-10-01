class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() == 0) return 0;
        int size = arrays.size();
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = 0;
        for (int i = 1; i < size; i++) { //carry 最大和最小比较这样保证都可以比较到而且不会同一个数组的最大最小相减
            List<Integer> cur = arrays.get(i);
            res = Math.max(Math.max(max - cur.get(0), cur.get(cur.size() - 1) - min), res);
            min = Math.min(min, cur.get(0));
            max = Math.max(max, cur.get(cur.size() - 1));
        }
        return res;
    }
}
