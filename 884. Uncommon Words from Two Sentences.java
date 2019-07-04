class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] a = A.split("\\s+");
        String[] b = B.split("\\s+");
        for (String str : a) map.put(str, map.getOrDefault(str, 0) + 1);
        for (String str : b) map.put(str, map.getOrDefault(str, 0) + 1);
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
             if (map.get(key) == 1) res.add(key);
        }
        return res.stream().toArray(String[]::new);
    }
}
