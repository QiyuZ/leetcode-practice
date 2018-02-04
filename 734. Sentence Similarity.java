class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>(); //用set因为可能一对多
        for (String[] pair : pairs) {
            Set<String> set0 = map.getOrDefault(pair[0], new HashSet<>());
            set0.add(pair[1]); //正着反着都加一边，这样确保有对应
            map.put(pair[0], set0);
            Set<String> set1 = map.getOrDefault(pair[1], new HashSet<>());
            set1.add(pair[0]);
            map.put(pair[1], set1);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue; //一模一样或者有对应
            if (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) continue;
            return false;
        }
        return true;
    }
}
