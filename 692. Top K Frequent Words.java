//O(nlogn) PQ+map

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        PriorityQueue<String> queue = new PriorityQueue<String>((a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a));
        Set<String> set = new HashSet<>();
        for (String w : words) {
            if (set.add(w)) queue.offer(w);
        } 
        while (k-- > 0) res.add(queue.poll());
        return res;
    }
}
//Second one O(nlogK) reverse order pq+map

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                 (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) queue.poll();
        } 
        while(!queue.isEmpty()) res.add(0, queue.poll().getKey());
        return res;
    }
}
//Third one bucket sort, should be O(n) but sort the string order needed, it should be O(KlogK)

class Solution {
    public List<String> topKFrequent(String[] words, int k) { //O(n)
        List<String> res = new ArrayList<>();
        if (k <= 0 || k > words.length) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String num : words) map.put(num, map.getOrDefault(num, 0) + 1);
        List<String>[] bucket = new ArrayList[words.length + 1];
        for (String key : map.keySet()) {
            if (bucket[map.get(key)] == null) bucket[map.get(key)] = new ArrayList<>();
            bucket[map.get(key)].add(key);
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                for (int j = 0; j < bucket[i].size(); j++) {
                    res.add(bucket[i].get(j));
                    k--;
                    if (k == 0) return res;
                } 
            }
        }
        return res;
    }
}
