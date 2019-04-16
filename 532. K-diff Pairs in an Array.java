class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) res++;
            }  else {
                if (map.containsKey(key + k)) res++;
            }
        }
        return res;
    }
}
