// class Solution {
//     public List<Integer> topKFrequent(int[] nums, int k) { //O(nlogK)
//         List<Integer> res = new ArrayList<>();
//         if (k <= 0 || k > nums.length) return res;
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
//         PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
//         for (int key : map.keySet()) {
//             queue.offer(key);
//             if (queue.size() > k) queue.poll();
//         }
//         while (!queue.isEmpty()) res.add(0, queue.poll());
//         return res;
//     }
// }

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) { //O(n)
        List<Integer> res = new ArrayList<>();
        if (k <= 0 || k > nums.length) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null) bucket[map.get(key)] = new ArrayList<>();
            bucket[map.get(key)].add(key);
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
            if (k <= 0) break;
        }
        return res;
    }
}
