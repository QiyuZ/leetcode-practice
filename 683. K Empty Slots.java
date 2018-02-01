class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int cur = flowers[i];
            Integer high = set.higher(cur);
            if (high != null && high - cur - 1 == k) return i + 1;
            Integer low = set.lower(cur);
            if (low != null && cur - low - 1 == k) return i + 1;
            set.add(cur);
        }
        return -1;
    }
}
