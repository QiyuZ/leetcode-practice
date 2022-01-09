class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String w : startWords) {
            char[] ca = new char[26];
            for (char c : w.toCharArray()) ca[c - 'a']++;
            map.computeIfAbsent(w.length(), s -> new HashSet<>()).add(String.valueOf(ca));
        }
        int res = 0;
        for (String w : targetWords) {
            char[] ca = new char[26];
            for (char c : w.toCharArray()) ca[c - 'a']++;
            for (char c : w.toCharArray()) {
                ca[c - 'a']--; //remove 1 character every time
                int sz = w.length() - 1;
                if (map.containsKey(sz) && map.get(sz).contains(String.valueOf(ca))) {
                    res++;
                    break; //we just need make sure one exists. So don't need to keep checking
                }
                ca[c - 'a']++; //change back
            }
        }
        return res;
    }
}
