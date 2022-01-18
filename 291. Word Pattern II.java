class Solution {
    private Map<Character, String> map = new HashMap<>();
    private Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) { //backtracking O(n * n choose m) n=len of s, m len of pattern
        if (pattern == null) return s == null;
        if (pattern.isEmpty()) return s.isEmpty();
        char cur = pattern.charAt(0);
        if (map.containsKey(cur)) {
            if (!s.startsWith(map.get(cur))) return false;
            return wordPatternMatch(pattern.substring(1), s.substring(map.get(cur).length()));
        }
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (!set.add(word)) continue; //note, dont return false as we can continue to search
            map.put(cur, word);
            if (wordPatternMatch(pattern.substring(1), s.substring(word.length()))) return true;
            set.remove(word); //dont forget to remove
            map.remove(cur);
        }
        return false;
    }
}
