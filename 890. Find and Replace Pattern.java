class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        String mode = "";
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c)) mode += map.get(c);
            else {
                mode += (++count);
                map.put(c, count);
            }
        } 
        
        for (String w : words) {
            map.clear();
            count = 0;
            String cur = "";
            for (char c : w.toCharArray()) {
                if (map.containsKey(c)) cur += map.get(c);
                else {
                    cur += (++count);
                    map.put(c, count);
                }
            } 
            if (mode.equals(cur)) res.add(w);
        }
        return res;
    }
}
