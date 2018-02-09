//使用map带记忆更快
class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }
    public boolean helper(String s, Map<String, Boolean> map) {
        if (s == null || s.length() < 2) return false;
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opp = s.substring(0, i) + "--" + s.substring(i + 2); 
                if (!helper(opp, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}

//不带记忆的backtracking
public boolean canWin(String s) {
    if (s == null || s.length() < 2) return false;
    for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
            String t = s.substring(0, i) + "--" + s.substring(i + 2);
            if (!canWin(t)) return true;
        }
    } 
    return false;
}
