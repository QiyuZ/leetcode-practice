class Solution {
    private Set<String> set = new HashSet<>();
    private Map<Character, String> map = new HashMap<>();
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null) return str == null;
        if (pattern.isEmpty()) return str.isEmpty();
        char cur = pattern.charAt(0);//一个个处理，所以找首位
        if (map.containsKey(cur)) {
            String val = map.get(cur);
            int len = val.length();
            if (len > str.length() || !val.equals(str.substring(0, len))) return false;//注意此处val可能比剩下的str要长
            return wordPatternMatch(pattern.substring(1), str.substring(len));
        } else {
            for (int i = 1; i <= str.length(); i++) { //注意此处是<=因为用substring最后一位不包含
                String word = str.substring(0, i);
                if (set.contains(word)) continue;
                set.add(word);
                map.put(cur, word);
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) return true;
                set.remove(word); //注意要remove 防止影响下面的backtracking
                map.remove(cur);
            }
        }
        return false;
    }
}

