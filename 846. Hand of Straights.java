class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length % W != 0) return false;
        if (W == 1) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) map.put(num, map.getOrDefault(num, 0) + 1);
        Arrays.sort(hand); //排序才能从小的开始
        for (int num : hand) {
            if (map.get(num) == 0) continue;
            for (int i = 0; i < W; i++) {
                if (!map.containsKey(num + i) || map.get(num + i) == 0) return false;
                map.put(num + i, map.get(num + i) - 1);
            }
        }
        return true;
    }
}

