class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        PriorityQueue<String> queue = new PriorityQueue<String>((a, b) -> map.get(b) != map.get(a) ? map.get(b) - map.get(a) : a.compareTo(b));
        Set<String> set = new HashSet<>();
        for (String w : words) {
            if (set.add(w)) queue.offer(w);
        } 
        while (k-- > 0) res.add(queue.poll());
        return res;
    }
}
