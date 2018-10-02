class Solution {
    public int lengthOfLongestSubstring(String s) { //双指针 O（1）空间
        if (s == null || s.length() == 0) return 0;
        boolean[] record = new boolean[256];
        int pos = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (record[cur]) {
                res = Math.max(res, i - pos);
                while (pos < i) {
                    if (cur == s.charAt(pos)) {
                        pos++;
                        break;
                    }
                    record[s.charAt(pos)] = false;
                    pos++;
                }
            }
            else record[cur] = true;
        }
        return Math.max(res, s.length() - pos);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                pos = Math.max(pos, map.get(s.charAt(i)) + 1); //找到最靠后重复的那个
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - pos + 1);
        }
        return res;
    }
}
