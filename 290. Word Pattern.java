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

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+"); //note it's \\ not //
        if (pattern.length() != words.length) return false;
        Map<Object, Integer> map = new HashMap<>(); //index map to record the pattern and its word's index, if the followings are not the same, then it means it cant be mapped 
        for (int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            if (!map.containsKey(cur)) map.put(cur, i);
            if (!map.containsKey(words[i])) map.put(words[i], i);
            if (!map.get(cur).equals(map.get(words[i]))) return false;
        }
        return true;
    }
}


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s+");
        if (words.length != pattern.length()) return false;
        Map<Character, String> dict = new HashMap();
        Set<String> set = new HashSet();
        for (int i = 0; i < words.length; ++i) {
        	char c = pattern.charAt(i);
        	if (!dict.containsKey(c)) {
        	    if (!set.add(words[i])) return false;
        		dict.put(c, words[i]);
        	} else if (!dict.get(c).equals(words[i])) return false;
        }
        return true;
    }
}
