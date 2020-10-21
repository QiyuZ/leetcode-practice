class Solution {
    public int firstUniqChar(String s) { //One pass
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}

class Solution { //2 passes
    public int firstUniqChar(String s) {
        int[] mark = new int[26];
        for (char c : s.toCharArray()) {
            mark[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (mark[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
