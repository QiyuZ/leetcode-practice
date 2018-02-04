class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        if (words1.length != words2.length) return false;
        for (String[] pair : pairs) {
            Set<String> set0 = map.getOrDefault(pair[0], new HashSet<>());
            set0.add(pair[1]); //正着反着都加一边，这样确保有对应
            map.put(pair[0], set0);
            Set<String> set1 = map.getOrDefault(pair[1], new HashSet<>());
            set1.add(pair[0]);
            map.put(pair[1], set1);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i])) return false;
            if (!dfs(words1[i], words2[i], map, new HashSet<>())) return false;
        }
        return true;
    }
    
    public boolean dfs(String a, String b, Map<String, Set<String>> map, Set<String> visited) {
        if (map.get(a).contains(b)) return true;
        visited.add(a);
        for (String s : map.get(a)) {
            if (!visited.contains(s) && dfs(s, b, map, visited)) return true;
        }
        return false;
    }
}
