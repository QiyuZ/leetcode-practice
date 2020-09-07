class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        String[] words = str.split("\\s+");
        if (pattern.length() != words.length) return false;
        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            Character pre = map.get(words[i]);
            if (pre == null && set.contains(cur)) return false;
            else if (pre == null) map.put(words[i], cur);
            else if (pre != cur) return false;
            set.add(cur);
        }
        return true;
    }
}
