class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new TreeMap<>(); //treeMap的key排序，很重要先从小的开始
        for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);
        for (int num : map.keySet()) {
            if (map.get(num) == 0) continue;
            int want = num < 0 ? num / 2 : num * 2; //如果是负数，是要除以
            if (num < 0 && num % 2 != 0 || map.get(num) > map.getOrDefault(want, 0)) return false;
            map.put(want, map.get(want) - map.get(num));
        }
        return true;
    }
}
